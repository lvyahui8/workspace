//һ������class A{};�Ĵ�СΪʲô��1����Ϊ�������1�������������Ķ�������
//ʱ��A objects[5]; objects[0]��objects[1]����ͬһ����ַ�������޷����֡�


//���̳�
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
vs��gcc��
ִ�н����		A's size is 8
				B's size is 8
 
˵�������麯�������и�virtual table���麯�����������������������麯����
�����и�virtual table pointers��ͨ����Ϊvptrָ�����virtual table��ռ��4��
�ֽڵĴ�С����Ա��B public�̳���A����B���麯������ʵ�����������麯��A::aa()
��B::bb()����B�Ĵ�С����char k[3]�Ĵ�С����һ��ָ���麯����ָ��vptr�Ĵ�С��
�����ڴ����Ϊ8��
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
vs��gcc��
ִ�н����A's size is 8
              B's size is 8
˵������B����ȥû���麯������ʵ�������У�ֻ��û����д��
��Ϊpublic�̳У������д�A�̳й������麯��A::aa()��ʵ��
����A����B���麯������ĺ�������A::aa()��
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
vs��gcc��
ִ�н����A's size is 8
              B's size is 8
 
˵����һ�����������麯���������ж��ٸ��麯����ֻ��һ��ָ������
ָ�룬����е�ÿһ���������һ���麯������ڵ�ַ���������麯��
ʱ�����ҵ����������Ӧ�ı���ҵ���ڵ�ַ��ִ�С�����ֱ�ӵ��̳У�
������B�������麯�����������̳�����A������A�ﺬ���麯����������
��B���麯������ô������A������ͬһ��������B����������������
����ΪA::aa()��A::aa2()��B::bb()��B::bb2()��ע�⣺��A���˽�г�Ա
����B����ռ���ڴ档
*/


//��̳�

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
    virtual void aa(){} //��д��A��aa()
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
vs��gcc��
ִ�н����A's size is 8
          B's size is 4
          B's size is 12
 
˵������A��B�Ĵ�С�Ͳ������ˣ��������档��C���ؼ̳���A��B�����麯�����ǣ���
��ô��C�Ĵ�С�Ƕ��٣��ȿ���Ա��������һ���̳�A��char k[3]���ٿ��麯������C
�����麯������ô�ֲ��ģ�����һ���麯���������м̳�����A���麯����C�Լ���
�麯����C::aa(), A::aa2(), C::cc()�������Cû����дaa()����ô��һ���麯����
��A::aa()�������еڶ����麯�����Ǽ̳а�����B���麯��B::bb()��B::bb2()����C
û����дB���麯�������ܵĴ�С����2�����Ĵ�С��Ҳ�������麯��ָ��Ĵ�С��
8�ֽڼ���3�ֽڵ�k[3]�������ڴ���룬����12�ֽڡ�
*/

//��̳�

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
vs��gcc��
ִ�н����A's size is 8
              B's size is 12
˵������B��������̳е�char k[3]���̳е��麯����
��B���麯��������A::aa()����Ϊ����̳У�����һ��ָ��
�����ָ�룬��ָ��Ϊָ��������ָ�루Pointer to vir
tual base class���������ڴ���룬�ܴ�СΪ12��
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
VSִ�н����A's size is 8
                  B's size is 16
 
gccִ�н����A's size is 8
                  B's size is 12
 
˵����������̳У���B��̳���Aʱ������Ҫͨ������һ��ָ����ָ����A����
ָ�뱻��Ϊ�����ָ�롣Ȼ������Ӹ���̳й�����3��char���ټ���һ���麯��
ָ�롣�����ڴ���룬��gcc�½����4+4+4=12����VS�£������16��why����һ��
����һ������ֻ������B�������һ���麯��������������Ŀ����B�����麯����
��VS�µ��Բ鿴�����룬���ֶ������4�ֽ�ʲôҲû�С�
 
����C++�麯�������Կ���C++�麯�����������http://blog.csdn.net/haoel/article/details/1948051

*/