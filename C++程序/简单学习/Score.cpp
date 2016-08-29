#include "Score.h"
#include <iostream>
using std::cout;
using std::endl;
//Score类的方法实现
Score::Score(int n,int a,char s,int p,int m):Student(n,a,s),Phi(p),Math(m){}

void Score::ShowS(){
	Student::ShowS();
	cout<<"Phi="<<Phi<<'\t'<<"Math="<<Math<<endl;
}