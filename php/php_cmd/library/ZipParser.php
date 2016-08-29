<?php
/**
 * Created by PhpStorm.
 * User: samlv
 * Date: 2016/3/31
 * Time: 11:32
 */
require_once (__DIR__.'/../config.php');
require_once('FileUtils.php');
require_once ('ZipUtils.php');

class ZipParser {
    private $zipFile ;

    public function __construct($zipFile = null)
    {
        $this->zipFile = $zipFile;
    }

    /**
     * @param null $zipFile
     */
    public function setZipFile($zipFile)
    {
        $this->zipFile = $zipFile;


    }

    public function handle(){
        $zipBasePath = ZipUtils::unzip($this->zipFile);
        $baseInfoFile = $zipBasePath.'/'.config('base_info_file');


        /*
         * 解析二进制的nonSmallData数据文件，
         * 现在nonSmallData是一个位标识标识一个类，为1表示调用过，为0表示没有调用
         * */
        $map = [];
        $nonSmallDataFile = $zipBasePath.'/'.config('method_data_file');
        $fp = fopen($nonSmallDataFile,'r');
        if($fp){
            $bi = 12;
            $bufSize = 1 << 12;
            for($n = 0;$bytes = fread($fp,$bufSize);$n++){
                $length = strlen($bytes);
                for($i = 0; $i < $length; $i++){
                    $byte = hexdec(bin2hex($bytes[$i]));
                    for($j = 0; $j < 8; $j++){
//                if($byte & (0x80 >> $j)){
                        if($byte & (1 << $j)){    // 对每个字节反向读取
                            $id = ($n << $bi) + ($i << 3) + $j;
                            $map[$id] = isset($map[$id]) ? $map[$id] + 1 : 1;
                        }
                    }
                }
            }
            fclose($fp);
        }
        print_r($map);
        echo 'count:'.count($map)."\n";
        FileUtils::deleteDirectoryContents($zipBasePath);
    }
}