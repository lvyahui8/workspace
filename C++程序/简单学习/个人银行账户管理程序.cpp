#include <iostream>
#include <cmath>
using std::cout;
using std::endl;
using std::cin;

class  SavingsAccount								//	储蓄账户类
{
private:
	int id,lastDate;								//	账号，上次变更余额的时间
	double balance,rate,accumulation;				//	余额，存款的年利率，余额按日累加之和
	void record(int date,double amount);			//	记录一笔账，date为日期，amount为金额，desc为说明
	double accumulate(int date)						//	获得指定日期为止的存款金额按日累积值
	{
		return accumulation + balance*(date-lastDate);
	}
public:
	SavingsAccount(int date,int id,double rate);		//	构造函数
	int getld() {return id;};
	double getBalance() {return balance;}
	double getRate()	{return rate;}
	void show();									//	显示账户信息
	void deposit(int date,double amount);			//	存入现金
	void withdraw(int date,double amount);			//	取出现金	
	void settle(int date);							//	结算利息，每年1月1日调用一次该函数
};
//	SavingAccount类相关成员函数的实现
SavingsAccount::SavingsAccount(int date,int id,double rate)
:  id(id),balance(0),rate(rate),lastDate(date),accumulation(0)
{
	cout<<date<<"\t#"<<id<<"is created."<<endl;
}

void SavingsAccount::record(int date,double amount)
{
	accumulation=accumulate(date);
	lastDate=date;
	amount=floor(amount*100 + 0.5)/100;				//保留小数点后两位
	balance += amount;
	cout<<date<<"\t#"<<id<<"\t"<<amount<<"\t"<<balance<<endl;
}

void SavingsAccount::deposit(int date,double amount)
{
	record(date,amount);
}

void SavingsAccount::withdraw(int date,double amount)
{
	if( amount > getBalance() )
		cout<<"Error: not enough money."<<endl;
	else
		record(date,-amount);
}

void SavingsAccount::settle(int date)
{
	double interest = accumulate(date)*rate / 365;	//计算年息
	if(interest!=0)
		record(date,interest);
	accumulation=0;
}

void SavingsAccount::show()
{
	cout<<"#"<<id<<"\tBalance:"<<balance<<endl;
}

void main()
{
	//	建立几个账户
	SavingsAccount sa0(1,21325302,0.015);
	SavingsAccount sa1(1,58320201,0.015);

	//	几笔账目
	sa0.deposit(5,5000);
	sa1.deposit(25,10000);
	sa0.deposit(45,5500);
	sa1.withdraw(60,4000);

	//	开户后第 90 天到了银行的计息日，结算所有账户的年息
	sa0.settle(90);
	sa1.settle(90);

	//输出各账户信息
	sa0.show();
	sa1.show();
}