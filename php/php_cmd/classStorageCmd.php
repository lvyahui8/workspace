<?php
/**
 * 解析类字典文件，并入库
 * Created by PhpStorm.
 * User: samlv
 * Date: 2016/3/31
 * Time: 16:11
 */
require_once('args.php');
require_once('start.php');
require_once('models/ApkClass.php');
$args = array_merge(array(
    '--class-map-file'    => __DIR__ . '/../report_file/myapm_maps.txt',
    '--insert-cache-size' => 200,
), $args);

$classMapFile = $args['--class-map-file'];

if (!file_exists($classMapFile)) exit(1);
$fp = fopen($classMapFile, 'r');
if (!$fp) exit(1);

$classMap = [];
$appInfoMap = [];
$classStart = false;
$count = 0;
$apkClasss = [];
while (!feof($fp)) {
    $row = str_replace(array("\r", "\n"), '', trim(fgets($fp)));
    if ($row === '---') {
        $classStart = true;
        continue;
    }
    $compsData = explode(':', $row);
    if (!isset($compsData[1])) {
        continue;
    }
    if ($classStart) {
        $classMap[$compsData[0]] = $compsData[1];
        $apkClasss[] = array(
            'app_name' => $appInfoMap['appName'],
            'version'  => $appInfoMap['version'],
            'map_id'   => $compsData[0],
            'name'     => $compsData[1],
        );
        if (++$count == $args['--insert-cache-size']) {
            ApkClass::insert($apkClasss);
            $count = 0;
            $apkClasss = [];
        }
    } else {
        $appInfoMap[$compsData[0]] = $compsData[1];
    }
}
