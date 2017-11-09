@extends('layouts.app')

@section('content')
@section('title')Ingresar @endsection
    <form class="form-horizontal" method="POST" action="{{ route('login') }}">
        {{ csrf_field() }}

        @if (session()->has('alertaregistro'))
            <div class="panel-body">
                <div class="alert alert-success">{{ session('alertaregistro')}}</div>
            </div>
        @endif

        @if (session()->has('alertaregistrocompleto'))
            <div class="panel-body">
                <div class="alert alert-success">{{ session('alertaregistrocompleto')}}</div>
            </div>
        @endif

        @if (session()->has('status'))
            <div class="panel-body">
                <div class="alert alert-success">{{ session('status')}}</div>
            </div>
        @endif

        @if (session()->has('alertanovalidado'))
            <div class="panel-body">
                <div class="alert alert-danger">{{ session('alertanovalidado')}}</div>
            </div>
        @endif

        @if (session()->has('alertanoregistro'))
            <div class="panel-body">
                <div class="alert alert-danger">{{ session('alertanoregistro')}}</div>
            </div>
        @endif

        <div class="form-group{{ $errors->has('email') ? ' has-error' : '' }}">
            <label for="email" class="col-md-4 control-label">E-Mail </label>

            <div class="col-md-6">
                <input id="email" type="email" class="form-control" name="email" value="{{ old('email') }}" required autofocus>

                @if ($errors->has('email'))
                    <span class="help-block">
                        <strong>{{ $errors->first('email') }}</strong>
                    </span>
                @endif
            </div>
        </div>

        <div class="form-group{{ $errors->has('password') ? ' has-error' : '' }}">
            <label for="password" class="col-md-4 control-label">Contraseña</label>

            <div class="col-md-6">
                <input id="password" type="password" class="form-control" name="password" required>

                @if ($errors->has('password'))
                    <span class="help-block">
                        <strong>{{ $errors->first('password') }}</strong>
                    </span>
                @endif
            </div>
        </div>

        <div class="form-group">
            <div class="col-md-6 col-md-offset-4">
                <div class="checkbox">
                    <label>
                        <input type="checkbox" name="remember" {{ old('remember') ? 'checked' : '' }}> Recordarme
                    </label>
                </div>
            </div>
        </div>

        <div class="form-group">
            <div class="col-md-8 col-md-offset-4">
                <button type="submit" class="btn btn-primary">
                    <i class="fa fa-btn fa-sign-in"></i> Ingresar
                </button>
                <a class="btn btn-secundary" href="{{ route('password.request') }}">
                    Recuperar contraseña
                </a>
            </div>
        </div>
        <div>
            <center>
                <a class="btn btn-social btn-google" href='{{url("login/google")}}'>
                    <span class="fa fa-google"></span> Ingresa con Google
                </a>
                <a class="btn btn-social btn-facebook btn-facebook:hover" href='{{url("login/facebook")}}'>
                    <span class="fa fa-facebook"></span> Ingresa con Facebook
                </a>
                <a class="btn btn-social btn-twitter" href='{{url("login/twitter")}}'>
                    <span class="fa fa-twitter"></span> Ingresa con Twitter
                </a>
            </center>
        </div>
    </form>
@endsection