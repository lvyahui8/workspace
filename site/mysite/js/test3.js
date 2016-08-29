/**
 * Created by admin on 2015/3/6.
 */
console.log(!false);
console.log(!"blue");
console.log(!0);
console.log(!NaN);
console.log(!"");
console.log(!123);


var found = true;
var someVar;
var result = (found && someVar);
console.log(result);        //  result:undefined
result = false && someVar;
console.log(result);        //  false


result = (found || someUndefinedVar);
console.log(result);    //能够执行到这里，输出结果为true，因为没有对第二个表达式求值了


var r1 = 5 - true;      //  4
var r2 = NaN - 1;       //  NaN
var r3 = 5 - "";        //  5
var r4 = 5 - "2";       //  3
var r5 = 5 - null;      //  5

console.log(r1+r2+r3+r4+r5);

result = "Bick" < "alphabet";       // true
result = "Bick".toLowerCase() < "alphabet".toLowerCase();       //  false;
result = "23" < "3";    //true
result = "23" < 3;  // false;
console.log(result);

console.log(null == undefined);

var num = (5,4,2,3,0);  //  num值为0 即表达式最后一项的值


for(var propName in window){
    document.write(propName+"<br/>");
}

var n = 0;

outermost:
for(var i = 0;i<10;i++){
    for(var j=0;j<10;j++){
        if(5==i && 5==j){
            break outermost;
        }
        n ++;
    }
}

console.log(n); //55

n = 0;
outermost2:
for(var i=0;i<10;i++){
    for(var j =0;j<10;j++){
        if(5==i&&5==j){
            continue outermost2;
        }
        n++;
    }
}

console.log(n);//95

switch("hello world"){
    case "hello" + " world":
        console.log("Greeting was found" +
        "");
        break;
    case "goodbye":
        console.log("Closing was found");
        break;
    default:
        console.log("Unexpected message was found");
}

num = 25;
switch (true){
    case num < 0:
        console.log("Less than 0.");
        break;
    case num >= 0 && num <= 10:
        console.log("Between 0 and 10");
        break;
    case num > 10 && num <=20:
        console.log("Between 10 and 20.");
        break;
    default:
        console.log("More than 20.");
}
/*
switch 语句在比较值的时候使用的是全等操作符，因此不会发生类型转换（例如，字符串"10"不等于10）。
 */
function sayHi(){
    console.log("Hello "+arguments[0]+","+arguments[1]);
}

sayHi("lv Ya Hui","Deng Jie");

