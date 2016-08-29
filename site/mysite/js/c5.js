/**
 * Created by admin on 2015/3/29.
 */


/*
 数组类型
 */

//stack
var colors = ['red', 'blue'];
colors.push('brown');
console.log(colors);
console.log(colors.length);
var item = colors.pop();
console.log(item);
console.log(colors);

//队列
colors = [];
var count = colors.push('red', 'green');
console.log(count);
console.log(colors);
count = colors.push('black');
console.log(count);
item = colors.shift();
console.log(item);
console.log(colors);
console.log(colors.length);

//pop 与 unshift搭配可以实现反向队列


//重新排序
var values = [1, 2, 3, 4, 5, 6];
values.reverse();
console.log(values);

values = [0, 1, 5, 10, 15];
values.sort();//sort方法默认进行字符串比较，即调用toString方法比较结果
console.log(values);

//为了实现自定义排序，可以这样
function comp(var1, var2) {
    return var1 - var2;
}

values.sort(comp);
console.log(values);

/*
 数组操作方法
 */


//数组复制合并
var colors1 = ['red', 'green', 'blue'];
var colors2 = colors1.concat('yellow', ['black', 'brown']);
console.log(colors1);
console.log(colors2);


//slice方法，这个方法的操作不会影响原来的数组
colors = ['red', 'green', 'blue', 'yellow', 'purple'];
colors2 = colors.slice(1);
var colors3 = colors.slice(1, 4);
console.log(colors2);
console.log(colors3);

//splice方法，最强的数组操作方法
//删除
colors.splice(0, 2);//要删除的第一项的位置和要删除的项数
console.log(colors);
//插入
colors.splice(2, 0, 'red', 'green');//起始位置、0（要删除的项）和要插入的项-‘red’，‘green’
console.log(colors);
//替换
colors.splice(2, 1, 'white');//起始位置，删除项数，插入项
console.log(colors);
//这个方法的返回值是被删除的数组，如果没有删除，返回一个空数组

console.log(colors.indexOf('green'));
console.log(colors.lastIndexOf('green'));

//数组迭代方法
//every，都返回ture才返回true
numbers = [1, 2, 3, 4, 5, 4, 3, 2, 1];
var everyRes = numbers.every(function (val, index, arr) {
    return (val > 2);
});
console.log(everyRes);

//some，只要有一项为true，则结果为true
var someRes = numbers.some(function (val, index, arr) {
    return val > 2;
});
console.log(someRes);

//filter，返回该函数会返回true的项构成的数组
var filterRes = numbers.filter(function (val, index, arr) {
    return val > 2;
});
console.log(filterRes);

//map，返回函数调用结果形成的数组;
var mapRes = numbers.map(function (val, index, arr) {
    return val * 2;
});
console.log(mapRes);

//forEach，这个方法没有返回值
numbers.forEach(function (val, index, arr) {
    //执行操作
});


/*
 Date类型
 */

var now = new Date();
console.log(now);

var someDate = new Date(Date.parse('May 25,2005'));//与new Date('May 25,2005)等价
console.log(someDate);

var y2k = new Date(Date.UTC(2012, 5, 8));//2012年6月8日
console.log(y2k);

var start = Date.now();
start = +new Date();//这样是为不支持Date.now的浏览器兼容，把Date对象转换成字符串

//日期类支持大于小于操作符
console.log(now > start);

//日期格式化
var date = new Date();

console.log(date.toLocaleDateString());//2015-03-29;
console.log(date.getFullYear() + '...' + (date.getMonth() + 1) + '...' + date.getDate());


/*
 RegExp类型
 */

var exp = /^\d+$/ig;//必须转义(\)的元字符 ( [ { \ ^ $ | ) ? * + . ] }
console.log(exp.test('12324234a'));

var expEmail = /^\w+@\w+\.\w+\.?\w*$/i;
console.log(expEmail.test('lvyahui8@126.com'));
console.log(expEmail.test('lvyahui8@126.com.'));
console.log(expEmail.test('lvyahui8@126.com.cn'));
console.log(expEmail.test('lvyahui8@126.co-'));
var expEmail2 = new RegExp('^\\w+@\\w+\\.\\w+\\.?\\w*$', 'i');
console.log(expEmail2.test('lvyahui8@126.com'));
console.log(expEmail2.test('lvyahui8@126.com.'));
console.log(expEmail2.test('lvyahui8@126.com.cn'));
console.log(expEmail2.test('lvyahui8@126.co-'));

//exec方法
var text = 'mom and dad and baby';
var pattern = /mom( and dad( and baby)?)?/gi;
var matches = pattern.exec(text);
console.log(matches.index);
console.log(matches.input);
console.log(matches[0]);
console.log(matches[1]);
console.log(matches[2]);

text = 'cat, bat, sat, fat';
pattern = /.at/;
matches = pattern.exec(text);
console.log(matches.index);
console.log(matches[0]);
console.log(pattern.lastIndex);

matches = pattern.exec(text);
console.log(matches.index);
console.log(matches[0]);
console.log(pattern.lastIndex);

pattern = /.at/g;
matches = pattern.exec(text);
console.log(matches.index);
console.log(matches[0]);
console.log(pattern.lastIndex);

matches = pattern.exec(text);
console.log(matches.index);
console.log(matches[0]);
console.log(pattern.lastIndex);


