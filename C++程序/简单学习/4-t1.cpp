#include <iostream>
#include <iomanip>
using std::cout;
using std::cin;
using std::endl;
using std::setw;
class Account
{
private:
	unsigned id;						//账号
	char name[10];						//姓名
	float balance;						//余额
public:
	//构造函数
	Account(unsigned i,char * n,float bal)
	{
		id=i;
		strcpy(name,n);
		balance=bal;
	}
	//复制构造函数
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
	cout<<"帐户ID  :"<<setw(10)<<id<<endl;
	cout<<"帐户姓名:"<<setw(10)<<name<<endl;
	cout<<"帐户余额:"<<setw(10)<<balance<<endl;
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
	cout<<"创建账户"<<endl;
	Account myAccount(888888,"AgrinDJ",666666L);
	myAccount.Show_bal();

	cout<<"存款333333"<<endl;
	myAccount.Deposit(333333);	
	myAccount.Show_bal();

	cout<<"取款111111"<<endl;
	myAccount.Withdrawals(111111);
	myAccount.Show_bal();

}