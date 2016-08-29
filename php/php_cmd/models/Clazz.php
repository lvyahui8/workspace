<?php

/**
 * Created by PhpStorm.
 * User: samlv
 * Date: 2016/3/6
 * Time: 17:07
 */
class Clazz extends BaseModel
{
    protected $table = 'clazz';

    public function package(){
        return $this->belongsTo('Pack','pack_id');
    }

    public function methods(){
        return $this->hasMany('Method','clazz_id');
    }
}