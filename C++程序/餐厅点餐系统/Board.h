#ifndef __BOARD_H__
#define __BOARD_H__

#include "FoodMenu.h"


class CBoard{	
private:
	const unsigned short m_unNumber;
	unsigned m_uManCount;
	time_t m_lStartTime;
	double m_dConsume;
	static double m_dDailySales;
	static unsigned  short m_unBoardCount;
	static double m_dSnackSales;	//С������
	static double m_dDrinkSales;	//��������
	static double m_dEntreeSales;	//��������
public:
	bool m_bFlags;
	
	CBoardMenu * m_pBoardMenu;
	CBoard *pNextBoard;
public:
	CBoard(const unsigned short & unNumber=0);
	~CBoard(){
		this->m_unBoardCount--;
	}
	unsigned short GetNumber()const{
		return m_unNumber;
	}
	bool SetManCount(const unsigned & uManCount);
	unsigned GetManCount()const{
		return this->m_uManCount;
	}
	void Clean();									//��������ۼ�
	void DelBoardMenuAll(CBoardMenu * current);		//ɾ����ǰ�����ϵ����в˵�
	void SetStartTime();							//���ò�����ʹ�õ���ʼʱ��
	char * GetStartTime()const;						//�����ʼʱ��
	void SetConsume(const double & dConsume);		//�������Ѷ�
	void AddConsume(const double & dConsume);		//�������Ѷ�
	double GetConsume()const;						//������Ѷ�
	static double GetSnackSales(){					//���С��Ӫҵ��
		return m_dSnackSales;
	}
	static double GetDrinkSales(){					//�������Ӫҵ��
		return m_dDrinkSales;
	}
	static double GetEntreeSales(){					//�������Ӫҵ��
		return m_dEntreeSales;
	}
	static double GetDailySales(){					//�����Ӫҵ��
		return m_dDailySales;
	}
	static unsigned short GetBoardCount(){			//��ò�����Ŀ
		return m_unBoardCount;
	}
};

#endif /*__BOARD_H_*/