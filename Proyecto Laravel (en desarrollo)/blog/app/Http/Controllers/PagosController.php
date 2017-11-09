<?php

namespace App\Http\Controllers;

use Illuminate\Support\Facades\Auth;
use Illuminate\Http\Request;
use App\User;
use App\Evento;

class PagosController extends Controller
{
    public function pagar(){
    	$id = Auth::user()->id;
    	$user = User::find($id);
		$user->type = 'premium';
		$user->save();
		flash('Pago acreditado. Ahora eres usuario Premium')->success();

		$events = Evento::orderBy('nombre')->paginate(6);
		return view('home')->with('events', $events);
	
	}
}
