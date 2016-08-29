#include "Student.h"
#include <iostream>
using std::cout;
using std::endl;
//Student类的方法实现
int Student::GetNo(){return No;}
int Student::GetAge(){return Age;}

Student::Student(int no,int age,char sex):No(no),Age(age),Sex(sex){}

void Student::ShowS(){
	cout<<"No="<<No<<'\t'<<"Age="<<Age<<'\t'<<"Sex="<<Sex<<endl;
}