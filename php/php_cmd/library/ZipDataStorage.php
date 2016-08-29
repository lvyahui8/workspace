<?php
if (!defined('ZIP_DATA_CONF')) define('ZIP_DATA_CONF', json_encode(include('../zip_data.conf.php')));
require_once('FileUtils.php');

/**
 * Created by PhpStorm.
 * User: samlv
 * Date: 2016/3/15
 * Time: 15:53
 */
class ZipDataStorage
{
    private $zipFile;

    private $tmpDir;

    private $conf;

    /**
     * ZipDataStorage constructor.
     * @param $zipFile
     */
    public function __construct($zipFile)
    {
        $this->conf = json_decode(ZIP_DATA_CONF, true);
        $this->zipFile = $zipFile;
        $this->tmpDir = dirname($zipFile) . '/' . substr(basename($zipFile), 0, strrpos(basename($zipFile), '.zip'));
        if (!file_exists($this->tmpDir)) mkdir($this->tmpDir);
    }

    protected function unzip()
    {
        $zip = new ZipArchive();
        $rs = $zip->open($this->zipFile);
        if ($rs === true) {
            $zip->extractTo($this->tmpDir);
            $zip->close();
            return true;
        } else return false;
    }

    public function getDatas(callable $callback = null)
    {
        if (!$this->unzip()) {
            throw new Exception("File cannot be extracted");
        }
        $bFile = $this->tmpDir . '/' . $this->conf['base_info_file'];
        if(file_exists($bFile)){
            $baseInfoFile = fopen($bFile, 'r');
            $baseInfo = array();
            while (!feof($baseInfoFile)) {
                $row = fgets($baseInfoFile);
                $compsData = explode(':', $row);
                if (count($compsData) < 2) continue;
                $baseInfo[$compsData[0]] = str_replace(array("\r", "\n"), '', $compsData[1]);
            }
            fclose($baseInfoFile);
        }
        $dFile = $this->tmpDir . '/' . $this->conf['method_data_file'];
        $methodDatas = array();
        if(file_exists($dFile)){
            $dataFile = fopen($dFile, 'r');
            while (!feof($dataFile)) {
                $row = fgets($dataFile);
                $compsData = explode(':', $row);
                if (count($compsData) < 2) continue;
                $methodData = array_merge($baseInfo, array(
                    'method_id' => $compsData[0],
                    'num'       => str_replace(array("\r", "\n"), '', $compsData[1]),
                ));
                // 对字段转义，主要解决日志文件key-value的key与数据库中的字段不对应的问题
                if (isset($this->conf['translate'])) {
                    foreach ($this->conf['translate'] as $fromFiled => $toFiled) {
                        if (is_string($fromFiled)) {
                            $methodData[$toFiled] = $methodData[$fromFiled];
                            unset($methodData[$fromFiled]);
                        }
                    }
                }
                // 调用回调处理
                if ($callback && is_callable($callback)) {
                    $callback($methodData);
                }
                $methodDatas [] = $methodData;
            }
            fclose($dataFile);
        }
        FileUtils::deleteDirectoryContents($this->tmpDir);
        return $methodDatas;
    }
}

//$zipDataStorage = new ZipDataStorage("data.zip");
//$methodDatas = $zipDataStorage->getDatas(function($methodData){
//    foreach($methodData as $filed => $value){
//        echo "$filed : $value ";
//    }
//    echo "\n";
//});
//
//print_r($methodDatas);
