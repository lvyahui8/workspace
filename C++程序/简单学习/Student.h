#ifndef __STUDENT__H
#define __STUDENT__H
class Student{
private:
	int No;					//定义No为私有数据成员
protected:
	int Age;				//定义Age为保护数据成员
public:
	char Sex;				//定义Sex为公有数据成员
	Student(int no,int age,char sex);
	int GetNo();
	int GetAge();
	void ShowS();			//显示数据成员
};
#endif//__STUDENT__H