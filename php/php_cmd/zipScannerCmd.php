<?php
/**
 * Created by PhpStorm.
 * User: samlv
 * Date: 2016/3/31
 * Time: 17:00
 * 扫描tmp/zip目录，解压左右的zip包，让后进行处理。
 */
require_once ('start.php');
require_once('args.php');
require_once('config.php');
require_once ('library/ZipUtils.php');
require_once('library/functions.php');
require_once ('models/ApkClass.php');
require_once ('library/FileUtils.php');

$args = array_merge(array(
    '--after-delete' => true,
), $args);
$zipPath = 'tmp/zip';

$zips = scandir($zipPath);
chdir($zipPath);
function parserBinFile($nonSmallDataFile,&$usedApkClasss){

    $fp = fopen($nonSmallDataFile, 'r');
    if ($fp) {
        $bi = 12;
        $bufSize = 1 << 12;
        for ($n = 0; $bytes = fread($fp, $bufSize); $n++) {
            $length = strlen($bytes);
            for ($i = 0; $i < $length; $i++) {
                $byte = hexdec(bin2hex($bytes[$i]));
                for ($j = 0; $j < 8; $j++) {
//                if($byte & (0x80 >> $j)){
                    if ($byte & (1 << $j)) {    // 对每个字节反向读取
                        $map_id = ($n << $bi) + ($i << 3) + $j;
                        $usedApkClasss [$map_id] = isset($usedApkClasss[$map_id]) ? $usedApkClasss[$map_id] + 1 : 1;
                    }
                }
            }
        }
        fclose($fp);
    }
}
$usedApkClasss = [];
foreach ($zips as $zip) {
    if ($zip !== '.' && $zip !== '..' && strrpos($zip, '.zip') !== false) {
        $zipBasePath = ZipUtils::unzip($zip);
        /*
        * 解析二进制的nonSmallData数据文件，
        * 现在nonSmallData是一个位标识标识一个类，为1表示调用过，为0表示没有调用
        * */
        $nonSmallDataFile = $zipBasePath . '/' . config('method_data_file');
        if(file_exists($nonSmallDataFile)){
            parserBinFile($nonSmallDataFile,$usedApkClasss);
        }
        $nonSmallDataServiceFile = $zipBasePath.'/'.config('method_data_file').'_service';
        if(file_exists($nonSmallDataServiceFile)){
            parserBinFile($nonSmallDataServiceFile,$usedApkClasss);
        }
        if($zipBasePath){
            FileUtils::deleteDirectoryContents($zipBasePath);
        }
        if ($args['--after-delete']) unlink($zip);
    }
}
foreach($usedApkClasss as $map_id=>$num){
    ApkClass::where('map_id',$map_id)->update(array('num' => $num));
}

