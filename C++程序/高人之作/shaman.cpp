#include<iostream.h>
class studentInfo
{
	int math;
	int english;
	int grade;
public:
	studentInfo();//int math,int english , int grade
	friend void show(studentInfo s);
	
};

studentInfo::studentInfo():math(95),english(95),grade(5){
}
void show(studentInfo s)
{
	cout<<"math="<<s.math<<endl;
	cout<<"english="<<s.english<<endl;
	cout<<"grade="<<s.grade<<endl;
}
int main()
{
	studentInfo s;
	show(s);
	return 0;
}