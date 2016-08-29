<?php

/**
 * Created by PhpStorm.
 * User: samlv
 * Date: 2016/3/6
 * Time: 17:06
 */
class Pack extends BaseModel
{
    protected $table = 'pack';

    public function clazzs(){
        return $this->hasMany('Clazz','pack_id');
    }
}