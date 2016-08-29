if(typeof console !== 'undefined' 
    && typeof console.log === 'function'){
    function ConsoleTool(options){
        //Array.extend();
    }

    ConsoleTool.prototype = {
        constructor :   ConsoleTool,
        autoFlush   :   false,
        outList     :   [],
        maxLength   :   -1,
        oneWidth    :   10,
        bgColor     :   '#CB2027',
        color       :   '#00F',
        bodyLeft    :   20,
        imgWidth    :   48,
        imgHeight   :   48,
        /**
         * 向输出缓冲里面添加一行
         * @param input
         */
        outLine     :   function(){
            var text = arguments[0],
                length = text.replace(/%c/g,'').length;
            if(length > this.maxLength){
                this.maxLength = length;
            }
            this.outList.push(Array.prototype.slice.apply(arguments));
        },
        addImage    :   function(){
            console.log('%c','padding-left:48px;padding-bottom:48px;background:url(http://dummyimage.com/48x48/bd00bd/0311db) no-repeat;');
        },
        flush       :   function(){
            this.maxLength += 5;

            var tool = this,
                width = this.maxLength * this.oneWidth;
            console.log('%c','padding-left:'+width+'px;background-color:'+this.bgColor+';');
            this.outList.forEach(function(item){
                var text = item[0],
                    length = text.replace(/%c/g,'').length,
                    paddingLeft = (tool.maxLength - length) / 2 * tool.oneWidth;
                item[0] = '%c' + item[0];
                item.splice(1,0,'font-size:'+tool.oneWidth+'px;padding-left:'+paddingLeft+'px;'+'border-left:1px solid '+tool.bgColor+'px;');
                console.log.apply(console,item);
            });
            console.log('%c','padding-left:'+width+'px;background-color:'+this.bgColor+';');
        }
    };
    //console.log('%c','padding:90px 90px 90px 90px;background:url(http://images0.cnblogs.com/blog2015/635249/201507/132304161577155.jpg) no-repeat;');
    /*
    var consoleTool = new ConsoleTool(),
        highlightStyle = 'color:red;';
    consoleTool.outLine('我是%c吕亚辉',highlightStyle);
    consoleTool.outLine('热爱%cweb%c开发',highlightStyle,'color:black');
    consoleTool.outLine('有了一年的web开发经验');
    consoleTool.outLine('主要从事web后台开发，主要开发语言是java和php');
    consoleTool.outLine('下面是我参与的一些项目');
    consoleTool.outLine('http://www.aosaiban.com');
    consoleTool.outLine('http://112.74.98.137');
    consoleTool.outLine('http://123.57.235.49');
    consoleTool.outLine('对于前端，我也有所了解，下面是我做的前端');
    consoleTool.outLine('http://www.hnyhc.com/');
    consoleTool.outLine('http://wenwei.cc/');
    consoleTool.outLine('http://www.payingbox.com');
    consoleTool.outLine('对于linux系统也有一些了解，熟悉常用的命令');
    consoleTool.flush();
    */
    var highlightStyle = 'color:red',
        normalStyle = 'color:black';
    console.log("%c\n",'line-height:140px;padding:70px 70px 70px 70px;background:url(http://files.cnblogs.com/files/lvyahui/avatarv2.gif) 50% 50% no-repeat');
    console.log("我是%c吕亚辉%c,现居湖南长沙,学生",highlightStyle,normalStyle);
    console.log("现专注于web开发.本人希望将来能更底层的开发与设计,并在为此努力");
    console.log("有近%c一年半的开发经验%c，其中参与且已经上线的产品有",highlightStyle,normalStyle);
    console.log("http://wenwei.cc/ http://www.hnyhc.com/ http://www.aosaiban.com http://112.74.98.137 http://123.57.235.49 http://www.payingbox.com http://cx.fzw580.com/user/login 等");
    console.log("其中 奥赛班项目 http://www.aosaiban.com 给我很大的收获,");
    console.log("这个项目将我以前所学包括前台,后台,数据库,网络,运维,全部融会贯通.");
    console.log("也是从这个项目开始,我渐渐要求自己时刻要写出高可读,高复用,高性能的代码.");
    console.log("本人%c擅长的开发语言是C++,Java和PHP.对linux系统,也有近2年的使用和维护经验",highlightStyle);
    console.log("现在求职当中,如果对本人感兴趣的，可以与本人联系 ");
    console.log("tencent://message/?uin=1257069082 mailto:devlyh@163.com,lvyahui8@126.com");

}
