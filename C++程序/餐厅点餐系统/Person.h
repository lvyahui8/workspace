#ifndef __PERSON_H__
#define __PERSON_H__
#include <string>
#include "FoodMenu.h"
using std::string;
//////////////////////////////////////////////////////////////////////////
//		����
//		ӵ���ϰ�ͷ���Ա�Ĺ������Ժ���Ϊ
//////////////////////////////////////////////////////////////////////////
class CPerson{	
private:
	string m_strName;		//����
	string m_strSex;		//�Ա�
public:
	CPerson(const string &strName="", const string &strSex="");
	//�������֣��Ա�
	void SetNameAndSex(const string & strName,const string &strSex="");
	//ȡ������
	string GetName()const{return this->m_strName;}
	//ȡ���Ա�
	string GetSex()const{return this->m_strSex;}
};

#endif /*__PERSON_H_*/