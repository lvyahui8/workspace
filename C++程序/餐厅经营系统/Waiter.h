#ifndef __WAITER_H__
#define __WAITER_H__

#include "Person.h"
#include "Boss.h"

class CWaiter: public CPerson{	
private:
	unsigned short m_unNumber;		//���
	double m_dAchievement;			//ҵ��
	double m_dSalary;				//����
	static double m_dAllSalary;		//���з���Ա�Ĺ���
	static unsigned short m_unWaiterCount;	//����Ա����
public:
	CWaiter * pNextWaiter;
public:
	CWaiter(const unsigned short &unNumber,
		const double &dSalary,
		const string & strName="", 
		const string & strSex="",
		const double & dAchievement=0);
	~CWaiter(){
		m_unWaiterCount--;
	}
	void StartUsingBoard()const;
	//ȡ���Լ��ı��
	unsigned short  GetNumber()const;
	//ȡ���Լ���ҵ��
	double GetAchievement()const;
	//ȡ���Լ��Ĺ���
	double GetSalary()const;
	//���������
	bool AddBoardMenuItem(CBoard *pBoard,
		CFoodMenu * pFood,
		const unsigned &uShare);
	//ɾ���ѵ����
	bool DelBoardMenuItem(CBoard * pBoard);
	
	static unsigned short GetWaiterCount(){
		return m_unWaiterCount;
	}
	friend bool CBoss::SetWaiterSalary(CWaiter **ppWaiter, 
		const unsigned short &unNumber, 
		const double & dSalary)const;

	friend bool CBoss::SetWaiterSalary(CWaiter * pWaiter, 
		const double & dSalary)const;
};

#endif /*__CWAITER_H_*/;
	