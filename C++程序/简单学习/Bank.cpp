#include <iostream>
#include "account.h"

using std::cout;
using std::endl;

void main(){
	//���������˻�
	cout<<"����\t�˺�\t����\t���"<<endl;
	SavingsAccount sa0(1,12060801,0.015);
	SavingsAccount sa1(2,12060802,0.016);
	//������Ŀ
	sa0.deposit(5,5000);
	sa1.deposit(35,10000);
	sa1.withdraw(70,4000);
	sa0.deposit(45,4000);
	//�������90�쵽�����еļ�Ϣ�գ����������˻�����Ϣ
	cout<<"������Ϣ:"<<endl;
	sa0.settle(90);
	sa1.settle(90);
	//������˻���Ϣ
	cout<<"��ʾ���:"<<endl;
	sa0.show();
	sa1.show();
	cout<<"�����˻����: "<<SavingsAccount::getTotal()<<endl;
}