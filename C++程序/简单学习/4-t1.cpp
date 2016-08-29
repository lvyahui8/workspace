#include <iostream>
#include <iomanip>
using std::cout;
using std::cin;
using std::endl;
using std::setw;
class Account
{
private:
	unsigned id;						//�˺�
	char name[10];						//����
	float balance;						//���
public:
	//���캯��
	Account(unsigned i,char * n,float bal)
	{
		id=i;
		strcpy(name,n);
		balance=bal;
	}
	//���ƹ��캯��
	Account(Account &p)
	{
		id=p.id;
		strcpy(name,p.name);
		balance=p.balance;
	}
	void Deposit(int num=0);
	void Withdrawals(int num=0);
	void Show_bal();
};

inline void Account::Show_bal()
{
	cout<<"�ʻ�ID  :"<<setw(10)<<id<<endl;
	cout<<"�ʻ�����:"<<setw(10)<<name<<endl;
	cout<<"�ʻ����:"<<setw(10)<<balance<<endl;
}

void Account::Deposit(int num)
{
	balance += num;
}

void Account::Withdrawals(int num)
{
	balance -= num;
}
void main()
{
	cout<<"�����˻�"<<endl;
	Account myAccount(888888,"AgrinDJ",666666L);
	myAccount.Show_bal();

	cout<<"���333333"<<endl;
	myAccount.Deposit(333333);	
	myAccount.Show_bal();

	cout<<"ȡ��111111"<<endl;
	myAccount.Withdrawals(111111);
	myAccount.Show_bal();

}