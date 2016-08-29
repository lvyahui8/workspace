<?php
/**
 * Created by PhpStorm.
 * User: samlv
 * Date: 2016/3/15
 * Time: 16:08
 */
return array(
    /**
     * 数据库配置
     */
    'db'               => array(
        /**
         * zip 包保存的地址数据库配置
         * mysql -uphotoadmin -p123456 -h10.198.30.62 -P3786 zz
         */
        'remote' => array(
            'host' => 'localhost',
            'port' => 3306,
            'name' => 'remote',
            'user' => 'root',
            'pass' => 'root',
        ),
        /**
         * zip包解析之后由tdw推出的数据库地址
         * mysql -uitil -pitil -h10.206.30.82 -P4121 zz
         */
        'tdbank' => array(
            'host' => '10.206.30.82',
            'port' => '4121',
            'name' => 'zz',
            'user' => 'itil',
            'pass' => 'itil',
        ),
        /**
         * 最终的分析结果存储的数据库地址，也是默认被Eloquent使用的默认的连接地址
         */
        'local'  => array(
            'host' => '127.0.0.1',
            'port' => '3306',
            'name' => 'myapm',
            'user' => 'root',
            'pass' => 'root',
        ),
    ),
    /**
     * 上报的记录上报基本信息的文件，包括app_id，version_id,uin,model,qua等等信息
     */
    'base_info_file'   => 'baseInfo',
    /**
     * 上报的记录方法调用次数的文件
     */
    'method_data_file' => 'nonSmallData',
    /**
     * 对字段转义，主要解决日志文件key-value的key与数据库中的字段不对应的问题
     */
    'translate'        => array(),
    /**
     * 入库到数据库中字段的默认值
     */
    'default_vals'     => array(
        'p_id'   => 6,
        'plugin' => 11,
    ),
);