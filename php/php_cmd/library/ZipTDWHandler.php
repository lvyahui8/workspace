<?php
require_once('functions.php');
require_once(__DIR__.'/../config.php');
require_once('ZipDataStorage.php');

/**
 * Created by PhpStorm.
 * User: samlv
 * Date: 2016/3/17
 * Time: 13:27
 */
class ZipTDWHandler
{
    private $zipFile;

    /**
     * ZipHandler constructor.
     * @param $zipFile
     */
    public function __construct($zipFile)
    {
        $this->zipFile = $zipFile;
    }

    public function handle()
    {
        out("Start analyzing zip package : {$this->zipFile} .\n");
        $successNum = 0;
        $zipDataStorage = new ZipDataStorage($this->zipFile);
        $zipDataStorage->getDatas(function ($methodData) use (&$successNum) {
            //http://10.254.102.154:8000/tdbus/common?bid=b_sng_qzone_zhizi&tid=sng_qzone_zhizi_fpsm&dt=1457516414563&body=4|6.3.0.0|iPhone6,2||||0|||||||||||||||45242|||||||actFPSRecent|10|1000|10|7|4
            $defaultVals = config('default_vals');
            if (!$defaultVals) $defaultVals = array();
            $row = array_merge(array(
                /*在新的zhizi.oa.com中的p_id是6，而在旧的上报数据表zz.zz_upload中p_id是8*/
                'p_id'           => 6,
                'versionname'    => 'ver1',
                'model'          => '',
                'manu'           => '',
                'apilevel'       => '',
                'cpu'            => '',
                'cpucore'        => 2,
                'freememory'     => '',
                'totalmemory'    => '',
                'cpurate'        => '',
                'processname'    => '',
                'timecost'       => '',
                'threadtimecost' => '',
                'qua'            => '',
                'imei'           => '',
                'os'             => '',
                'network'        => '',
                'display'        => '',
                'signal'         => '',
                'ssid'           => '',
                'ip'             => '',
                'uin'            => '',
                'class'          => '',
                'root'           => '',
                'proxy'          => '',
                'disk'           => '',
                'sddisk'         => '',
                'uniqid'         => '',
                'actTAG'         => '',
                'frameCount'     => '',
                'diffTime'       => '',
                'fps'            => '',
                'aioBusiness'    => '',
                'plugin'         => 11,
                'app_id'         => 0,
                'version_id'     => 0,
                'method_id'      => 0,
                'num'            => '',
                'reported_at'    => date('Y-m-d H:i:s'),
            ), $defaultVals, $methodData);
            $datas = array(
                'bid'  => 'b_sng_qzone_zhizi',
                'tid'  => 'sng_qzone_zhizi_report',
                'dt'   => getMillisecond(),
                'body' => implode('|', $row),
            );

            $params = http_build_query($datas);
            out("Params : $params\n");
            $curl = curl_init('http://10.254.102.154:8000/tdbus/common?' . $params);
            curl_setopt($curl, CURLOPT_RETURNTRANSFER, true);
            curl_setopt($curl, CURLOPT_BINARYTRANSFER, true);
            curl_setopt($curl, CURLOPT_TIMEOUT, 3);
            $resp = curl_exec($curl);
            curl_close($curl);
//        $curl = curl_init('');
//        curl_setopt($curl, CURLOPT_RETURNTRANSFER, true);
//        curl_setopt($curl, CURLOPT_POST, true);
//        curl_setopt($curl, CURLOPT_POSTFIELDS, $datas);
//        $resp = curl_exec($curl);
//        curl_close($curl);
            if ($resp) {
                $successNum++;
                out("Response : $resp\n");
            } else {
                out("Storage timeout!\n");
            }
        });
        out("End of analysis zip package,Successfully put in $successNum data.\n");
    }
}