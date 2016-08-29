<?php
/**
 * Created by PhpStorm.
 * User: samlv
 * Date: 2016/3/16
 * Time: 15:45
 */
require_once('config.php');
require_once('library/functions.php');
require_once('library/ZipLoader.php');
require_once('library/ZipHandler.php');

date_default_timezone_set('PRC');
$startTime = getMillisecond();
$zipLoader = new ZipLoader();
$zipLoader->addParams(array(
    array('p_id', 8),
    array('f_uploadtime', '>=', date('Y-m-d',strtotime('-1 day'))),
    array('f_uploadtime','<',date('Y-m-d')),
//    array('f_id', 32619),
//    'or'    =>  array('p_id',8),
));

$entitys = $zipLoader->getEntitys();
$ctx = stream_context_create(array(
    'http' => array(
        'timeout' => 5,  // 5 s
    ),
));
$total = count($entitys);
out("A total of $total zip packets.\n");
foreach ($entitys as $entity) {
    $zipFile = 'tmp/zip/' . md5($entity->f_url) . '.zip';
    if (strpos($entity->f_url, 'http://') === false) $entity->f_url = 'http://' . $entity->f_url;
    out("Loading zip : {$entity->f_url}\n");
    $zipContent = @file_get_contents($entity->f_url, false, $ctx);
    if ($zipContent) {
        file_force_contents($zipFile, $zipContent);
        $zipHandler = new ZipHandler($zipFile);
        $zipHandler->handle();
        unlink($zipFile);
    } else {
        out("{$entity->f_url} : failed to download.\n");
    }
}
$delay = getMillisecond() - $startTime;
$minutes = $delay / 1000 / 60;
out("End pull take storage, time consuming $delay ms, about $minutes minutes.\n");