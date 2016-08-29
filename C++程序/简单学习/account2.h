#ifndef __ACCOUNT__H
#define __ACCOUNT__H
#include "date.h"
#include "accumulator.h"
#include <string>
class Account{
private:
	std::string id;			//�˺�
	double balance;
	static double total;
protected:
	//����������õĹ��캯����idΪ�˺�
	Account(const Date &date,const std::string & id);
	//��¼һ���ˣ�dateΪ���ڣ�amountΪ��descΪ˵��
	void Record(const Date &date,double amount,const std::string &desc);
	//���������Ϣ
	void Error(const std::string &msg) const;
public:
	const std::string & GetId() const {return id;}
	double GetBalance() const{return balance;}
	static double GetTotal(){return total;}
	//��ʾ�˻���Ϣ
	void Show()const;
};

class SavingsAccount:public Account{				//�����˻���
private:
	Accumulator acc;							//����������Ϣ���ۼ���
	double rate;								//����������
public:
	//���캯��
	SavingsAccount(const Date &date,const std::string &id,double rate);
	double GrtRate()const{return rate;}
	//�����ֽ�
	void Deposit(const Date &date,double amount,const std::string &desc);
	//ȡ���ֽ�
	void Withdraw(const Date &date,double amount,const std::string &desc);
	void Settle(const Date &date);				//������Ϣ��ÿ��1��1�յ���һ�θú���
};

class CreditAccount:public Account{				//�����˻���
private:
	Accumulator acc;
	double credit;								//���ö��
	double rate;								//Ƿ�������Ϣ
	double fee;									//���ÿ����
	double GetDebt() const{						//���Ƿ���
		double balance = GetBalance();
		return (balance<0 ? balance : 0);
	}
public:
	//���캯��
	CreditAccount(const Date &date,const std::string &id,double credit,double rate,double fee);
	double GetCredit() const{return credit;}
	double GetRate() const {return rate;}
	double GetFee() const {return fee;}
	double GetAvailableCredit() const {			//��ÿ������ö��
		if(GetBalance()<0)
			return credit+GetBalance();
		else
			return credit;
	}
	//�����ֽ�
	void Deposit(const Date &date,double amount,const std::string &desc);
	//ȡ���ֽ�
	void WithDraw(const Date &date,double amount,const std::string &desc);
	void Settle(const Date &date);
	void Show() const;
};
#endif//__ACCOUNT__H