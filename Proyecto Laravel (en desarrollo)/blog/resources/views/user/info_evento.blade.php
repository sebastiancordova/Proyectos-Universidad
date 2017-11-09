@extends('layouts.app')
@section('title', 'Evento: ' . $evento->nombre)
@section('content')
	<div class="row">
		<div class="col-xs-12 col-md-8">
			<img src="{{ Storage::url($evento->afiche) }}" class="img-responsive img-thumbnail" alt="Responsive image" height="350px" width="500px">
		</div>
		<div class="col-xs-6 col-md-4">
			<div class="panel panel-info">
				<div class="panel-body">
					<i class="fa fa-calendar" aria-hidden="true"></i>
					{{$evento->fecha}}
					<br><br>
					<i class="fa fa-clock-o" aria-hidden="true"></i>
					{{$evento->hora}}
					<br><br>
					<i class="fa fa-map-marker" aria-hidden="true"></i>
					{{$evento->direccion}}<br><br>
					{{$evento->comuna->nombre}}, {{$evento->provincia->nombre}},&nbsp; 
					@if ($evento->region_id=='7')
						Región 	
					
					@elseif ($evento->region_id=='8' or $evento->region_id=='9' or $evento->region_id=='10')
						Región del 
					
					@else 
						Región de 
					
					@endif
					{{$evento->region->nombre}}
					<br><br>
					<i class="fa fa-external-link" aria-hidden="true"></i>
					<a href="{{$evento->url}}" target="_blank">{{$evento->url}}</a>
				</div>
			</div>
		</div>
	</div>
	<br>
	<div class="panel panel-info">
		<div class="panel-heading">
		    <h5 class="panel-title">Descripcion</h5>
		</div>
		<div class="panel-body">
		    {{$evento->descripcion}}
		</div>
	</div>
	
	@if(!$evento->estado)
	<div class="panel panel-warning">
		<div class="panel-heading">
		    <h5 class="panel-title">Inactivo</h5>
		</div>
		<div class="panel-body">
			<h3>Pendiente de Aprobación</h3>
		</div>
	</div>
	@else
		<h3>Comentarios</h3>

		@if (!Auth::check())
			Para ver los comentarios debes estar logueado
		@endif

		@if (Auth::check())
		<div id="disqus_thread"></div>
		@endif
		<script>
			/**
			*  RECOMMENDED CONFIGURATION VARIABLES: EDIT AND UNCOMMENT THE SECTION BELOW TO INSERT DYNAMIC VALUES FROM YOUR PLATFORM OR CMS.
			*  LEARN WHY DEFINING THESE VARIABLES IS IMPORTANT: https://disqus.com/admin/universalcode/#configuration-variables*/
			/*
			var disqus_config = function () {
			this.page.url = PAGE_URL;  // Replace PAGE_URL with your page's canonical URL variable
			this.page.identifier = PAGE_IDENTIFIER; // Replace PAGE_IDENTIFIER with your page's unique identifier variable
			};
			*/
			(function() { // DON'T EDIT BELOW THIS LINE
			var d = document, s = d.createElement('script');
			s.src = 'https://panoraming.disqus.com/embed.js';
			s.setAttribute('data-timestamp', +new Date());
			(d.head || d.body).appendChild(s);
			})();
		</script>
		<noscript>Please enable JavaScript to view the <a href="https://disqus.com/?ref_noscript">comments powered by Disqus.</a></noscript>
	@endif
                        
@endsection