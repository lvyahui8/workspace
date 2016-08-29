#include "account2.h"
#include <iostream>
using namespace std;

void main(){
	Date date(2008,11,1);					//��ʼ����
	SavingsAccount sa1(date,"S375594",0.015);
	SavingsAccount sa2(date,"R027554",0.015);
	CreditAccount ca(date,"C456465",10000,0.0005,50);
	//11�·ݵļ�����Ŀ
	sa1.Deposit(Date(2008,11,5),5000,"salary");
	ca.WithDraw(Date(2008,11,15),2000,"buy a cell");
	sa2.Deposit(Date(2008,11,25),10000,"sell stock 0323");
	//�������ÿ�
	ca.Settle(Date(2008,12,1));
	//12�·ݵļ�����Ŀ
	ca.Deposit(Date(2008,12,1),2016,"repay the credit");
	sa1.Deposit(Date(2008,12,5),5500,"salary");

	//���������˻�
	sa1.Settle(Date(2009,1,1));
	sa2.Settle(Date(2009,1,1));
	ca.Settle(Date(2009,1,1));
	cout<<endl;
	//������˻���Ϣ
	sa1.Show();cout<<endl;
	sa2.Show();cout<<endl;
	ca.Show();cout<<endl;
	cout<<"Total: "<<Account::GetTotal()<<endl;
}
