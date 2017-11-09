@extends('layouts.app')
@section('title', 'Efectuar pago')
@section('content')
    <p>Datos para efectuar pago</p>
    <br>
    <a class="btn btn-primary" href="{{ route('pagarPremium') }}">
        Pagar
    </a>
@endsection
