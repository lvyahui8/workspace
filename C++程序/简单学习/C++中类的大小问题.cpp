//一个空类class A{};的大小为什么是1，因为如果不是1，当定义这个类的对象数组
//时候A objects[5]; objects[0]和objects[1]就在同一个地址处，就无法区分。


//单继承
#include<iostream>
using namespace std;
class A
{
public:
    virtual void aa(){}
private:
    char k[3];
};

class B: public A
{
public:
    virtual void bb(){}
};

int main()
{
    cout<<"A's size is "<<sizeof(A)<<endl;
    cout<<"B's size is "<<sizeof(B)<<endl;
    return 0;
}

/*
vs和gcc下
执行结果：		A's size is 8
				B's size is 8
 
说明：有虚函数的类有个virtual table（虚函数表），里面包含了类的所有虚函数，
类中有个virtual table pointers，通常成为vptr指向这个virtual table，占用4个
字节的大小。成员类B public继承于A，类B的虚函数表里实际上有两个虚函数A::aa()
和B::bb()，类B的大小等于char k[3]的大小加上一个指向虚函数表指针vptr的大小，
考虑内存对齐为8。
*/


#include<iostream>
using namespace std;
class A
{
public:
    virtual void aa(){}
private:
    char k[3];
};

class B: public A
{
public:
    //virtual void bb(){}
};

int main()
{
    cout<<"A's size is "<<sizeof(A)<<endl;
    cout<<"B's size is "<<sizeof(B)<<endl;
    return 0;
}
/*
vs和gcc下
执行结果：A's size is 8
              B's size is 8
说明：类B看上去没有虚函数，但实际上它有，只是没有重写，
因为public继承，所以有从A继承过来的虚函数A::aa()，实际
上类A和类B的虚函数表里的函数都是A::aa()。
*/

#include<iostream>
using namespace std;
class A
{
public:
    virtual void aa(){}
    virtual void aa2(){}
private:
    char k[3];
};

class B: public A
{
public:
    virtual void bb(){}
    virtual void bb2(){}
};

int main()
{
    cout<<"A's size is "<<sizeof(A)<<endl;
    cout<<"B's size is "<<sizeof(B)<<endl;
    return 0;
}

/*
vs和gcc下
执行结果：A's size is 8
              B's size is 8
 
说明：一个类里若有虚函数，无论有多少个虚函数都只有一个指向虚表的
指针，虚表中的每一个表项保存着一个虚函数的入口地址。当调用虚函数
时，先找到虚表中它对应的表项，找到入口地址再执行。对于直接单继承，
无论类B中有无虚函数，由于它继承了类A，且类A里含有虚函数，因此如果
类B有虚函数，那么它和类A的是在同一个属于类B的虚表里，这张虚表的虚
函数为A::aa()、A::aa2()、B::bb()、B::bb2()。注意：类A里的私有成员
在类B里仍占有内存。
*/


//多继承

#include<iostream>
using namespace std;
class A
{
public:
    virtual void aa(){}
    virtual void aa2(){}
private:
    char k[3];
};

class B
{
public:
    virtual void bb(){}
    virtual void bb2(){}
};

class C: public A,public B
{
public:
    virtual void aa(){} //重写了A的aa()
    virtual void cc(){}
};

int main()
{
    cout<<"A's size is "<<sizeof(A)<<endl;
    cout<<"B's size is "<<sizeof(B)<<endl;
    cout<<"C's size is "<<sizeof(C)<<endl;
    return 0;
}
/*
vs和gcc下
执行结果：A's size is 8
          B's size is 4
          B's size is 12
 
说明：类A和B的大小就不解释了，参照上面。类C多重继承于A和B（有虚函数覆盖），
那么类C的大小是多少？先看成员变量，有一个继承A的char k[3]。再看虚函数，类C
的中虚函数是怎么分布的？先有一个虚函数表，里面有继承于类A的虚函数和C自己的
虚函数（C::aa(), A::aa2(), C::cc()），如果C没有重写aa()，那么第一个虚函数就
是A::aa()，接着有第二张虚函数表是继承包含类B的虚函数B::bb()、B::bb2()（类C
没有重写B的虚函数）。总的大小就是2张虚表的大小（也即两个虚函数指针的大小）
8字节加上3字节的k[3]，考虑内存对齐，就是12字节。
*/

//虚继承

#include<iostream>
using namespace std;
class A
{
public:
    virtual void aa(){}
private:
    char k[3];
};

class B: virtual public A
{
public:
    //virtual void bb(){}
};

int main()
{
    cout<<"A's size is "<<sizeof(A)<<endl;
    cout<<"B's size is "<<sizeof(B)<<endl;
    return 0;
}
/*
vs和gcc下
执行结果：A's size is 8
              B's size is 12
说明：类B里包含，继承的char k[3]，继承的虚函数，
类B的虚函数表里有A::aa()，因为是虚继承，还有一个指向
父类的指针，该指针为指向虚基类的指针（Pointer to vir
tual base class）。考虑内存对齐，总大小为12。
*/
#include<iostream>
using namespace std;
class A
{
public:
    virtual void aa(){}
private:
    char k[3];
};

class B: public virtual A
{
public:
    virtual void bb(){}
};

int main()
{
    cout<<"A's size is "<<sizeof(A)<<endl;
    cout<<"B's size is "<<sizeof(B)<<endl;
    return 0;
}

/*
VS执行结果：A's size is 8
                  B's size is 16
 
gcc执行结果：A's size is 8
                  B's size is 12
 
说明：对于虚继承，类B虚继承类A时，首先要通过加入一个指针来指向父类A，该
指针被称为虚基类指针。然后包含从父类继承过来的3个char，再加上一个虚函数
指针。考虑内存对齐，在gcc下结果是4+4+4=12。在VS下，结果是16，why？这一题
和上一题区别只是在类B中添加了一个虚函数，但是两个题目中类B都有虚函数表。
在VS下调试查看汇编代码，发现多出来的4字节什么也没有。
 
关于C++虚函数，可以看《C++虚函数表解析》：http://blog.csdn.net/haoel/article/details/1948051

*/