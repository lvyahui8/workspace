
#include <iostream>

using std::cout;
using std::endl;


class A{
private:
	const int a;
	static const int b;		//��̬�����ݳ�Ա
public:
	A(int i);
	void Print();
};

const int A::b = 1;		//��̬���ݳ�Ա������˵���ͳ�ʼ��

//�����ݳ�Աֻ��ͨ����ʼ���б�����ó�ֵ
A::A(int i): a(i) {}

void A::Print(){
	cout<<a<<':'<<b<<endl;
}

void main()
{
/***********************************************************
*	��������a1��a2������100��0��Ϊ��ֵ���ֱ���ù��캯����ͨ��
*	���캯���ĳ�ʼ���б������ĳ����ݳ�Ա����ֵ
***********************************************************/
	A a1(100),a2(0);
	a1.Print();
	a2.Print();
}

