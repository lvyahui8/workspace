#include <iostream>
#include "account.h"

using std::cout;
using std::endl;

void main(){
	//建立几个账户
	cout<<"日期\t账号\t操作\t余额"<<endl;
	SavingsAccount sa0(1,12060801,0.015);
	SavingsAccount sa1(2,12060802,0.016);
	//几笔账目
	sa0.deposit(5,5000);
	sa1.deposit(35,10000);
	sa1.withdraw(70,4000);
	sa0.deposit(45,4000);
	//开户后第90天到了银行的计息日，结算所有账户的年息
	cout<<"计算年息:"<<endl;
	sa0.settle(90);
	sa1.settle(90);
	//输出各账户信息
	cout<<"显示余额:"<<endl;
	sa0.show();
	sa1.show();
	cout<<"所有账户余额: "<<SavingsAccount::getTotal()<<endl;
}