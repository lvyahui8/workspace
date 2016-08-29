<?php
/**
 * Created by PhpStorm.
 * User: admin
 * Date: 2015/4/21
 * Time: 17:33
 */

require_once 'config.php';

try{
    $dbh = new PDO("mysql:host=".host.";dbname=".dbname, user, pass);
    $sth = $dbh->prepare("select * from cds");
    $sth->setFetchMode(PDO::FETCH_OBJ);

    while($row = $sth->fetch()){
        echo $row->titel.'-'.$row->interpret.'-'.$row->jahr.'\n';
    }

}catch (PDOException $e){

}
