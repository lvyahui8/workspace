<?php
/**
 * 拉取二进制的nonSmallData的zip包并解压，然后按位扫描文件。
 * Created by PhpStorm.
 * User: samlv
 * Date: 2016/3/31
 * Time: 11:28
 */


require_once('config.php');
require_once('library/functions.php');
require_once('library/ZipLoader.php');
require_once ('library/ZipParser.php');
$methodNums = array();
$startTime = getMillisecond();

$zipLoader = new ZipLoader();

$sum = $zipLoader->handleZips(array(
    array('p_id', 8),
    array('f_uploadtime', '>=', date('Y-m-d',strtotime('-1 day'))),
    array('f_uploadtime','<',date('Y-m-d'))
),new ZipParser());

$delay = getMillisecond() - $startTime;
$minutes = $delay / 1000 / 60;
out("End pull take storage, successfully processed $sum Zip packages,time consuming $delay ms, about $minutes minutes.\n");
