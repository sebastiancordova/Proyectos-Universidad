<?php

use Illuminate\Support\Facades\Schema;
use Illuminate\Database\Schema\Blueprint;
use Illuminate\Database\Migrations\Migration;

class CreandoTablaEventos extends Migration
{
    /**
     * Run the migrations.
     *
     * @return void
     */
    public function up()
    {
        Schema::create('eventos', function (Blueprint $table) {
            $table->increments('id');
            $table->string('nombre');
            $table->integer('region_id')->unsigned();
            $table->foreign('region_id')->references('id')->on('regiones')->onDelete('cascade');
            $table->integer('provincia_id')->unsigned();
            $table->foreign('provincia_id')->references('id')->on('provincias')->onDelete('cascade');
            $table->integer('comuna_id')->unsigned();
            $table->foreign('comuna_id')->references('id')->on('comunas')->onDelete('cascade');
            $table->string('direccion');
            $table->date('fecha');
            $table->time('hora');
            $table->string('url')->nullable();
            $table->string('descripcion');
            $table->string('afiche')->default('afiche_default.png');
            $table->integer('user_id')->unsigned();
            $table->foreign('user_id')->references('id')->on('users')->onDelete('cascade');
            $table->boolean('estado')->default(false);
            $table->timestamps();
        });
    }

    /**
     * Reverse the migrations.
     *
     * @return void
     */
    public function down()
    {
        Schema::dropIfExists('eventos');
    }
}