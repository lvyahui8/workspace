#include <iostream>
#include <cstring>
using namespace std;
#pragma warning(disable:4296)	//ȡ������
class CUserNameException{
private:
	int m_iErrCode;
	char m_szErrInfo[128];
public:
	CUserNameException(const int errCode = 0,const char * const szInfo = NULL){
		if (NULL == szInfo) {
			m_szErrInfo[0] = '\0';
		}
		else{
			strcpy(m_szErrInfo,szInfo);
		}

		m_iErrCode = errCode;
	}
	void PrintErroInfo()const{
		cout<<"������! ���������:"<<this->m_iErrCode<<
			" �쳣��Ϣ��:"<<this->m_szErrInfo<<endl;		
	}
};
int dev(int i){
	int iRet = 0;
	if (0 == i) {
		throw i;	//�׳��쳣
	}
	iRet = 100 / i;
	return iRet;
}

void login(char szName[]){
	if (strcmp(szName,"lyh")!=0) {
		throw CUserNameException(102,"�û�������");//new CUserNameException;
	}
	cout<<"������ȷ"<<endl;
}
void main(){
	//	���ֳ�0���󣬻��׳��쳣
	//	cout<<dev(0)<<endl;
	try{
		cout<<dev(0)<<endl;
	}
	catch (int) {   //catch (...) {ץ�����쳣
		cout<<"�����쳣"<<endl;
	}
	
	try{
		login("asd");
	}
	catch (CUserNameException &e){//(CUserNameException *pE) {
		//pE->PrintErroInfo();
		e.PrintErroInfo();
	}
	cout<<"nihao"<<endl;
/*
	int * p=NULL;
	delete p;
	//	����Ĵ���ģ���˷��ؾֲ�����Ĺ��̡�
	CUserNameException * pu = new CUserNameException(3,"cuo");
	CUserNameException & us = *pu;
	us.PrintErroInfo();
	delete pu;
	CUserNameException & newUs = us;
	us.PrintErroInfo();
	newUs.PrintErroInfo();
*/
	char str[] = "hello\" } ):wod%e";
}