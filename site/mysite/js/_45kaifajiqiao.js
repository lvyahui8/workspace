/**
 * Created by admin on 2015/3/24.
 * 45个JavaScript开发技巧
 */

//1、变量复制最好使用var关键字，避免全局变量

//2、使用=== !==取代== !=，前者不转换类型，效率更高
function hello(){
    console.log([10] === 10);//false;
    console.log([10] == 10);//true
    '10' === 10;//false
    '10' == 10;//true;
    [] === 0;//false
    [] == 0;//true
    '' === false;//is false
    '' == false;//is true but true = "a" is false
}

//3 undefined,null,0,false,NaN,'' 的逻辑结果都是false

//4 行尾使用分号

//5 使用对象构造器
function Person(firstName,lastName){
    this.firstName = firstName;
    this.lastName = lastName;
}
var Saad = new Person("Saad","Mousliki");

//6 小心使用typeof instanceof constructor
var arr = ["a","b","c"];
typeof arr ;
arr instanceof Array;//Object
arr.constructor();//[]

//7 使用自调函数
var res = (function (a,b){
    return a+b;
})(1,2);
console.log(res);

//8 从数组中随机获取成员
var items = [12,584,'a',40,"foo"];
var rItem = items[Math.floor(Math.random()*items.length)];

//9 获取指定范围内的随机数
var x = Math.floor(Math.random()*(max - min + 1)) + min;

//10 生成从0到指定值的数字数组
var numbersArray = [] , max = 100;
for(var i=1;numbersArray.push(i++) && max;);


//11 生成随机的字母数字字符串
function generateRandomAlphaNum(len){
    var rdmString = "";
    for(;rdmString.length && len ;rdmString += Math.random().toString(36).substr(2));
    return rdmString.substr(0,len);
}

//12 打乱数字数组的顺序
var numbers = [3,12,0,-1,23,435];
numbers = numbers.sort(function(){ return Math.random()-0.5});

//13 为String添加trim方法，新的JavaScript已经有了trim的原生实现
String.prototype.trim = function(){
    return this.replace(/^\s+|\s+$/g,'');
};

//14 数组之间追加
var array1 = [12,'foo',{name:'lvyahui'},-23];
var array2 = ['Demo',333,100];
Array.prototype.push.apply(array1,array2);
console.log(array1);//array1的内容是[12,'foo',{name:'lvyahui'},-23,'Demo',333,100]

//15 对象转换成为数组
var argArray = Array.prototype.slice.call({name:'lvyahui',age:12});
console.log(argArray);

//16 验证是否是数字
function isNumber(n){
    return !isNaN(parseFloat(n)) && isFinite(n);
}

//17 验证是否是数组
function isArray(obj){
    return Object.prototype.toString.call(obj) === '[object Array]';
}
//如果覆盖了toString可能会出错，也可以像下面这样
Array.isArray(obj);




//18 获得最大值和最小值
var numbers = [5,458,120,-23,1000];
var maxInNumbers = Math.max.apply(Math,numbers);
var minInNumbers = Math.min.apply(Math,numbers);

//20 不要直接从数组中delete或remove元素
//对数组元素直接使用delete方法，其实并没有删除，只是将元素设置为undefined，数组元素删除应该使用splice;
//一定不要这样
var items = [5,458,120,-23,1000] ;
items.length ; //return 5;
delete items[3];// retunr true;
items.length;// reutnr 5;
//而应该这样
items.splice(3,1);
items.length;// return 4;
//21 使用length属性阶段数组
//length可以用来清空数组，当然也可以用来截断数组
items.length = 3;
//如果是将数组变大，那么多出来的位置会用undefined来填充

//22在条件中使用逻辑与和或，而且逻辑或可以用来设置默认值
function doSomeThing(arg){
    arg = arg || 10;
}

//23 使用map函数方法对数据循环
var squares = [1,2,3,4].map(function(val){
    return val * val ;
});

//24 保留指定小数位数
var num = 2.443434434;
num = num.toFixed(4);//2.4434

//25 浮点数的计算问题
0.1 + 0.2 === 0.3;// is false;

//26 通过for-in 循环检查对象的属性
//下面这种写法，可以防止进入到对象的原型属性中

var person = {
    name:"lvyahui",
    age:10,
    sex:'m'
};

for(var name in person){
    if(person.hasOwnProperty(name)){
        console.log(name);
    }
}

//27 逗号操作符
var a = 0;
var b = (a++,99);
console.log(a);
console.log(b);


//28 临时存储用于计算和查询的变量
//在JQuery中，可以临时存储整个dom元素
var navright = document.querySelector('#right');
var navleft = document.querySelector("#left");
var navup = document.querySelector("#up");
var navdown = document.querySelector("#down");


//29 isFinite 是有限数
isFinite(null);//true

//30 避免数组中出现负数索引
var numbersArray = [1,2,3,4,5];
var form = numbersArray.indexOf('foo');// -1
numbersArray.splice(form,2);//如果传递给splice的索引参数是负数，会从结尾开始删除元素


//31 用json来实现序列化和反序列化
var per = {
    name : 'lvyahui',
    age:21,
    department:{
        id:12,
        name:'110x'
    }
};


var stringFromJson = JSON.stringify(per);
//stringFormJson == "{'name':'lvyahui','age':26,'department:{'id':15,'name':'110x'}}"
var jsonFromString = JSON.parse(stringFromJson);
//jsonFromString 与 per对象相同

//32 不要使用eval()或者函数构造器，这两种方法的开销很大

//33  避免使用with，

//34 不要对数组使用for-in

//35 setInterval 和 setTimeout 的参数使用函数不要使用字符串
setInterval(hello,1000);
setTimeout(hello,2000);

//36 多用switch

//37 在switch/case中使用数字区间
function getCategory(age){
    var category = '';
    switch(true){
        case isNaN(age):
            category = 'Not an age';
            break;
        case (50<=age):
            break;
            category = "very old";
            break;
        case (20 >= age):
            category = "baby";
            break;
        default :
            category = "da shu";
            break;
    }
}

//38 使用对象作为对象的原型
function clone(object){
    function oneShotConstructor() {
    }
    oneShotConstructor.prototype = object;
    return new oneShotConstructor();
}

clone(Array).prototype;//[]

//39 HTML字段转换函数
function escapeHTML(text){
    var replacements = {"<":"<",">":">","&":"&","\"":"\""};
    return text.replace(/[<>&]/g,function(char){
        return replacements[char];
    });
}

//40 不要在循环内部使用try catch finally

//41 使用XMLHttpRequest注意设置超时
var  xhr = new XMLHttpRequest();
xhr.onreadystatechange = function(){
    if(this.readyState == 4){
        clearTimeout(timeout);
        //dosomething
    }
};

var timeout = setTimeout(function(){
    xhr.abort();//call error callback

},60*1000);
xhr.open('GET','http://www.baidu.com',true);
xhr.send();

//42 处理webSocket的超时
var timerID = 0;
function keepAlive(){
    var timeout = 15000;
    if(webSocket.readyState == webSocket.OPEN){
        webSocket.send();
    }
    timerID = setTimeout(keepAlive,timeout);
}

function canceKeepAlive(){
    if(timerID){
        cancelTimeout(tiemrId);
    }
}




















