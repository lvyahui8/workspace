#include "Examtotal.h"
#include <iostream>
using std::cout;
using std::endl;

int Examtotal::count = 0;
int Examtotal::sum = 0;
//Examtotal 类 实现方法
Examtotal::Examtotal(int m){
	num = ++count;					//设置学号
	score = m;						//考试分数
	sum += score;					//修改总分
}

void Examtotal::Message(){
	cout<<"共"<<count<<"学生参加考试,考试总分: "<<sum<<endl;
}

void Display(Examtotal &s){
	cout<<s.num<<' '<<s.score<<endl;
}
