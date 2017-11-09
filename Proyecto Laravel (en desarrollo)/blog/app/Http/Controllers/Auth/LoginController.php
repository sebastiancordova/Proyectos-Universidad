<?php

namespace App\Http\Controllers\Auth;

use App\Http\Controllers\Controller;
use App\User;
use Illuminate\Support\Facades\Auth;
use Illuminate\Foundation\Auth\AuthenticatesUsers;
use Laravel\Socialite\Facades\Socialite;
use Illuminate\Support\Str;


class LoginController extends Controller
{
    /*
    |--------------------------------------------------------------------------
    | Login Controller
    |--------------------------------------------------------------------------
    |
    | This controller handles authenticating users for the application and
    | redirecting them to your home screen. The controller uses a trait
    | to conveniently provide its functionality to your applications.
    |
    */

    use AuthenticatesUsers;

    /**
     * Where to redirect users after login.
     *
     * @var string
     */
    protected $redirectTo = '/eventos';

    /**
     * Create a new controller instance.
     *
     * @return void
     */
    public function __construct()
    {
        $this->middleware('guest')->except('logout');
    }

    /**
     * Redirect the user to the GitHub authentication page.
     *
     * @return Response
     */
    public function redirectToProvider($service)
    {
        return Socialite::driver($service)->redirect();
    }

    /**
     * Obtain the user information from GitHub.
     *
     * @return Response
     */
    public function handleProviderCallback($service){
        
        $userSocial = Socialite::driver($service)->user();
        $findUser = User::where('email', $userSocial->email)->first();

        if($findUser){
            Auth::login($findUser);
            return redirect('/eventos');
        }else{
            $user = new User;
            $user->name = $userSocial->name;
            if($service == 'twitter'){
                $user->email = $userSocial->getEmail();
            }
            else{
                $user->email = $userSocial->email;
            }
            $user->avatar = $userSocial->avatar;
            $user->status = 1;
            $user->password = 'password';
            $user->save();

            Auth::login($user);
            return redirect('/eventos');
        }
       
    }
}
