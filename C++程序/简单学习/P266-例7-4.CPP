#include <iostream>

using std::cout;
using std::endl;

class Base1{
public:
	Base1(int i){cout<<"Constructing Base1 "<<i<<endl;}
	~Base1(){cout<<"Destrucing Base1"<<endl;}
};

class Base2{
public:
	Base2(int j){cout<<"Constructing Base2 "<<j<<endl;}
	~Base2(){cout<<"Destrucing Base2"<<endl;}
};

class Base3{
public:
	Base3(){cout<<"Constructing Base3 *"<<endl;}
	~Base3(){cout<<"Destrucing Base3"<<endl;}
};

class Derived : public Base2,public Base1,public Base3{
	//派生新类 Derived 注意父类的顺序
private:
	Base1 member1;
	Base2 member2;
	Base3 member3;
public:
	Derived(int a,int b,int c,int d):Base1(a),member2(d),member1(c),Base2(b){}
	//注意父类名的个数与顺序，注意成员对象名的个数与顺序
};

void main(){
	Derived obj(1,2,3,4);
}
//__________________________________________________
/*
运行结果：
Constructing Base2 2
Constructing Base1 1
Constructing Base3 *
Constructing Base1 3
Constructing Base2 4
Constructing Base3 *
Destrucing Base3
Destrucing Base2
Destrucing Base1
Destrucing Base3
Destrucing Base1
Destrucing Base2
Press any key to continue
原因分析：
初始化列表其实省略了一个父类和一个成员，这是因为Base3的构造函数不需要传递参数，因此不必列出
接下来
第一步：先构造父类，先调用父类的构造函数，依照继承顺序 Base2,Base1,Base3
第二步：调用内嵌对象的构造函数，依照内嵌对象的定义顺序 Base1,Base2,Base3
第三步：先析构子类，析构顺序与内嵌对象定义的顺序相反
第四步：然后析构父类，析构顺序与继承顺序相反
*/
//__________________________________________________