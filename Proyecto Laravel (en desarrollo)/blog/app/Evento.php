<?php

namespace App;

use Illuminate\Database\Eloquent\Model;

class Evento extends Model
{
    protected $table = 'eventos';
    protected $fillable = [
        'nombre', 
        'region_id', 
        'provincia_id', 
        'comuna_id', 
        'direccion', 
        'fecha', 
        'hora', 
        'descripcion', 
        'url',
        'afiche'
        ];
        
    protected $hidden = ['id', 'user_id'];

    public function user()
    {
        return $this->belongsTo('App\User');
    }

    public function region()
    {
        return $this->hasOne('App\Region','id', 'region_id');
    }

    public function comuna()
    {
        return $this->hasOne('App\Comuna', 'id', 'comuna_id');
    }

    public function provincia()
    {
        return $this->hasOne('App\Provincia', 'id', 'provincia_id');
    }

    public function scopeSearch($query,$name){
        return $query->where('nombre', 'LIKE', "%$name%");
    }

}
