<!DOCTYPE html>
<html lang="{{ app()->getLocale() }}">
<head>
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1">

    <!-- CSRF Token -->
    <meta name="csrf-token" content="{{ csrf_token() }}">

    <title>@yield('title', 'Default') - Panoraming </title>

    <!-- Styles -->
    <link href="{{ asset('css/app.css') }}" rel="stylesheet">
    <link href="{{ asset('css/custom.css') }}" rel="stylesheet">
    <link href="{{ asset('css/font-awesome.min.css') }}" rel="stylesheet">
    <link href="{{ asset('bootstrap-social.css') }}" rel="stylesheet">

</head>
<body>
<div id="app">
    <nav class="navbar navbar-default navbar-static-top">
        <div class="container">
            <div class="navbar-header">
                <!-- Collapsed Hamburger -->
                <button type="button" class="navbar-toggle collapsed" data-toggle="collapse" data-target="#app-navbar-collapse">
                    <span class="sr-only">Toggle Navigation</span>
                    <span class="icon-bar"></span>
                    <span class="icon-bar"></span>
                    <span class="icon-bar"></span>
                </button>

                <!-- Branding Image -->
                <a class="navbar-brand" href="{{ url('/') }}">
                    <img alt="Panoraming" src="{{ asset('images/ico.png') }}"  width="64" class="img-circle"> 
                    Panoraming
                    @if (Auth::check() and Auth::user()->type == 'premium')
                        Premium
                    @endif
                </a>
            </div>

            <div class="collapse navbar-collapse" id="app-navbar-collapse">
                <!-- Left Side Of Navbar -->
                <ul class="nav navbar-nav">
                    &nbsp;

                </ul>

                <!-- Right Side Of Navbar -->
                <ul class="nav navbar-nav navbar-right">
                    <!-- Authentication Links -->
                    @if (Auth::guest())
                        <li><a href="{{ route('login') }}">Ingresar</a></li>
                        <li><a href="{{ route('register') }}">Registrarse</a></li>
                    @else
                        <li>
                            <form action="{{ route('eventos') }}" class="navbar-form navbar-left" method="GET">
                                <div class="form-group">
                                    <input name="buscar" type="text" class="form-control" placeholder="Buscar Evento">
                                </div>
                                <button type="submit" class="btn btn-default">Buscar</button>
                            </form>
                        </li>
                        @if( Auth::user()->type == 'admin' )

                        <li><a href="{{ route('aprobarEventos') }}">Aprobar Eventos</a></li>

                        @endif
                        <li><a href="{{ route('eventos')}}">Eventos</a></li>
                        @if (Request::url() != route('eventos.create'))
                            <li><a href="{{ route('eventos.create') }}">Crear Evento</a></li>
                        @endif
                        <li class="dropdown">

                            <a href="#" class="dropdown-toggle" data-toggle="dropdown" role="button" aria-expanded="false">
                                <img src={{Auth::user()->avatar}} style="width:30px" class="img-circle">
                                    &nbsp; {{ Auth::user()->name }} <span class="caret"></span>
                            </a>

                            <ul class="dropdown-menu" role="menu">
                                <li>
                                    <a href="#">
                                        Mi Perfil
                                    </a>
                                    <a href="{{ route('misEventos')}}">
                                        Mis eventos
                                    </a>
                                    <a href="{{ route('logout') }}"
                                       onclick="event.preventDefault();
                                                     document.getElementById('logout-form').submit();">
                                        Salir
                                    </a>

                                    <form id="logout-form" action="{{ route('logout') }}" method="POST" style="display: none;">
                                        {{ csrf_field() }}
                                    </form>
                                </li>
                            </ul>
                        </li>  
                    @endif
                </ul>
            </div>
        </div>
    </nav>

    <section>
        <div class="container">
            <div class="row">
                <div class="col-md-8 col-md-offset-2">
                    <div class="panel panel-default">
                        <div class="panel-heading">
                            <h4>@yield('title', 'Default')</h4>
                        </div>
                        <div class="panel-body">
                            @include('flash::message')
                            @yield('content')
                        </div>
                    </div>
                </div>
            </div>
        </div>
    </section>
</div>

<!-- Scripts -->
<script src="{{ asset('js/app.js') }}"></script>
<script>
    $('div.alert').not('.alert-important').delay(3000).fadeOut(350);
</script>
</body>

</html>
