<?php
/**
 * Created by PhpStorm.
 * User: samlv
 * Date: 2016/3/30
 * Time: 20:44
 */

/*
 * 解析二进制的nonSmallData数据文件，
 * 现在nonSmallData是一个位标识标识一个类，为1表示调用过，为0表示没有调用
 * */
$map = [];
$file = __DIR__.'/../report_file/nonSmallData';
$fp = fopen($file,'r');
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

echo 0x16 & 16;

