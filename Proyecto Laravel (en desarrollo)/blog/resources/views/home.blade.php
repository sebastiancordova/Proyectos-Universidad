@extends('layouts.app')
@section('content')
    @section('title', 'Eventos' )

    <div class="row">
        @if($events->isEmpty())
            <div class="col-md-12">
                <div class="panel panel-info">
                    <div class="panel-body">
                        <h3 align="center">No hay eventos creados</h3>
                    </div>
                </div>
            </div>
        @endif
        @foreach($events as $event)
        @if($event->estado)
            <div class="col-sm-6 col-md-4">
                <div class="thumbnail">
                    <img src="{{ Storage::url($event->afiche) }}" >
                    <div class="caption">
                        <h3>{{ $event->nombre }}</h3>
                        <p><i class="fa fa-calendar" aria-hidden="true"></i> {{ $event->fecha }}</p>
                        <p><i class="fa fa-map-marker" aria-hidden="true"></i> {{ $event->comuna->nombre }}</p>
                        <p>
                            <a href="{{ route('eventos.show', $event->id) }}" class="btn btn-primary" role="button">Ver mas</a> 
                            <a href="#" class="btn btn-default" role="button">Guardar</a>
                        </p>
                    </div>
                </div>
            </div>
        @endif
        @endforeach
    </div>

    <div align="center">
        {!! $events->render() !!}
    </div>
@endsection

            
            
