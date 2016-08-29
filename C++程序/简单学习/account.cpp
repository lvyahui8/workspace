//account.cpp
#include "account.h"
#include <cmath>
#include <iostream>

using std::cout;
using std::endl;


double SavingsAccount::total = 0;
//SavingsAccount类相关函数成员的实现
SavingsAccount::SavingsAccount(int date,int m_id,double m_rate)
	:id(m_id),rate(m_rate),lastDate(date),balance(0),accumulation(0){
	cout<<date<<"\t#"<<id<<" \t新建成功"<<endl;
}

void SavingsAccount::record(int date,double amount){
	accumulation = accumulate(date);
	lastDate = date;
	amount = floor(amount * 100 + 0.5)/100;			//保留小数点后2位
	balance += amount;
	total += amount;
	cout<<date<<"\t#"<<id<<"\t"<<amount<<"\t"<<balance<<endl;
}

void SavingsAccount::deposit(int date,double amount){
	record(date,amount);
}

void SavingsAccount::withdraw(int date,double amount){
	if(amount > getBalance())
		cout<<"错误: 钱不够啦"<<endl;
	else
		record(date,-amount);
}
void SavingsAccount::settle(int date){
	double interest = accumulate(date) * rate / 365;	//计算年息
	if(interest != 0)
		record(date,interest);
	accumulation = 0;
}

void SavingsAccount::show() const{
	cout<<"#"<<id<<"\t余额:"<<balance<<endl;
}
