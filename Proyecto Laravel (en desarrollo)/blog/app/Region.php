<?php

namespace App;

use Illuminate\Database\Eloquent\Model;

class Region extends Model
{
    protected $table = 'regiones';
    protected $fillable = ['nombre', 'ordinal', 'id'];

    public function provincias()
    {
        return $this->hasMany('App\Provincia');
    }

    public function eventos()
    {
    	return $this->belongsToMany('App\Evento','region_id');
    }
}
