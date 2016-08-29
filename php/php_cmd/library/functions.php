<?php
/**
 * Created by PhpStorm.
 * User: samlv
 * Date: 2016/3/16
 * Time: 17:10
 */


function mkdirs($dir)
{
    if(!is_dir($dir))
    {
        if(!mkdirs(dirname($dir))){
            return false;
        }
        if(!mkdir($dir,0777)){
            return false;
        }
    }
    return true;
}
function download($url,$saveFile){
    $ctx = stream_context_create(array(
        'http' => array(
            'timeout' => 5,  // 5 s
        ),
    ));
    if (strpos($url, 'http://') === false) $url= 'http://' . $url;
    $fileContent = @file_get_contents($url, false, $ctx);
    if($fileContent){
        file_force_contents($saveFile,$fileContent);
        return true;
    }else{
        return false;
    }
}
function file_force_contents($full_name, $contents){
    /*
    $parts = explode('/', $full_name);
    $file = array_pop($parts);
    $full_name = '';
    foreach($parts as $part){
        $full_name .= "/$part";
        if(!is_dir($full_name)) {
            mkdir($full_name);
        }
    }
    file_put_contents("$full_name/$file", $contents);
    */
    $i = strrpos($full_name,'/');
    $paths = substr($full_name,0,$i);
    mkdirs($paths);
    $file = substr($full_name,$i + 1);
    file_put_contents("$paths/$file", $contents);
}

function timePassed($startTime, $length = 4) {
    $timePassed = round(microtime(true) - $startTime, $length);
    return $timePassed . ' s';
}
function microtime_float()
{
    list($usec, $sec) = explode(" ", microtime());
    return ((float)$usec + (float)$sec);
}

function microtime_format($tag, $time)
{
    list($usec, $sec) = explode(".", $time);
    $date = date($tag,$usec);
    return str_replace('x', $sec, $date);
}
function getMillisecond(){
    list($s1,$s2)=explode(' ',microtime());
    return (float)sprintf('%.0f',(floatval($s1)+floatval($s2))*1000);
}

function out($str){
    echo $str;
}