/*
 Function 类型
 */

function sum(num1, num2) {
    return num1 + num2;
}
var sum2 = function (num1, num2) {
    return num1 + num2;
};

var otherName = sum2;
console.log(otherName(3, 2));

//函数并不能重载的根本原因在于函数名只是个指针，重新申明一个函数只是修改了函数指针的值
function factorial(num) {
    if (num <= 1) {
        return 1;
    }
    else {
        return num * arguments.callee(num - 1);//将函数的执行过程与函数名解耦
    }
}
/*
 window.color = 'red';
 var o = {color:'blue'};
 function sayColor(){
 console.log(this.color);
 }
 sayColor();//'red' 当在网页的全局作用域调用函数时，t在该函数里，this对象指向window
 o.sayColor = sayColor;
 o.sayColor();//'blue'
 //函数名只是个指针，全局sayCOlor和o.sayCOlor指向的是同一个函数
 */
function sayName(name) {
}
function cp(a, b) {
}
function pt() {
}
console.log(sayName.length);//1
console.log(cp.length);//2
console.log(pt.length);//0


/*
 函数属性和方法
 */

//属性，length，prototype

function person(name, age) {
    this.name = name;
    this.age = age;
    function getName() {
        return this.name;
    }
}

console.log(person.length);//1
console.log(person.prototype);//{}


//function apply，call
function callSum1(num1, num2) {
    return sum.apply(this, arguments);
}

function callSum2(num1, num2) {
    return sum.apply(this, [num1, num2]);
}

function callSum3(num1, num2) {
    return sum.call(this, num1, num2);
}

console.log(callSum1(10, 10));//因为在全局作用域中调用，所以
console.log(callSum2(10, 10));
console.log(callSum3(10, 10));

var o = {color: 'blue'};

function sayColor() {
    console.log(this.color);
}

//这里输出为undefined 是因为当前运行环境不在浏览器，也就是不在window的作用域，this指针并不指向window
console.log(this);  //{}
sayColor();             //red
sayColor.call(this);    //red
sayColor.call(window);  //red

sayColor.call(o);       //blue

//bind方法
var window = {color: 'red'};
var o = {color: 'blue'};

function sayColor() {
    console.log(this.color);
}

var objSayColor = sayColor.bind(o);
objSayColor();


/*
 基本包装类型
 */

//String
var s1 = 'come.text';
var s2 = s1.substring(2);
//使用new关键字创建的实例，在执行流离开当前作用域之前都一直保存在内存中。而自动创建的基本包装类的对象，
//则只存在于一行代码的执行瞬间，然后立刻被销毁，所以不能动态为基本类型值添加属性和方法
s1 = 'come text';
s1.color = 'red';
console.log(s1.color);//undefined

var obj = new Object('some test');
console.log(obj instanceof String);//true

//注意，使用new 调用构造函数与直接调用同名的转型函数是不一样的
var value = '25';
var number = Number(value);
console.log(typeof number);//number

var obj = new Number(value);
console.log(typeof  obj);//object


//--Boolean
var falseObj = new Boolean(false);
var result = falseObj && true;

console.log(result);

var falseValue = false;
result = falseValue && true;
console.log(result);

console.log(typeof falseObj);//object
console.log(typeof falseValue);
console.log(falseObj instanceof Boolean);
console.log(falseValue instanceof Boolean);

//--Number
var numberObject = new Number(10);
console.log(numberObject.toString());//10
console.log(numberObject.toString(2));//1010
console.log(numberObject.toString(8));//12
console.log(numberObject.toString(16));//a
console.log(numberObject.toFixed(2));
//如果长度过长，以最大接近小数位进行舍入
console.log((new Number(10.0047)).toFixed(2));//10.00
console.log((new Number(10.005)).toFixed(2));//10.01
//String
var strValue = "我是lvyahui";
console.log(strValue.length);   //即使是双字节字符也算一个字符

console.log('String Start');
//String 类型
//模式匹配
//match方法，找到第一个匹配的
var text = "hello world,lvyahui";
var pattern = /.l/;
var matches = text.match(pattern);
console.log(matches.index);//1
matches.every(function (i) {
    console.log(i);
});
console.log(pattern.lastIndex);//0

//search 方法，返回第一个匹配字符串的位置
var pos = text.search(/l/);
console.log(pos);
//replace 方法，两个参数，如果第一个参数是字符串的话，只会替换第一个字符。要想替换所有的字符串，必须使用正则
text = "hello,this is 15$,you &mi"
var repRes = text.replace(/l/g, "w");
console.log(repRes);
repRes = text.replace(/(l)/g, "w $1");
console.log(repRes);

function htmlEscpae(text) {
    return text.replace(/[<>"&]/g, function (match, pos, originalText) {
        switch (match) {
            case "<":
                return "&lt;";
                break;
            case ">":
                return "&gt;";
                break;
            case "&":
                return "&amp;";
                break;
            case "\"":
                return "&quot;";
                break;
        }
    });
}

console.log(htmlEscpae("<p class=\"greeting\">hello world!</p>"));

var colorText = "red,blur,,green,yellow";
var c1 = colorText.split(",");
var c2 = colorText.split(",", 2);//指定数组的大小
var c3 = colorText.split(/[^\,]/);
console.log(c1);
console.log(c2);
console.log(c3);










































































