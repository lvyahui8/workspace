/*������������������������������������������������������������������������
��	֮ǰ���ڶ�̳��У����ֻ�ȫ��ֱ�ӻ����ּ̳���ͬһ����ʱ������ɼ̳ж���	
��	��ͬ����Ա���أ����Ҫ���������ĳ�Ա����Ҫʹ��������ֱ����Ψһ��ʶ��
��	�����ǡ�Ϊ���ܹ�ֱ��ʹ�������������������ĳ�Ա�����Խ�ֱ�ӻ���Ĺ�ͬ
��	��������Ϊ����ࡣ
��������������������������������������������������������������������������*/
#include <iostream>
using std::cout;
using std::endl;

class Base0{								//������� Base0
public:
	int var0;
	void fun(){cout<<"Member of Base0"<<endl;}
};

class Base1:virtual public Base0{			//����������Base1
public:										//�����ⲿ�ӿ�
	int var1;
};
class Base2:virtual public Base0{			//����������Base2
public:										//�����ⲿ�ӿ�
	int var2;
};

class Derived:public Base1,public Base2{	//����������Derived
public:										//�����ⲿ�ӿ�
	int var;
	void fun(){cout<<"Member of Derived"<<endl;}
};

void main(){
	Derived myD;
	myD.var0 = 2;							//ֱ�ӷ������������ݳ�Ա
	myD.fun();								//ֱ�ӷ��������ĺ�����Ա
}
