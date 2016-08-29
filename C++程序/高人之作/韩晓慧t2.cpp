#include<iostream>
using namespace std;
class Student
{
private:
	int score;
	char name;	
public:
	void set(char n,int s);
	void show();
	friend int compare(Student &s1,Student &s2);
};

int compare(Student &s1,Student &s2)
{
	int x=(s1.score-s2.score);

	if(x>0)
		s1.show();
	else
		s2.show();
	return 0;
}
void Student::set(char n,int s){
	name=n;
	score=s;
}
inline void Student::show(){
	cout<<"姓名"<<name<<" 成绩"<<score;
}
int main(){
	Student s1;
	Student s2;
	s1.set('h',98);
	s2.set('w',94);
	cout<<"s1和s2中成绩比较高的一人为："<<endl;
	compare(s1,s2);
	return 0;
}

