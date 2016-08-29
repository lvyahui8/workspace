<?php
/**
 * 未写完，因为策略的改变，这个脚本已经作废。
 * Created by PhpStorm.
 * User: samlv
 * Date: 2016/3/17
 * Time: 17:31
 */
require_once ('start.php');
require_once ('models/Apk.php');
require_once ('config.php');
require_once 'library/UsedMethodData.php';
//$apk = Apk::all();
$usedMethodData = new UsedMethodData();
$usedMethodData->updateMethodNum();




