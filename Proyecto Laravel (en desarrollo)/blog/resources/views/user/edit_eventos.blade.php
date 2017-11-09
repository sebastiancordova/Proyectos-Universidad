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
@section('title', 'Editar Evento: ' . $evento->nombre)
@section('content')
	<form  action="{{ route('eventos.update', $evento->id) }}"  class="form-horizontal" method="POST" enctype="multipart/form-data" id="form-edit-evento">
        <input type="hidden" name="_method" value="PUT">
        <input type="hidden" name="_token" value="{{ csrf_token() }}">

        <div class="form-group">
            <label for="nombre" class="col-md-4 control-label">Nombre</label>

            <div class="col-md-6">
                <input id="nombre" type="text" class="form-control" name="nombre" value="{{$evento->nombre}}" required autofocus >
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
                <select class="selectpicker" form="form-edit-evento" id="region" name="region" required>
                    <option value= "" selected disabled>Seleccione Region</option>
                    @foreach (App\Region::all() as $region)
                        <option value="{{ $region->id }}">{{ $region->nombre }}</option>
                    @endforeach
                </select>
            </div>
        </div>

        <div class="form-group">
            <label for="provincia" class="col-md-4 control-label">Provincia</label>

            <div class="col-md-6">
                <select class="selectpicker" form="form-edit-evento" id="provincia" name="provincia" required>
                    <option value= "" selected disabled>Seleccione Provincia</option>    
                </select>
            </div>
        </div>

        <div class="form-group">
            <label for="comuna" class="col-md-4 control-label">Comuna</label>

            <div class="col-md-6">
                <select class="selectpicker" form="form-edit-evento" id="comuna" name="comuna" required>
                    <option value= "" selected disabled>Seleccione Comuna</option>
                </select>
            </div>
        </div>
       
        <div class="form-group">
            <label for="direccion" class="col-md-4 control-label">Dirección</label>

            <div class="col-md-6">
                <input id="direccion" type="text" class="form-control" name="direccion" value="{{ $evento->direccion }}" required autofocus>
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
                <input type="date" name="fecha" required value="{{$evento->fecha}}">
            </div>
        </div>

        <div class="form-group">
            <label for="hora" class="col-md-4 control-label">Hora</label>

            <div class="col-md-6">
                <input type="time" name="hora" value="{{ $evento->hora }}" required>
            </div>

        </div>

        @if(Auth::check() and Auth::user()->type == 'premium')
        <div class="form-group">
            <label for="url" class="col-md-4 control-label">Sitio Pago/Reserva</label>

            <div class="col-md-6">
                <input id="url" type="url" class="form-control" name="url" value="{{ $evento->url }}" autofocus>
            </div>
        </div>
        @endif

        <div class="form-group">
            <label for="descripcion" class="col-md-4 control-label">Descripción</label>

            <div class="col-md-6">
                <textarea rows="4" cols="50" name="descripcion" form="form-edit-evento" >{{ $evento->descripcion }}</textarea>
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
                <input id="afiche" type="file" class="form-control" name="afiche" value="{{ old('afiche') }}" autofocus>
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
                    Editar
                </button>
            </div>
        </div>
    </form>
@endsection