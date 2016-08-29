<?php
require_once ('BaseModel.php');
/**
 * Created by PhpStorm.
 * User: samlv
 * Date: 2016/3/17
 * Time: 17:30
 */
class Apk extends BaseModel
{
    protected $table = 'app';
    public function packs(){
        return $this->hasMany('Pack','app_id');
    }
}