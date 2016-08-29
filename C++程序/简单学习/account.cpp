//account.cpp
#include "account.h"
#include <cmath>
#include <iostream>

using std::cout;
using std::endl;


double SavingsAccount::total = 0;
//SavingsAccount����غ�����Ա��ʵ��
SavingsAccount::SavingsAccount(int date,int m_id,double m_rate)
	:id(m_id),rate(m_rate),lastDate(date),balance(0),accumulation(0){
	cout<<date<<"\t#"<<id<<" \t�½��ɹ�"<<endl;
}

void SavingsAccount::record(int date,double amount){
	accumulation = accumulate(date);
	lastDate = date;
	amount = floor(amount * 100 + 0.5)/100;			//����С�����2λ
	balance += amount;
	total += amount;
	cout<<date<<"\t#"<<id<<"\t"<<amount<<"\t"<<balance<<endl;
}

void SavingsAccount::deposit(int date,double amount){
	record(date,amount);
}

void SavingsAccount::withdraw(int date,double amount){
	if(amount > getBalance())
		cout<<"����: Ǯ������"<<endl;
	else
		record(date,-amount);
}
void SavingsAccount::settle(int date){
	double interest = accumulate(date) * rate / 365;	//������Ϣ
	if(interest != 0)
		record(date,interest);
	accumulation = 0;
}

void SavingsAccount::show() const{
	cout<<"#"<<id<<"\t���:"<<balance<<endl;
}
