<?php
require_once ('functions.php');
require_once ('ZipParser.php');
/**
 * Created by PhpStorm.
 * User: samlv
 * Date: 2016/3/16
 * Time: 15:33
 */
class ZipLoader
{
    private $params = array();

    public function addParams($params)
    {
        $this->params = array_merge($this->params, $params);
    }

    private $entitys = array();

    public function loadZipEntitys(callable $callback = null)
    {
        $remoteDB = config("db.remote");
        $dbh = new PDO("mysql:host={$remoteDB['host']}:{$remoteDB['port']};dbname={$remoteDB['name']}", $remoteDB['user'], $remoteDB['pass']);
        $sql = "select * from zz_upload WHERE " . $this->buildParams();
        out("Sql : $sql\n");
        $sth = $dbh->query($sql);
        $sth->setFetchMode(PDO::FETCH_OBJ);
        while ($row = $sth->fetch()) {
//            echo $row ->f_id. '-'.$row ->f_url. '-'.$row ->f_qq. '-' .$row->p_id .'-'. $row->f_uploadtime.'\n';
            $this->entitys [] = $row;
            if($callback) {
                $callback($row);
            }
        }
    }

    private function buildParams()
    {
        $paramsStr = '';
        $real = '';
        foreach ($this->params as $rl => $param) {
            $paramsStr .= $real;
            $val = end($param);
            if (is_string($val)) $val = "'$val'";
            $paramsStr .= count($param) == 2 ? "{$param[0]}=$val" : "{$param[0]}{$param[1]}$val";
            if (is_string($rl)) {
                $real = strtoupper($rl);
            } else {
                $real = ' AND ';
            }
        }
        return $paramsStr;
    }

    /**
     * @return array
     */
    public function getEntitys()
    {
        if(!count($this->entitys)){
            $this->loadZipEntitys();
        }
        return $this->entitys;
    }

    public function handleZips($params,ZipParser $zipParser){
        $sum = 0;
        $this->addParams($params);
        $this->loadZipEntitys(function($entity) use(&$sum,&$zipParser){
            $zipFile = 'tmp/zip/' . md5($entity->f_url) . '.zip';
            if(download($entity->f_url,$zipFile)){
                $zipParser->setZipFile($zipFile);
                $zipParser->handle();
                $sum ++;
                unlink($zipFile);
            }
        });
        return $sum;
    }
}