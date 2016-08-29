<?php
require_once 'ReportData.php';
/**
 * Created by PhpStorm.
 * User: samlv
 * Date: 2016/3/18
 * Time: 10:32
 */
class BaseInfo extends ReportData
{
    /**
     * BaseInfoHandler constructor.
     * @param $dataFile
     */
    public function __construct($dataFile)
    {
        parent::__construct($dataFile);
        $this->analyseData();
    }

    public function getApkKey()
    {
        return $this->data['appName'].'#'.$this->data['version'];
    }
}