
#ifndef __SCORE__H
#define __SCORE__H
#include "Student.h"
class Score:public Student{
private:
	int Phi,Math;			//������Score��˽�����ݳ�Ա
public:
	Score(int n,int a,char s,int p,int m);//��Score�Ĺ��캯��
	virtual void ShowS();
};
#endif//__SCORE__H