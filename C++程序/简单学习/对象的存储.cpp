#include <iostream>
#include <stdio.h>
#include <string>
#include<fstream>
using namespace std;

class CWaiter{
public:
	string m_strName;
	int m_iNumber;
	CWaiter(){}
	CWaiter(const string &strName,const int &iNumber)
		:m_strName(strName),m_iNumber(iNumber){
	}
};

void main(){
	int i;
	CWaiter waiter[4]={
		CWaiter("zhangsan",1),
		CWaiter("lisi",2),
		CWaiter("zhaowu",3),
		CWaiter("liliu",4)
	};
/*	
	ofstream ofwaiter("001.dat");
	for (i=0;i<4;i++) {
		//ofwaiter<<waiter[i].m_strName<<waiter[i].m_iNumber;
		ofwaiter.write((char*)&waiter[i],sizeof(waiter[i]));
	}
*/
	CWaiter nwaiter[4];
	ifstream ifwaiter("001.dat");
	for(i=0;i<4;i++){
		//getline(ifwaiter,nwaiter[i].m_strName);
		//ifwaiter>>nwaiter[i].m_strName>>nwaiter[i].m_iNumber;
		ifwaiter.read((char*)&nwaiter[i],sizeof(CWaiter));
		cout<<nwaiter[i].m_strName<<" "<<nwaiter[i].m_iNumber<<endl;
	}
}