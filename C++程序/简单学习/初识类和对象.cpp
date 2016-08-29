#include <iostream>
using std::cout;
using std::endl;
using std::cin;
//类，封装了该类的相同属性集合、相同行为集合。对象，是指具有属性和行为的该类成员

class Student
{
private:					//私有成员
	int num;
	char name[10];
	char sex;
public:						//公有成员
	void Display1(int n=0,char * m=NULL,char s='O')			//这个成员函数是直接定义在类定义之内的
	{														//所以它隐式声明Display1为内联函数
		num=n;
		strcpy(name,m);
		sex=s;
		cout<<"Num:"<<num<<endl;
		cout<<"Name:"<<name<<endl;
		cout<<"Sex:"<<sex<<endl;
	}
	void Enter();		//成员函数 的原型声明。这里将它的定义放在了类定义之外
	void Display2()
	{
		cout<<"Num:"<<num<<endl;
		cout<<"Name:"<<name<<endl;
		cout<<"Sex:"<<sex<<endl;
	}
	//内联成员函数以及成员函数重载
	void ShowMe(char c);
	void ShowMe(int n,char * m,char s);

};

void Student::Enter()		//::是作用域解析运算符，限定其后的成员函数的作用域仅为::符号前面所给出的类
{
	cin>>num>>name>>sex;
}

inline void Student::ShowMe(char c)		//显式声明ShowMe为内联函数
{
	cout<<num<<'\t'<<name<<'\t'<<sex<<c<<endl;
}

inline void Student::ShowMe(int n=0,char * m=NULL,char s='O')
{
	num=n;
	strcpy(name,m);
	sex=s;
	cout<<num<<'\t'<<name<<'\t'<<sex<<endl;
}

void main()
{
	Student stu1,stu2;		//对 Student 类定义了两个对象
	//类中的公有数据成员，其用法与结构体变量类似，可以在创建对象时进行初始化。对于私有成员和保护成员，不能再创建时初始化，
	//更不能在定义类的过程中对数据成员进行初始化。C++规定只有在类对象定义之后才能给数据成员赋初值。
	
	stu1.Display1(201201,"dengjie",'G');
	stu2.Display1(201202,"lvyahui",'B');
//	stu1.Enter();
//	stu2.Enter();
	stu1.Display2();
	stu2.Display2();
	stu1.ShowMe('y');
	stu1.ShowMe(11010,"Dengjie",'G');
}