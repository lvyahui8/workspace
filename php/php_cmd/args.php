<?php
/**
 * Created by PhpStorm.
 * User: samlv
 * Date: 2016/3/31
 * Time: 16:19
 */
$args = [];
foreach($argv as $arg){
    $compsData = explode('=',$arg);
    $args[$compsData[0]] = isset($compsData[1]) ? ($compsData[1]) : true;
}