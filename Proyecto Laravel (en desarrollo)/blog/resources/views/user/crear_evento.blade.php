@extends('layouts.app')

<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script>
<script>
    $(document).ready(function(){
        $('#region').change(function(){
            $.get("{{ url('dropdown_region')}}",
            { option: $(this).val() },
            function(data) {
                $('#provincia').empty();
                $.each(data, function(key, element) {
                    $('#provincia').append("<option value='" + key + "'>" + element + "</option>");
                });
            });
        });
    });     
</script>
<script>
    $(document).ready(function(){
        $('#provincia').change(function(){
            $.get("{{ url('dropdown_provincia')}}",
            { option: $(this).val() },
            function(data) {
                $('#comuna').empty();
                $.each(data, function(key, element) {
                    $('#comuna').append("<option value='" + key + "'>" + element + "</option>");
                });
            });
        });
    });     
</script>
@section('title','Crear Evento')
@section('content')

    <form class="form-horizontal" id="form-crear-evento" method="POST" action="{{ route('eventos.store') }}" enctype="multipart/form-data">
        {{ csrf_field() }}

        <div class="form-group">
            <label for="nombre" class="col-md-4 control-label">Nombre</label>

            <div class="col-md-6">
                <input id="nombre" type="text" class="form-control" name="nombre" value="{{ old('nombre') }}" required autofocus>
                @if ($errors->has('nombre'))
                    <span class="help-block">
                        <strong>{{ $errors->first('nombre') }}</strong>
                    </span>
                @endif
            </div>
        </div>

        <div class="form-group">
            <label for="region" class="col-md-4 control-label">Region</label>

            <div class="col-md-6">
                <select class="selectpicker" form="form-crear-evento" id="region" name="region" required>
                    <option value= "" selected disabled>Seleccione Region</option>
                    @foreach (App\Region::all() as $region)
                        <option value="{{$region->id}}">{{$region->nombre}}</option>
                    @endforeach
                </select>
            </div>
        </div>

        <div class="form-group">
            <label for="provincia" class="col-md-4 control-label">Provincia</label>

            <div class="col-md-6">
                <select class="selectpicker" form="form-crear-evento" id="provincia" name="provincia" required>
                    <option value= "" selected disabled>Seleccione Provincia</option>    
                </select>
            </div>
        </div>

        <div class="form-group">
            <label for="comuna" class="col-md-4 control-label">Comuna</label>

            <div class="col-md-6">
                <select class="selectpicker" form="form-crear-evento" id="comuna" name="comuna" required>
                    <option value= "" selected disabled>Seleccione Comuna</option>
                </select>
            </div>
        </div>

        <div class="form-group">
            <label for="direccion" class="col-md-4 control-label">Dirección</label>

            <div class="col-md-6">
                <input id="direccion" type="text" class="form-control" name="direccion" value="{{ old('direccion') }}" required>
                @if ($errors->has('direccion'))
                    <span class="help-block">
                        <strong>{{ $errors->first('direccion') }}</strong>
                    </span>
                @endif
            </div>
        </div>

        <div class="form-group">
            <label for="fecha" class="col-md-4 control-label">Fecha</label>

            <div class="col-md-6">
                <input type="date" name="fecha" required>
            </div>
        </div>

        <div class="form-group">
            <label for="hora" class="col-md-4 control-label">Hora</label>

            <div class="col-md-6">
                <input type="time" name="hora" required>
            </div>

        </div>

        @if(Auth::check() and Auth::user()->type == 'premium')
        <div class="form-group">
            <label for="url" class="col-md-4 control-label">Sitio Pago/Reserva</label>

            <div class="col-md-6">
                <input id="url" type="url" class="form-control" name="url" value="{{ old('url') }}" >
            </div>
        </div>
        @endif

        <div class="form-group">
            <label for="descripcion" class="col-md-4 control-label">Descripción</label>

            <div class="col-md-6">
                <textarea rows="4" cols="50" name="descripcion" form="form-crear-evento"></textarea>
                @if ($errors->has('descripcion'))
                    <span class="help-block">
                        <strong>{{ $errors->first('descripcion') }}</strong>
                    </span>
                @endif
            </div>
        </div>

        @if(Auth::check() and Auth::user()->type == 'premium')
        <div class="form-group">
            <label for="afiche" class="col-md-4 control-label">Afiche</label>

            <div class="col-md-6">
                <input id="afiche" type="file" class="form-control" name="afiche" value="{{ old('afiche') }}">
                @if ($errors->has('afiche'))
                    <span class="help-block">
                        <strong>{{ $errors->first('afiche') }}</strong>
                    </span>
                @endif
            </div>
        </div>
        @endif
        
        <div class="form-group">
            <div class="col-md-6 col-md-offset-4">
                <button type="submit" class="btn btn-primary">
                    Crear
                </button>
            </div>
        </div>
    </form>

@endsection

