
#ifndef __SCORE__H
#define __SCORE__H
#include "Student.h"
class Score:public Student{
private:
	int Phi,Math;			//定义类Score的私有数据成员
public:
	Score(int n,int a,char s,int p,int m);//类Score的构造函数
	virtual void ShowS();
};
#endif//__SCORE__H