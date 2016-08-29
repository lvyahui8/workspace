<?php
/**
 * Created by PhpStorm.
 * User: Administrator
 * Date: 15-5-24
 * Time: 下午4:49
 */

class OrderController extends BaseController {
    public function getIndex(){

    }
    public function reOrder(){
        print_r($_POST);
        print_r($_SERVER);
        //Redirect::to('');
        return 'hello';
    }
} 