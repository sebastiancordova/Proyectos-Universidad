<?php

namespace App;

use Illuminate\Database\Eloquent\Model;

class Comuna extends Model
{
    protected $table = 'comunas';
    protected $fillable = ['nombre'];
    protected $hidden = ['id'];

    public function eventos()
    {
    	return $this->belongsToMany('App\Evento');
    }

    public function provincia()
    {
    	return $this->belongsTo('App\Provincia');
    }


}
