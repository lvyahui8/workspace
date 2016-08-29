#include <iostream>
#include <cstring>
using namespace std;
#pragma warning(disable:4296)	//取消警告
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
		cout<<"出错了! 错误代码在:"<<this->m_iErrCode<<
			" 异常信息是:"<<this->m_szErrInfo<<endl;		
	}
};
int dev(int i){
	int iRet = 0;
	if (0 == i) {
		throw i;	//抛出异常
	}
	iRet = 100 / i;
	return iRet;
}

void login(char szName[]){
	if (strcmp(szName,"lyh")!=0) {
		throw CUserNameException(102,"用户名不对");//new CUserNameException;
	}
	cout<<"密码正确"<<endl;
}
void main(){
	//	出现除0错误，会抛出异常
	//	cout<<dev(0)<<endl;
	try{
		cout<<dev(0)<<endl;
	}
	catch (int) {   //catch (...) {抓所有异常
		cout<<"出现异常"<<endl;
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
	//	下面的代码模拟了返回局部对象的过程。
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