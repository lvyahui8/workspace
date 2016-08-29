<?php
//?action=A1&callback=???????
header('application/javascript;charset=UTF-8');
$msg = $_GET['action'] === 'A1' ? 'OK' : 'FAIL';
$jsondata = "{msg:'".$msg."'}";
echo $_GET['callback'].'('.$jsondata.')';