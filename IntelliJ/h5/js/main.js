
function People(name){
    this._name = name;
}

People.prototype.say = function(){
    alert("peo-hello:"+this._name);
}

function Student(name){
    this._name = name;
}

Student.prototype = new People();
var superSsay = Student.prototype.say;
Student.prototype.say = function(){
    superSsay.call(this);
    alert("stu-hello:"+this._name);
}

var s = new Student("lvyahui");
s.say();

