/*
╔═══════════════════════════════════╗
║	1、指向非静态成员的指针
║	声明指针的一般形式：
║	类型说明符 类名::*指针名				//声明指向数据成员的指针
║	类型说明符 (类名::*指针名)(形参列表)	//声明指向函数成员的指针
║	对指针赋值的一般形式
║	数据指针	指针名=&类名::数据成员
║	函数指针	指针名=&类名::函数成员名
║	指针的一般使用方法
║	数据指针	对象名.*类成员指针名 或  对象名->*类成员指针名
║	函数指针	(对象名.*类成员指针名)(参数表) 或
║				(对象指针名->*类成员指针名)(参数表)
║	2、指向静态成员的指针
║	对静态成员的访问是不依赖的对象的，因此可以用普通指针来处理
╚═══════════════════════════════════╝*/

#include <iostream>
using std::cout;
using std::endl;

class Base1{
private:
	char name[10];
public:
	Base1(char * str,int count):count(count){strcpy(name,str);}
	char * GetName(){return name;}
	void ShowName(){
// 		cout<<name<<endl;
		cout<<"no static fun"<<endl;
	}
	int GetNameLength(int x){
		// cout<<x<<"#"<<strlen(name)<<endl;
		cout<<"no static fun"<<endl;
		return x;
	}
	static void fun(){
		cout<<"static fun"<<endl;
	}
	int count;
	static int sta_menber;
};

int Base1::sta_menber = 0;

void main(){
	Base1 girl("Agrin",56);
//	char * name = girl.GetName();
//	cout<<name<<endl;
//
//	int Base1::*countP;								//定义countP为指向Base1类公有成员count的指针
//	countP=&Base1::count;
//	cout<<girl.*countP<<endl;
//	非静态数据成员
	int Base1::*countP = &/*取地址符必须的*/Base1::count;		
	cout<<girl.*countP<<endl;
//	静态数据成员。就像普通变量一样处理
	int *sta_p = &Base1::sta_menber;
	cout<<*sta_p<<endl;
//	非静态函数成员
	void (Base1::*funP)() = &/*取地址符要也可不要也可*/Base1::ShowName;		//定义funP为指向类公有 函数成员 的指针变量并初始化 
	(girl.*funP)();									//使用指针调用对象的函数成员
//	int (Base1::*fun)(int);							//定义fun为指向类公有 函数成员 的指针变量
//	fun = &Base1::GetNameLength;					//对fun 初始化
//	cout<<(girl.*fun)(8);							//使用指针调用对象的函数成员
//	静态函数成员。就以普通函数一样处理
	void (*func)() = &/*取地址符要也可不要也可*/Base1::fun;	//	静态成员定义方法不同
	(*func)();
	func();
}