/*����people����Ա���࣬���е��������£�����char name[11]�����char number[7]���Ա�char sex[3]������birthday�����֤��char id[16]��
���С����ա�����Ϊһ�������ڡ�����Ƕ�����ó�Ա����ʵ�ֶ���Ա��Ϣ��¼�����ʾ��
Ҫ����������캯�����������������ƹ��캯����������Ա�������ۼ����ڲ��Գ����ж���people��Ķ������飬¼�����ݲ���ʾ��*/
#include<iostream>
#include<string>
using namespace std;

class Date//������
{
private:
	float mouth;
	float day;
public:
	Date(float m=0,float d=0):mouth(m),day(d){
		cout<<"Date���캯��"<<endl;
	}//���캯��
	Date(Date &d){
		cout<<"���ƹ��캯��Date"<<endl;
		this->mouth = d.mouth;
		this->day = d.day;
	}
	float Getmouth(){return mouth;}//��Ҫ����ʾ����
	float Getday(){return day;}//��ʽ��������
	~Date(){cout<<"������Date"<<endl;}
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
		cout<<"People�޲ι��캯��"<<endl;
	}
	People(string n1,string n2,string s,string i,Date b):name(n1),number(n2),sex(s),id(i),birthday(b){
		cout<<"People���ι��캯��"<<endl;
	}
	People(People &p){
		cout<<"���ƹ��캯��People"<<endl;
		this->birthday = p.birthday;
		this->id = p.id;
		this->name = p.name;
		this->number = p.number;
		this->sex = p.sex;
	}
	void display()//��ʾ����
	{
		cout<<name<<endl;
		cout<<number<<endl;
		cout<<sex<<endl;
		cout<<id<<endl;
		cout<<birthday.Getmouth()<<birthday.Getday()<<endl;
	}
	~People(){{cout<<"������People"<<endl;}}
};
void main()
{
// 	Date d[2]={Date(1,21),Date(10,14)};//��ʼ����������������Ҫ�÷ֺ�����β
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