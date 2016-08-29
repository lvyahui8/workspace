/*定义people（人员）类，具有的属性如下：姓名char name[11]、编号char number[7]、性别char sex[3]、生日birthday、身份证号char id[16]。
其中“生日”定义为一个“日期”类内嵌对象。用成员函数实现对人员信息的录入和显示。
要求包括：构造函数和析构函数、复制构造函数、内联成员函数、聚集。在测试程序中定义people类的对象数组，录入数据并显示。*/
#include<iostream>
#include<string>
using namespace std;

class Date//日期类
{
private:
	float mouth;
	float day;
public:
	Date(float m=0,float d=0):mouth(m),day(d){
		cout<<"Date构造函数"<<endl;
	}//构造函数
	Date(Date &d){
		cout<<"复制构造函数Date"<<endl;
		this->mouth = d.mouth;
		this->day = d.day;
	}
	float Getmouth(){return mouth;}//必要的显示函数
	float Getday(){return day;}//隐式内联函数
	~Date(){cout<<"析构了Date"<<endl;}
};

class People
{
private:
	string name;
	string number;
	string sex;
	string id;
	Date birthday;
public:
	People(){
		cout<<"People无参构造函数"<<endl;
	}
	People(string n1,string n2,string s,string i,Date b):name(n1),number(n2),sex(s),id(i),birthday(b){
		cout<<"People带参构造函数"<<endl;
	}
	People(People &p){
		cout<<"复制构造函数People"<<endl;
		this->birthday = p.birthday;
		this->id = p.id;
		this->name = p.name;
		this->number = p.number;
		this->sex = p.sex;
	}
	void display()//显示函数
	{
		cout<<name<<endl;
		cout<<number<<endl;
		cout<<sex<<endl;
		cout<<id<<endl;
		cout<<birthday.Getmouth()<<birthday.Getday()<<endl;
	}
	~People(){{cout<<"析构了People"<<endl;}}
};
void main()
{
// 	Date d[2]={Date(1,21),Date(10,14)};//初始化对象数组的语句需要用分号做结尾
	People p[2]={People("boy","11","lan","410000",Date(1,21)),People("gril","12","nv","410000",Date(10,14))};
	for(int i=0;i<2;i++)
	{
		p[i].display();
	}
}

//
//#include <iostream>
//#include <stdio.h>
//#include <string>
//#include<fstream>
//#include <conio.h>
//using namespace std;
//class Car{
//	int num;
//public:
//	Car(int num)/*:num(num)*/{
//		this->num = num;
//		// this->num = num;
//	}
//	void ShowNum()const{
//		cout<<num<<endl;
//	}
//	void CarPerShow(){
//
//		class Person
//		{
//		public:
//			void show(){
//				cout<<"Car.Person.show()"<<endl;
//			}
//		};
//		Person p;
//		p.show();
//	}
//};
//void main() 
//{ 
//	/*
//	int i;
//	ifstream infTemp("7.dat");
//	cout<<infTemp<<endl;
//	infTemp>>i;
//	cout<<infTemp<<endl;
//	infTemp>>i;
//	i = 5;
//	cout<<infTemp<<endl;
//	*/
//	Car myCar(5);
//	myCar.ShowNum();
//	myCar.CarPerShow();
// }