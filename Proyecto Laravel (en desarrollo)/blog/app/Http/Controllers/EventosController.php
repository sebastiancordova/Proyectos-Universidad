<?php

namespace App\Http\Controllers;

use Illuminate\Foundation\Validation\ValidatesRequests;
use Illuminate\Support\Facades\Auth;
use Illuminate\Http\Request;
use App\Http\Requests\EventoRequest;
use App\Evento;
use App\Region;
use App\Comuna;
use App\Provincia;


class EventosController extends Controller
{
    /**
     * Display a listing of the resource.
     *
     * @return \Illuminate\Http\Response
     */
    public function index(Request $request)
    {
        if($request->has('buscar')){
            $events = Evento::search($request->buscar)->paginate(6);
        }else{
            $events = Evento::where('estado', '1')->paginate(6);
        }
        return view('home')->with('events', $events);
    }

    /**
     * Show the form for creating a new resource.
     *
     * @return \Illuminate\Http\Response
     */
    public function create()
    {
        return view('user.crear_evento');
    }

    /**
     * Store a newly created resource in storage.
     *
     * @param  \Illuminate\Http\Request  $request
     * @return \Illuminate\Http\Response
     */
    public function store(EventoRequest $request)
    {
        $evento = (new Evento)->fill($request->all());
        $evento->user_id = Auth::id();
        $evento->region_id = $request->region;
        $evento->provincia_id = $request->provincia;
        $evento->comuna_id = $request->comuna;
        $evento->estado = false;
        if($request->hasFile('afiche')){
            
            $evento->afiche = $request->file('afiche')->store('public/afiches');
        }else{
            $evento->afiche = 'public/afiches/afiche_default.png';
        }
        
        $evento->save();
        flash('Evento creado satisfactoriamente')->success();
        return redirect(route('misEventos'));
    }

    /**
     * Display the specified resource.
     *
     * @param  int  $id
     * @return \Illuminate\Http\Response
     */
    public function show($id)
    {
        $evento = Evento::find($id);
        return view('user.info_evento')->with('evento' , $evento);
    }


    /**
     * Show the form for editing the specified resource.
     *
     * @param  int  $id
     * @return \Illuminate\Http\Response
     */
    public function edit($id)
    {
        $event = Evento::find($id);
        return view('user.edit_eventos')->with('evento', $event);
    }

    /**
     * Update the specified resource in storage.
     *
     * @param  \Illuminate\Http\Request  $request
     * @param  int  $id
     * @return \Illuminate\Http\Response
     */
    public function update(EventoRequest $request, $id)
    {
        $evento = Evento::find($id);
        $evento->nombre = $request->nombre;
        $evento->region_id = $request->region;
        $evento->provincia_id = $request->provincia;
        $evento->comuna_id = $request->comuna;
        $evento->direccion = $request->direccion;
        $evento->fecha = $request->fecha;
        $evento->hora = $request->hora;
        $evento->descripcion = $request->descripcion;
        $evento->url = $request->url;

        if($request->hasFile('afiche')){
           $evento->afiche = $request->file('afiche')->store('public/afiches');
        }
        $evento->save();

        flash('Se edito el evento')->success();
        return redirect(route('misEventos'));
    }

    /**
     * Remove the specified resource from storage.
     *
     * @param  int  $id
     * @return \Illuminate\Http\Response
     */
    public function destroy($id)
    {
        $evento = Evento::find($id);
        $evento->delete();

        flash('Se eliminó el evento')->error();
        return redirect(route('misEventos'));
    }

    public function misEventos(){

        $events = Evento::where('user_id', Auth::id())->paginate(6);
        return view('user/mis_eventos')->with('events', $events);
    }

    public function eventoAprobar($id){
        $evento = Evento::find($id);
        $evento->estado = true;
        $evento->save();

        flash('Se aprobó el evento')->error();
        return redirect(route('aprobarEventos'));
    }

    public function aprobarEventos(){
        $events = Evento::where('estado', 'false')->paginate(6);
        return view('admin/aprobar_evento')->with('events', $events);
    }

}
