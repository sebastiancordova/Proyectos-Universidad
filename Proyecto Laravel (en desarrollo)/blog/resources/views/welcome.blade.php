<!doctype html>
<html lang="{{ config('app.locale') }}">
    <head>
        <meta charset="utf-8">
        <meta http-equiv="X-UA-Compatible" content="IE=edge">
        <meta name="viewport" content="width=device-width, initial-scale=1">

        <title>Panoraming</title>

        <!-- Fonts -->
        <link href="https://fonts.googleapis.com/css?family=Raleway:100,600" rel="stylesheet" type="text/css">

        <!-- Styles -->
        <link href="{{ asset('css/app.css') }}" rel="stylesheet">
        <link href="{{ asset('css/font-awesome.min.css') }}" rel="stylesheet">
        <link href="{{ asset('bootstrap-social.css') }}" rel="stylesheet">
        <link href="{{ asset('css/custom.css') }}" rel="stylesheet">
        <link rel="stylesheet" href="https://www.w3schools.com/w3css/4/w3.css">
        <style>
            html, body {
                background-color: #fff;
                color: #636b6f;
                font-family: 'Raleway', sans-serif;
                font-weight: 100;
                /*height: 100vh;*/
                margin: 0;
            }

            .full-height {
                height: 100vh;
            }

            .flex-center {
                align-items: center;
                display: flex;
                justify-content: center;
            }

            .position-ref {
                position: relative;
            }

            .top-right {
                position: absolute;
                right: 10px;
                top: 18px;
            }

            .content {
                text-align: center;
            }

            .title {
                font-size: 84px;
            }

            .links > a {
                color: #636b6f;
                padding: 0 25px;
                font-size: 12px;
                font-weight: 600;
                letter-spacing: .1rem;
                text-decoration: none;
                text-transform: uppercase;
            }

            .m-b-md {
                margin-bottom: 30px;
            }

            .w3-display-container > a{
                text-decoration: none;
            }
        </style>
    </head>
    <body>
        <div class="flex-center position-ref full-height">
            
            @if (Route::has('login'))
                <div class="top-right links">
                    @if (Auth::check())
                        <a href="{{ url('/eventos') }}">Eventos</a>
                    @else
                        <a href="{{ url('/login') }}">Ingresar</a>
                        <a href="{{ url('/register') }}">Registrarse</a>
                    @endif
                </div>
            @endif
            
            <div class="content">
                <br>
                <div class="title m-b-md">
                    Panoraming
                </div>
                @if (!Auth::check() or (Auth::check() and Auth::user()->type == 'normal'))
                
                <a class="btn btn-primary" href="{{ route('ventajasPremium') }}">
                    Hazte Premium
                </a>              
                @endif

                <h2>Eventos Premium</h2>
                
                <div class="w3-content w3-display-container">
                    @foreach (App\Evento::all() as $evento)
                    @if($evento->estado)
                        @if($evento->user->type=='premium')
                            <a href="{{ route('eventos.show', $evento->id) }}" class="mySlides" style="font-size:200%;">
                                <img src="{{ Storage::url($evento->afiche) }}" class="img-responsive img-rounded" height="400px" width="600px">
                                {{$evento->nombre}}
                            </a>
                        @endif
                    @endif
                    @endforeach
                    <button class="w3-button w3-black w3-display-left" onclick="plusDivs(-1)">&#10094;</button>
                    <button class="w3-button w3-black w3-display-right" onclick="plusDivs(1)">&#10095;</button>
                </div>

                

                <script>
                    var slideIndex = 1;
                    showDivs(slideIndex);

                    function plusDivs(n) {
                      showDivs(slideIndex += n);
                    }

                    function showDivs(n) {
                        var i;
                        var x = document.getElementsByClassName("mySlides");
                        if (n > x.length) {slideIndex = 1}    
                        if (n < 1) {slideIndex = x.length}
                        for (i = 0; i < x.length; i++) {
                            x[i].style.display = "none";  
                        }
                        x[slideIndex-1].style.display = "block";  
                    }
                </script>
                
            </div>

        </div>
        
    </body>
</html>