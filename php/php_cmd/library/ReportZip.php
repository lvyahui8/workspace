<?php
require_once __DIR__.'/../config.php';
require_once 'ZipUtils.php';
/**
 * Created by PhpStorm.
 * User: samlv
 * Date: 2016/3/18
 * Time: 10:24
 */
class ReportZip
{
    private $zipFile ;

    private $baseInfoFile;

    private $nonSmallDataFile;

    /**
     * ReportZip constructor.
     * @param $zipFile
     */
    public function __construct($zipFile)
    {
        $this->zipFile = $zipFile;
        $zipBasePath = ZipUtils::unzip($this->zipFile);
        $this->baseInfoFile = $zipBasePath.'/'.config('base_info_file');
        $this->nonSmallDataFile = $zipBasePath.'/'.config('method_data_file');
    }

    /**
     * @return string
     */
    public function getBaseInfoFile()
    {
        return $this->baseInfoFile;
    }

    /**
     * @return string
     */
    public function getNonSmallDataFile()
    {
        return $this->nonSmallDataFile;
    }

    /**
     * @return mixed
     */
    public function getZipFile()
    {
        return $this->zipFile;
    }


}