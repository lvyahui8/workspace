//account.cpp
#include "account2.h"
#include <cmath>
#include <iostream>
using namespace std;
double Account::total = 0;
//Account类的实现
Account::Account(const Date &date,const std::string &id)
:id(id),balance(0){
	date.Show();cout<<"\t#"<<id<<"  Created"<<endl;
}

void Account::Record(const Date &date,double amount,const std::string &desc){
	amount = floor(amount*100+0.5)/100;			//保留两位小数
	balance += amount;
	total += amount;
	date.Show();
	cout<<"\t#"<<id<<'\t'<<amount<<'\t'<<balance<<'\t'<<desc<<endl;
}

void Account::Show() const{cout<<id<<"\tBalance:"<<balance;}
void Account::Error(const string &msg)const{
	cout<<"Error(#"<<id<<"):"<<msg<<endl;
}

//SavingsAccount类相关成员函数的实现
SavingsAccount::SavingsAccount(const Date &date,const string &id,double rate)
:Account(date,id),rate(rate),acc(date,0){}
void SavingsAccount::Deposit(const Date &date,double amount,const string &desc){
	Record(date,amount,desc);
	acc.Change(date,GetBalance());
}
void SavingsAccount::Withdraw(const Date &date,double amount,const std::string &desc){
	if(amount>GetBalance())
		Error("Not enough money");
	else
	{
		Record(date,-amount,desc);
		acc.Change(date,GetBalance());
	}
}
void SavingsAccount::Settle(const Date &date){
	double interest = acc.GetSum(date)*rate				//计算年息
		/date.Distance(Date(date.GetYear()-1,1,1));
	if(interest!=0) Record(date,interest,"Interest");
	acc.Reset(date,GetBalance());
}

//CreditAccount类相关成员的实现
CreditAccount::CreditAccount(const Date &date,const std::string &id,double credit,double rate,double fee)
:Account(date,id),credit(credit),rate(rate),fee(fee),acc(date,0){}

void CreditAccount::Deposit(const Date &date,double amount,const std::string &desc){
	Record(date,amount,desc);
	acc.Change(date,GetDebt());
}

void CreditAccount::WithDraw(const Date &date,double amount,const std::string &desc){
	if(amount-GetBalance()>credit){
		Error("Not enough money");
	}else{
		Record(date,-amount,desc);
		acc.Change(date,GetDebt());
	}
}

void CreditAccount::Settle(const Date &date){
	double interest = acc.GetSum(date)*rate;
	if(0 != interest) Record(date,interest,"Interest");
	if(date.GetMonth() == 1)
		Record(date,-fee,"annual fee");
	acc.Reset(date,GetDebt());
}

void CreditAccount::Show()const{
	Account::Show();
	cout<<"\tAvailable credit:"<<GetAvailableCredit();
}


