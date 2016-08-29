#include "Examtotal.h"
#include <iostream>
using std::cout;
using std::endl;
void main(){
	Examtotal::Message();					//引用静态公有函数成员
	cout<<Examtotal::sum<<endl;				//引用静态公有数据成员
	Examtotal myEx1(100),myEx2(90);			//实例化对象
	Display(myEx1);							//显示学生的考试成绩
	Display(myEx2);
	Examtotal::Message();					//显示总分数
}