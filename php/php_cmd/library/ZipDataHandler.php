<?php
require_once 'ReportZip.php';
require_once 'BaseInfo.php';
require_once 'NonSmallData.php';
/**
 * Created by PhpStorm.
 * User: samlv
 * Date: 2016/3/18
 * Time: 10:06
 */
class ZipDataHandler
{
    private $zipFile ;

    /**
     * ZipDataHandler constructor.
     * @param $zipFile
     */
    public function __construct($zipFile)
    {
        $this->zipFile = $zipFile;
    }

    public function handle(& $methodNums)
    {
        $reportZip = new ReportZip($this->zipFile);
        $baseInfo = new BaseInfo($reportZip->getBaseInfoFile());
        $nonSmallData = new NonSmallData($reportZip->getNonSmallDataFile(),$baseInfo);
        $nonSmallData->mapData(function($methodId,$num) use ($baseInfo,&$methodNums){
            $apkKey = $baseInfo->getApkKey();
            if(!isset($methodNums[$apkKey])){
                $methodNums[$apkKey] = array();
            }
            if(isset($methodNums[$apkKey][intval($methodId)])){
                $methodNums[$apkKey][intval($methodId)] += intval($num);
            }else{
                $methodNums[$apkKey][intval($methodId)] = intval($num);
            }
        });
        unlink($this->zipFile);
    }
}