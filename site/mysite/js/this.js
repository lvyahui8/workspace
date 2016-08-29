/**
 * Created by admin on 2015/4/9.
 */

/**
 * this机制
 *
 */

function identify(){
    return this.name.toUpperCase();
}

function sayHello(){
    var greeting = "hello,I"+identify.call(this);
    console.log(greeting);
}

var person1 = {name:"Kyle"};
var person2 = {name:"Blut"};

identify.call(person1);
identify.call(person2);
sayHello.call(person1);//hello,Kyle
sayHello.call(person2);//hello,Blut


//误区一：this指向或引用函数本身
function fn(num){
    console.log("fn"+num);
    this.count++;
}
fn.count = 0;
for(var i=0;i<5;i++){
    fn(i);
}
console.log(fn.count);//0

//误区二：this引用的是function的词法作用域
function fn1(){
    var a = 2;
    this.fn2();//以为this引用的是fn1的词法作用域
}
function fn2(){
    console.log(this.a);
}
//fn1();//ReferenceError，执行成功是偶然的

/**
 * this 到底做什么的
 * 重点，this跟函数在哪申明的没有任何关系，函数在哪里被调用才是决定了this到底引用的是什么
 * 也就是说this引用的是运行环境
 * 下面看this的四种绑定规则
 */

//1默认绑定全局变量，默认的
function f(){
    console.log(this.a);
}
var a = 2;
f();//2 fn单独调用this引用的是window，在Node.js中输出的是undefined

//2隐式绑定
function ff2(){
    console.log(this.aa2);//this引用的是被绑定的ob2
}

var ob2 = {
    aa2:2,
    fn:ff2
}
ob2.fn();//2

//3显示绑定
function ff3(){
    console.log(this.aa3);
}

var ob3 = {
    aa3:3
}
ff3.call(ob3);//3
var aa3 = 10;
ff3.call(null);//10,在node.js中试undefined

//4new新对象绑定
function ff4(a){
    this.a = a;
}
var car = new ff4(10);
console.log(car.a);//10
