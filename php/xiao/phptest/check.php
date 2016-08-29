<?php

$jsondata = "{model:'xxxx',sn:'yyyyy',ip:'".$_REQUEST['ip']."'}";
echo $_REQUEST['callback'].'('.$jsondata.')';