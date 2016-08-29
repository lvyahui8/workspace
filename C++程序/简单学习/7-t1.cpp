/*
1. 定义一个 Employee类，其中包括姓名、街道地址、城市和邮编等属性，以及 
change_name() 和 display() 等函数。 display() 显示姓名、街道地址、城市
和邮编等属性， change_name() 改变对象的姓名属性。实现并测试这个类。
*/
#include "CEmployee.h"

void main(){
	CEmployee fineEmp1;
	CEmployee fineEmp2("AgrinDJ","海经","海口",0);
	CEmployee fineEmp3;

	fineEmp3 = fineEmp2;
	fineEmp1.fnChange_Name("AgrinLv");

	fineEmp1.fnDisplay();
	fineEmp2.fnDisplay();
	fineEmp3.fnDisplay();
}
