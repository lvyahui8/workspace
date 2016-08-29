<?php
/**
 * Created by PhpStorm.
 * User: admin
 * Date: 2015/5/17
 * Time: 22:32
 */

?>
<!doctype html>
<html lang="zh-CN">
<head>
    <meta charset="UTF-8">
    <title>Document</title>
</head>
<body>
<form action="http://phptest.com/check.php" name='info' method="post"  onsubmit="return false">
    IP:<input type="text" name='ip' value="<?=isset($_GET['ip']) ? $_GET['ip'] : NULL;?>"/>
    <button onclick="check()">连接</button>
    <br/>
</form>
<div class="">
    <?php if(isset($_GET['model'])){?>
        <div>设备已经连接</div>
        <div>设备ID</div><div><?=$_GET['sn']?></div>
        <div>寿命</div><div data-ajax="local_query.php" data-id="<?=$_GET['sn']?>"></div>
    <?php }else{?>
        <div>设备未连接</div>
    <?php }?>
</div>
<form action="http://phptest.com/action.php" name="ctrl" >
    <input type="radio" name="act" value="A1"/> 开
    <input type="radio" name="act" value="A2" checked/> 关
</form>
<script src="js/jquery-1.8.3.min.js"></script>
<script>
    function check(){
        var ipOk = /^(\d{1,2}|1\d\d|2[0-4]\d|25[0-5])(\.(\d{1,2}|1\d\d|2[0-4]\d|25[0-5])){3}$/.test(info.ip.value);
        if(ipOk){
            $.getJSON(
                document.info.action+'?callback=?',
                {
                    ip:info.ip.value
                },
                function(data){
                    if('model' in data){
                        //console.log(window.location);
                        window.location.href='/CtrlWebServer/nano.php?model='+data.model+'&sn='+data.sn+'&ip='+data.ip;
                    }else{
                        alert('认证失败');
                    }
                }
            )
        }else{
            alert('非法的ip地址');
        }
    }
    $('input[name=act]').change(function(){
        $.getJSON(
            document.ctrl.action+'?callback=?',
            {
                action:document.ctrl.act.value
            },
            function(data){
//                console.log(data);
                if(data.msg === 'OK'){
                    // 向本地web请求减少寿命
                    var countE = $('[data-ajax]');
                    var id = countE.attr('data-id');
                    $.post('sub_count.php',{id:id},function(resp){
                        if(resp.success){
                            countE.html(resp.count);
                        }else{

                        }
                    });
                }
            }
        );
    });
    $(function(){
        $('[data-ajax]').each(function(){
            var _this   =   $(this),
                url     =   _this.attr('data-ajax'),
                id      =   _this.attr('data-id');
            $.post(url,{id:id},function(resp){
                    _this.html(resp);
            })
        });
    });
</script>
</body>
</html>