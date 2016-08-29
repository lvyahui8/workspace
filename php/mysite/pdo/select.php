<?php
/**
 * Created by PhpStorm.
 * User: admin
 * Date: 2015/7/29
 * Time: 22:43
 */

require_once dirname(__FILE__).'../config.php';;

try{
    echo host.'\n';
    $dbh = new PDO("mysql:host=".host.";dbname=".dbname, user, pass);
    $sth = $dbh->query("select * from cds");
    $sth->setFetchMode(PDO::FETCH_OBJ);

    while($row = $sth->fetch()){
        echo $row->titel.'-'.$row->interpret.'-'.$row->jahr.'\n';
    }

}catch (PDOException $e){

}
