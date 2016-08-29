<?php
/**
 * Created by PhpStorm.
 * User: admin
 * Date: 2015/5/17
 * Time: 23:02
 */
//error_reporting(E_ALL);
$conn = mysql_connect('localhost','root','');
mysql_select_db('phptest',$conn);
$results = mysql_query('select * from device WHERE id="'.$_POST['id'].'"');

$rs = mysql_fetch_array($results);//$results->fetch_array(MYSQLI_ASSOC);
if($rs){
    echo $rs['count'];
}else{
    mysql_query('insert into device (id,count) VALUES ("'.$_POST["id"].'",1000)');
    echo 1000;
}
//$conn->close();
mysql_close($conn);