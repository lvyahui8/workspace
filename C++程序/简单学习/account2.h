#ifndef __ACCOUNT__H
#define __ACCOUNT__H
#include "date.h"
#include "accumulator.h"
#include <string>
class Account{
private:
	std::string id;			//账号
	double balance;
	static double total;
protected:
	//供派生类调用的构造函数，id为账号
	Account(const Date &date,const std::string & id);
	//记录一笔账，date为日期，amount为余额，desc为说明
	void Record(const Date &date,double amount,const std::string &desc);
	//报告错误信息
	void Error(const std::string &msg) const;
public:
	const std::string & GetId() const {return id;}
	double GetBalance() const{return balance;}
	static double GetTotal(){return total;}
	//显示账户信息
	void Show()const;
};

class SavingsAccount:public Account{				//储蓄账户类
private:
	Accumulator acc;							//辅助计算利息的累加器
	double rate;								//存款的年利率
public:
	//构造函数
	SavingsAccount(const Date &date,const std::string &id,double rate);
	double GrtRate()const{return rate;}
	//存入现金
	void Deposit(const Date &date,double amount,const std::string &desc);
	//取出现金
	void Withdraw(const Date &date,double amount,const std::string &desc);
	void Settle(const Date &date);				//结算利息，每年1月1日调用一次该函数
};

class CreditAccount:public Account{				//信用账户类
private:
	Accumulator acc;
	double credit;								//信用额度
	double rate;								//欠款的日利息
	double fee;									//信用卡年费
	double GetDebt() const{						//获得欠款额
		double balance = GetBalance();
		return (balance<0 ? balance : 0);
	}
public:
	//构造函数
	CreditAccount(const Date &date,const std::string &id,double credit,double rate,double fee);
	double GetCredit() const{return credit;}
	double GetRate() const {return rate;}
	double GetFee() const {return fee;}
	double GetAvailableCredit() const {			//获得可用信用额度
		if(GetBalance()<0)
			return credit+GetBalance();
		else
			return credit;
	}
	//存入现金
	void Deposit(const Date &date,double amount,const std::string &desc);
	//取出现金
	void WithDraw(const Date &date,double amount,const std::string &desc);
	void Settle(const Date &date);
	void Show() const;
};
#endif//__ACCOUNT__H