<?php
/**
 * Created by PhpStorm.
 * User: admin
 * Date: 2015/7/29
 * Time: 22:48
 */

require_once '../config.php';

$conn = mysql_connect(host,user,pass);

mysql_select_db(dbname);

$sql = 'select * from `cds`';

$rs = mysql_query($sql);
if($rs){
    while($data = mysql_fetch_assoc($rs)){
        p($data);
    }

}

$sql = 'insert into `cds` (titel,interpret,jahr) VALUES ("dd","mg",2)';

mysql_query($sql);

mysql_free_result($rs);
mysql_close($conn);


class BaseController{

}
class Controller{

}

