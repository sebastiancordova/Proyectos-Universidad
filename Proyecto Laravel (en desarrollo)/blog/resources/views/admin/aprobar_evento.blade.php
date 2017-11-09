@extends('layouts.app')
@section('content')
    @section('title', 'Eventos' )

    <div class="row">
        @if($events->isEmpty())
            <div class="col-md-12">
                <div class="panel panel-info">
                    <div class="panel-body">
                        <h3 align="center">No hay eventos para aprobar</h3>
                    </div>
                </div>
            </div>
        @endif
        @foreach($events as $event)
        <div class="col-sm-6 col-md-4">
            <div class="thumbnail">
                <img src="{{ Storage::url($event->afiche) }}" >
                <div class="caption">
                    <h3>{{ $event->nombre }}</h3>
                    <p><i class="fa fa-calendar" aria-hidden="true"></i> {{ $event->fecha }}</p>
                    <p><i class="fa fa-map-marker" aria-hidden="true"></i> {{ $event->comuna->nombre }}</p>
                    <p>
                        <a href="{{ route('eventos.show', $event->id) }}" class="btn btn-primary" role="button">Ver mas</a> 
                        <a href="{{ route('eventos.aprobar', $event->id) }}" class="btn btn-default" role="button">Aprobar</a>
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

            
            
