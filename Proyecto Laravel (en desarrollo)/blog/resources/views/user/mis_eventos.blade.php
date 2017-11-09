@extends('layouts.app')
@section('content')
@section('title', 'Mis Eventos' )

<div class="row">

    @if($events->isEmpty())
        <div class="col-md-12">
            <div class="panel panel-info">
                <div class="panel-body">
                    <h3 align="center">No haz creado eventos</h3>
                </div>
            </div>
        </div>
    @endif

    @foreach($events as $event)
    <div class="col-sm-6 col-md-4">
        <div class="thumbnail">
            
            <a href="{{ route('eventos.show', $event->id) }}"><img src="{{ Storage::url($event->afiche) }}" ></a>
            
            <div class="caption">
                <h3>{{ $event->nombre }}</h3>
                <p><i class="fa fa-calendar" aria-hidden="true"></i> {{ $event->fecha }}</p>
                <p><i class="fa fa-map-marker" aria-hidden="true"></i> {{ $event->comuna->nombre }}</p>
                @if(!$event->estado)
                    <div class="panel panel-warning">Pendiente de Aprobación</div>
                @endif
                <p>
                    <a href="{{ route('eventos.edit', $event->id) }}" class="btn btn-primary" role="button">Editar</a> 
                    <a href="{{ route('eventos.destroy', $event->id) }}" class="btn btn-danger" role="button" onclick="return confirm('Seguro que quieres eliminar este evento?')">Eliminar</a>
                </p>
            </div>
        </div>
    </div>
    @endforeach
</div>

<div align="center">
    {!! $events->render() !!}
</div>

@endsection
