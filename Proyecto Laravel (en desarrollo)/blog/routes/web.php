<?php

/*
|--------------------------------------------------------------------------
| Web Routes
|--------------------------------------------------------------------------
|
| Here is where you can register web routes for your application. These
| routes are loaded by the RouteServiceProvider within a group which
| contains the "web" middleware group. Now create something great!
|
*/
use Illuminate\Support\Facades\Input;
use App\Region;

Route::get('/', function () {
	return view('welcome');
});

Route::get('auth/login', function (){
	return view('auth/login');
});

Route::get('ventajas_premium', function (){
	return view('ventajas_premium');
})->name('ventajasPremium');

Route::get('pago_premium', function (){
	return view('pago_premium');
})->name('pagoPremium');


Route::get('login/{service}', 'Auth\LoginController@redirectToProvider');
Route::get('login/{service}/callback', 'Auth\LoginController@handleProviderCallback');

Route::get('verificaCorreo', 'Auth\RegisterController@verificaCorreo')->name('verificaCorreo');
Route::get('verify/{email}/{verifyToken}','Auth\RegisterController@envioHecho')->name('envioHecho');

Route::post('/password/email', 'Auth\ForgotPasswordController@sendResetLinkEmail')->name('password.email');
Route::get('/password/reset', 'Auth\ForgotPasswordController@showLinkRequestForm')->name('password.request');
Route::post('/password/reset', 'Auth\ResetPasswordController@reset');
Route::get('/password/reset/{token}/{email}', 'Auth\ResetPasswordController@showResetForm')->name('password.reset');
Route::get('pagar_premium', 'PagosController@pagar')->name('pagarPremium');

Auth::routes();


Route::get('/eventos', 'EventosController@index')->name('eventos');

Route::get('edit_evento', function(){
	return view('edit_eventos');
});

Route::group(['prefix' => 'user'], function(){
	Route::resource('eventos', 'EventosController', ['names' => []]);
});

Route::get('eventos/{id}/destroy', 'EventosController@destroy')->name('eventos.destroy');
Route::get('misEventos', 'EventosController@misEventos')->name('misEventos');
Route::get('eventos/aprobar', 'EventosController@aprobarEventos')->name('aprobarEventos');

Route::get('eventos/{id}/aprobar', 'EventosController@eventoAprobar')->name('eventos.aprobar');


Route::get('dropdown_region', function(){
	$id = Input::get('option');
	$provincias = Region::find($id)->provincias;
	return $provincias->pluck('nombre', 'id');
});

Route::get('dropdown_provincia', function(){
	$id = Input::get('option');
	$comunas = App\Provincia::find($id)->comunas;
	return $comunas->pluck('nombre', 'id');
});