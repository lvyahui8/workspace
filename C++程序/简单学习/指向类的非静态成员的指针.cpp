/*
�X�T�T�T�T�T�T�T�T�T�T�T�T�T�T�T�T�T�T�T�T�T�T�T�T�T�T�T�T�T�T�T�T�T�T�T�[
�U	1��ָ��Ǿ�̬��Ա��ָ��
�U	����ָ���һ����ʽ��
�U	����˵���� ����::*ָ����				//����ָ�����ݳ�Ա��ָ��
�U	����˵���� (����::*ָ����)(�β��б�)	//����ָ������Ա��ָ��
�U	��ָ�븳ֵ��һ����ʽ
�U	����ָ��	ָ����=&����::���ݳ�Ա
�U	����ָ��	ָ����=&����::������Ա��
�U	ָ���һ��ʹ�÷���
�U	����ָ��	������.*���Աָ���� ��  ������->*���Աָ����
�U	����ָ��	(������.*���Աָ����)(������) ��
�U				(����ָ����->*���Աָ����)(������)
�U	2��ָ��̬��Ա��ָ��
�U	�Ծ�̬��Ա�ķ����ǲ������Ķ���ģ���˿�������ָͨ��������
�^�T�T�T�T�T�T�T�T�T�T�T�T�T�T�T�T�T�T�T�T�T�T�T�T�T�T�T�T�T�T�T�T�T�T�T�a*/

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
//	int Base1::*countP;								//����countPΪָ��Base1�๫�г�Աcount��ָ��
//	countP=&Base1::count;
//	cout<<girl.*countP<<endl;
//	�Ǿ�̬���ݳ�Ա
	int Base1::*countP = &/*ȡ��ַ�������*/Base1::count;		
	cout<<girl.*countP<<endl;
//	��̬���ݳ�Ա��������ͨ����һ������
	int *sta_p = &Base1::sta_menber;
	cout<<*sta_p<<endl;
//	�Ǿ�̬������Ա
	void (Base1::*funP)() = &/*ȡ��ַ��ҪҲ�ɲ�ҪҲ��*/Base1::ShowName;		//����funPΪָ���๫�� ������Ա ��ָ���������ʼ�� 
	(girl.*funP)();									//ʹ��ָ����ö���ĺ�����Ա
//	int (Base1::*fun)(int);							//����funΪָ���๫�� ������Ա ��ָ�����
//	fun = &Base1::GetNameLength;					//��fun ��ʼ��
//	cout<<(girl.*fun)(8);							//ʹ��ָ����ö���ĺ�����Ա
//	��̬������Ա��������ͨ����һ������
	void (*func)() = &/*ȡ��ַ��ҪҲ�ɲ�ҪҲ��*/Base1::fun;	//	��̬��Ա���巽����ͬ
	(*func)();
	func();
}