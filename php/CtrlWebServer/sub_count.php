<?php
/**
 * Created by PhpStorm.
 * User: admin
 * Date: 2015/5/18
 * Time: 0:26
 */
header('Content-Type:application/json;charset=UTF-8');
error_reporting(E_ALL);
$conn = @mysql_connect('localhost','root','');
@mysql_select_db('phptest',$conn);
$results = @mysql_query('select * from device WHERE id="'.$_POST['id'].'"');
$rs = @mysql_fetch_array($results);//$results->fetch_array(MYSQLI_ASSOC);
if($rs){
    @mysql_query('update device set count='.(intval($rs['count']-1)).' where id="'.$_POST["id"].'"');
    $data = array(
        'success' => true,
        'count'    =>   ($rs['count']-1),
    );

    echo json_encode($data);
}else{
    $data = array(
        'success' => false,
    );
    echo "{'success':false}";
}
//$conn->close();
@mysql_close($conn);