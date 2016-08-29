<?php
/**
 * Created by PhpStorm.
 * User: samlv
 * Date: 2016/3/18
 * Time: 10:03
 */


require_once('config.php');
require_once('library/functions.php');
require_once('library/ZipLoader.php');
require_once 'library/ZipDataHandler.php';

$methodNums = array();
$startTime = getMillisecond();
$zipLoader = new ZipLoader();
$zipLoader->addParams(array(
    array('p_id', 8),
    array('f_uploadtime', '>=', date('Y-m-d',strtotime('-1 day'))),
    array('f_uploadtime','<',date('Y-m-d'))
));

$sum = 0;
$zipLoader->loadZipEntitys(function($entity) use(&$methodNums,&$sum){
    out("Loading zip : {$entity->f_url}\n");
    $zipFile = 'tmp/zip/' . md5($entity->f_url) . '.zip';
    if(download($entity->f_url,$zipFile)){
        $zipDataHandler = new ZipDataHandler($zipFile);
        $zipDataHandler->handle($methodNums);
        $sum ++;
    }else{
        out("{$entity->f_url} : failed to download.\n");
    }
});
$localDb = config('db.local');
$dbh = new PDO("mysql:host={$localDb['host']}:{$localDb['port']};dbname={$localDb['name']}",
    $localDb['user'],$localDb['pass']);
$updateSql = "update methods set num=num+:num where apk_key=:apk_key and report_id=:report_id";
$apkKey = null;
$methodId = 0;
$num = 0;
$stmt = $dbh->prepare($updateSql);
$stmt->bindParam(':num',$num);
$stmt->bindParam(':apk_key',$apkKey);
$stmt->bindParam(':report_id',$methodId);

foreach($methodNums as $apkKey=>$methods){
    foreach($methods as $methodId=>$num){
        $stmt->execute();
    }
}

$delay = getMillisecond() - $startTime;
$minutes = $delay / 1000 / 60;
out("End pull take storage, successfully processed $sum Zip packages,time consuming $delay ms, about $minutes minutes.\n");

