// #############################################
//	C++语言程序设计（第四版）
//	P137 例-4-10
// #############################################

#include <iostream>
#include <bitset>
using std::cout;
using std::endl;
using std::cin;
using std::bitset;

enum Level {FRESHMAN,SOPHOMORE,JUNIOR,SENIOR};	//0 1 2 3
enum Grade {A,B,C,D};							//0 1 2 3

class Student
{
private:
	unsigned number : 27;
	Level level : 2;
	Grade grade : 2;
public:
	Student(unsigned number,Level level,Grade grade)
		: number(number),level(level),grade(grade) {}
	void show();
};

void Student::show()
{
	cout<<"Number :    "<<number<<endl;
	cout<<"Level  :    ";
	switch(level)
	{
	case FRESHMAN : cout<<"freshman.";break;
	case SOPHOMORE: cout<<"sophomore.";break;
	case JUNIOR   : cout<<"junior.";break;
	case SENIOR   : cout<<"senior.";break;
	default :break;
	}
	cout<<endl;

	cout<<"Grade  :    ";
	switch(grade)
	{
	case A : cout<<'A';break;
	case B : cout<<'B';break;
	case C : cout<<'C';break;
	case D : cout<<'D';break;
	default :break;
	}
	cout<<endl;
	cout<<bitset<27>(number)<<endl;
	cout<<bitset<2>(level)<<endl;
	cout<<bitset<2>(grade)<<endl;
}

void main()
{
	Student s(12345678,SOPHOMORE,A);
	cout<<"Size of Student : "<<sizeof(Student)<<endl;
	s.show();
}