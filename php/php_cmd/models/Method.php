<?php

/**
 * Created by PhpStorm.
 * User: samlv
 * Date: 2016/3/6
 * Time: 17:08
 */
class Method extends BaseModel
{
//    protected $table = 'methods';
    public function clazz(){
        return $this->belongsTo('Clazz','clazz_id');
    }
}