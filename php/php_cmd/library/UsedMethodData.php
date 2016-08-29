<?php
require_once __DIR__.'/../start.php';
require_once 'MethodMarker.php';
/**
 * Created by PhpStorm.
 * User: samlv
 * Date: 2016/3/17
 * Time: 19:27
 */
class UsedMethodData
{
    public function updateMethodNum()
    {
        $tdbankDb = config('db.tdbank');
        $dbh = new PDO("mysql:host={$tdbankDb['host']}:{$tdbankDb['port']};dbname={$tdbankDb['name']}",$tdbankDb['user'],$tdbankDb['pass']);
        $sql = "select * from zz_pack_analysis";
        $this->query($dbh,$sql,function($row){
            $methodMarker = new MethodMarker($row);
            $methodMarker->markNotUsed();
        });
    }

    private function query(PDO $dbh, $sql, callable $callback)
    {
        $sth = $dbh->query($sql);
        $sth->setFetchMode(PDO::FETCH_OBJ);
        $rows = array();
        while($row = $sth->fetch()){
            $rows [] = $row;
            if($callback) $callback($row);
        }
        return $rows;
    }

}