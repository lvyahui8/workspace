#ifndef __SHOPKEEPER_H__
#define __SHOPKEEPER_H__
#include "FoodMenu.h"
#include "Person.h"
#include "Board.h"

#include "Waiter.h"
class CWaiter;
//////////////////////////////////////////////////////////////////////////
//	�곤�࣬�̳�������
//
//////////////////////////////////////////////////////////////////////////
class CBoss:public CPerson{
private:
	string m_strPassword;
public:
	CBoss(const string & strPassword,
		const string & strName="", 
		const string & strSex="");
	void ChangePassword(const string & strPassword);				//��������
	string GetPassword()const;
	CFoodMenu * AddFoodMenuItem(CFoodMenu ** ppFoodMenu,			//���Ӳ�������
		const unsigned &uFoodType,
		const string &strFoodName,
		const double & dPrice)const;
	bool DelFoodMenuItem(CFoodMenu **ppFoodMenu,					//ɾ����������
		const string &strFoodName);
	bool AddBoard(CBoard ** ppBoard)const;							//���Ӳ���
	bool DelBoard(CBoard ** ppBoard);								//���ٲ��� 
	bool AddWaiter(CWaiter **ppWaiter,
		const unsigned short &unNumber,
		const double &dSalary,
		const string & strName="", 
		const string & strSex="",
		const double & dAchievement=0)const;								//���ӷ���Ա
	bool DelWaiter(CWaiter **ppWaiter,								//ɾ������Ա
		const unsigned short &unNumber)const;
	//���÷���Ա����
	bool SetWaiterSalary(CWaiter **ppWaiter,
		const unsigned short &unNumber,
		const double & dSalary)const;
	bool SetWaiterSalary(CWaiter * pWaiter, 
		const double & dSalary)const;
};
#endif//__SHOPKEEPER_H__