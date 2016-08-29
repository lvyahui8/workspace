<?php

/**
 * Created by PhpStorm.
 * User: samlv
 * Date: 2016/3/18
 * Time: 10:36
 */
class ReportData
{
    protected $dataFile;

    protected $data  = array();

    /**
     * ReportData constructor.
     * @param $dataFile
     */
    public function __construct($dataFile)
    {
        $this->dataFile = $dataFile;
    }

    public function analyseData(callable $callback = null){
        if(count($this->data) > 0){
            array_map($callback,$this->data,array_keys($this->data));
        }
        else if(file_exists($this->dataFile)){
            $fp = fopen($this->dataFile,'r');
            while(!(feof($fp))){
                $row = fgets($fp);
                $compsData = explode(':',$row);
                if(count($compsData) < 2 || trim($compsData[1]) === '') continue;
                $this->data [trim($compsData[0])] =  str_replace(array("\r", "\n"), '', trim($compsData[1]));
                if($callback){
                    $callback($compsData[0],trim($compsData[1]));
                }
            }
            fclose($fp);
        }
    }
}