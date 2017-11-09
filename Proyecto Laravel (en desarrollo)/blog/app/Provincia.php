<?php

namespace App;

use Illuminate\Database\Eloquent\Model;

class Provincia extends Model
{
    protected $table = 'provincias';
    protected $fillable = ['nombre', 'id'];
    

    public function region()
    {
        return $this->belongsTo('App\Region');
    }

    public function eventos()
    {
        return $this->belongsToMany('App\Evento');
    }

    public function comunas()
    {
        return $this->hasMany('App\Comuna');
    }

}
