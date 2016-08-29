<?php
/**
 * Created by PhpStorm.
 * User: admin
 * Date: 2015/7/29
 * Time: 22:41
 */
require_once dirname(__FILE__).'../config.php';

try{
    $dbh = new PDO("mysql:host=".host.";dbname=".dbname, user, pass);
    $sth = $dbh->prepare("insert into `cds` (titel,interpret,jahr) VALUES (:titel,:interpret,:jahr)");
    $titel = 'lvyahui';
    $interpret = 'admin888';
    $jahr = 8;
    $sth->bindParam(':titel',$titel);
    $sth->bindParam(':interpret',$interpret);
    $sth->bindParam(':jahr',$jahr);
    $sth->execute();
    // or
    $data = array('titel'=>'lvyahui','interpret'=>'admin888','jahr'=>9);
    $sth->execute($data);


}catch (PDOException $e){

}
