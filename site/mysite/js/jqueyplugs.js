/**
 * Created by admin on 2015/3/26.
 */




//一、类级别（静态方法）的插件开发

//方式1



jQuery.foo = function(){
    console.log("Thist is a static method");
};

jQuery.bar = function(param){
    console.log('This function takes a paramter'+param);
};

//方式2
jQuery.extend({
    foo2 : function(){
        console.log("This extend");
    },
    bar2 : function(param){
        console.log("This extend"+param);
    }
});

//方式3 增加命名空间
jQuery.myPlugin = {
    foo:function(){
      console.log("myPlugin foo");
    },
    bar : function(){
        console.log("myPlugin bar");
    }
};

//二、对象级别的插件开发
//形式1
(function($){
    $.fn.extend({
        pluginName:function(opt,callback){
            console.log('object plugs1');
        }
    })
})(jQuery);
//形式2
(function($){
    $.fn.pluginName2 = function(){
        console.log('object plugs2');
    };
})(jQuery);

$.fn.hilight = function(options){
    var defaults = {
        foreground:'red',
        background:'yellow'
    };

    var opts = $.extend(defaults,options);
};
//形式3，暴露插件的默认设置
$.fn.study = function(options){
  var opts = $.extend({}, $.fn.study.defaults,options);
};

$.fn.study.defaults = {
    foreground:'red',
    background:'yellow'
};


// 创建一个闭包
(function($) {
    // 插件的定义
    $.fn.hilight = function(options) {
        debug(this);
        // build main options before element iteration
        var opts = $.extend({}, $.fn.hilight.defaults, options);
        // iterate and reformat each matched element
        return this.each(function() {
            $this = $(this);
            // build element specific options
            var o = $.meta ? $.extend({}, opts, $this.data()) : opts;
            // update element styles
            $this.css({
                backgroundColor: o.background,
                color: o.foreground
            });
            var markup = $this.html();
            // call our format function
            markup = $.fn.hilight.format(markup);
            $this.html(markup);
        });
    };
    // 私有函数：debugging
    function debug($obj) {
        if (window.console && window.console.log)
            window.console.log('hilight selection count: ' + $obj.size());
    }
    // 定义暴露format函数
    $.fn.hilight.format = function(txt) {
        return '<strong>' + txt + '</strong>';
    };
    // 插件的defaults
    $.fn.hilight.defaults = {
        foreground: 'red',
        background: 'yellow'
    };

// 闭包结束
})(jQuery);




















