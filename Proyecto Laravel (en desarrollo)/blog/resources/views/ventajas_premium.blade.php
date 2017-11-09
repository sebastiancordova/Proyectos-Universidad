@extends('layouts.app')
@section('title','Ventajas Premium')
@section('content')
<ul>
    <li>Tus Eventos se muestran en la portada de Panoraming</li>
    <br>
    <li>Puedes añadir afiches a tus Eventos</li>
    <br>
    <li>Puedes añadir links a Sitios de Pago y/o Reserva</li>
</ul>

<br>
@if (Auth::check())
    <a class="btn btn-primary" href="{{ route('pagoPremium') }}">
        Ir al Pago
    </a>
@else 
    Para acceder a los beneficios Premium primero debes Crear una Cuenta
    <br>
    <br>
    <a class="btn btn-primary" href="{{ url('/register') }}">
        Registrarse
    </a>
@endif

@endsection
