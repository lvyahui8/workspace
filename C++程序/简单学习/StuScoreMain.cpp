#include "Score.h"
#include <iostream>
using std::cout;

void main(){
	Score nStu(101,20,'M',90,80);
	nStu.ShowS();
	cout<<nStu.GetAge();			//类Score的对象调用父类的公有函数
	cout<<nStu.GetNo();
}