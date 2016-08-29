
#include <iostream>
#include <stdio.h>
#include <string>
using namespace std;

class CWaiter{
private:
	string m_strName;
	string m_strSex;
	int m_iNumber;
public:
	CWaiter(const string strName,const string & strSex,int iNumber)
		:m_iNumber(iNumber),m_strSex(strSex),m_strName(strName){
	}
	CWaiter * m_pNextWaiter;
};

void main(){
	FILE * fpWaiter=fopen("waiter.dat","rb+");
}