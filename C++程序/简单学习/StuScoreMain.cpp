#include "Score.h"
#include <iostream>
using std::cout;

void main(){
	Score nStu(101,20,'M',90,80);
	nStu.ShowS();
	cout<<nStu.GetAge();			//��Score�Ķ�����ø���Ĺ��к���
	cout<<nStu.GetNo();
}