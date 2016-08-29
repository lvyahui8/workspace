<?php
/**
 * 脚本功能：拉取前一天的zip包存放到tmp/zip/目录下
 * Created by PhpStorm.
 * User: samlv
 * Date: 2016/3/31
 * Time: 16:56
 */
require_once('args.php');
require_once('config.php');
require_once('library/functions.php');
require_once('library/ZipLoader.php');
$args = array_merge(array(
    '--uploadtime-start' => date('Y-m-d', strtotime('-1 day')),
    '--uploadtime-end'  =>   date('Y-m-d'),
), $args);
$zipLoader = new ZipLoader();
$zipLoader->addParams(array(
    array('p_id', 8),
    array('f_uploadtime', '>=', $args['--uploadtime-start']),
    array('f_uploadtime', '<',$args['--uploadtime-end']),
));

$zipLoader->loadZipEntitys(function ($entity) {
    $zipFile = 'tmp/zip/' . md5($entity->f_url) . '.zip';
    download($entity->f_url, $zipFile);
});
