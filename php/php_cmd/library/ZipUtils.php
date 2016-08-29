<?php

/**
 * Created by PhpStorm.
 * User: samlv
 * Date: 2016/3/18
 * Time: 10:19
 */
class ZipUtils
{
    public static function unzip($zipFile){
        $tmpDir = dirname($zipFile) . '/' . substr(basename($zipFile), 0, strrpos(basename($zipFile), '.zip'));
        if(!file_exists($tmpDir)) mkdir(dirname($zipFile).'/'.$tmpDir);
        $zip = new ZipArchive();
        $rs = $zip->open($zipFile);
        if ($rs === true) {
            $zip->extractTo($tmpDir);
            $zip->close();
            return $tmpDir;
        } else return null;
    }
}