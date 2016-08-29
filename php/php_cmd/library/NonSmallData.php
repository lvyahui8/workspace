<?php
require_once 'ReportData.php';
/**
 * Created by PhpStorm.
 * User: samlv
 * Date: 2016/3/18
 * Time: 10:30
 */
class NonSmallData extends ReportData
{
    /**
     * NonSmallDataHandler constructor.
     * @param $dataFile
     * @param BaseInfo $baseInfo
     */
    public function __construct($dataFile,BaseInfo $baseInfo)
    {
        parent::__construct($dataFile);
    }

    public function mapData(callable $function)
    {
        $this->analyseData($function);
    }
}