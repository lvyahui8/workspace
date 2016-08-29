<?php
use Illuminate\Database\Eloquent\Model as Eloquent;
/**
 * Created by PhpStorm.
 * User: samlv
 * Date: 2016/3/17
 * Time: 17:30
 */
class BaseModel extends Eloquent
{
    protected $guarded = array('id');
    public $timestamps = false;
}