#include <iostream>
#include <string>
using std::cout;
using std::endl;
using std::string;
//Student 类
class Student{
private:
	string str;		//姓名
	float score;	//成绩
public:
	Student(const string &str,const float score);
	friend void CompareScore(const Student &stu1,const Student &stu2);	//比较成绩
};
//Student类的实现
Student::Student(const string &str,const float score)
	:str(str),score(score){}
//Student类的友元函数：比较函数
void CompareScore(const Student &stu1,const Student &stu2){
	stu1.score >= stu2.score 
		? cout<<stu1.str<<' '<<stu1.score<<endl : cout<<stu2.str<<' '<<stu2.score<<endl;
}

int main(int argc, char *argv[])
{
	Student stu1("AgrinDJ",100),stu2("AgrinLV",80);
	CompareScore(stu1,stu2);
	return 0;
}
