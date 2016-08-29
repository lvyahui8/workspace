#include <iostream>
#include <stdio.h>
#include <string>
#include<fstream>
using namespace std;

class CWaiter{
public:
	string m_strName;
	string m_strSex;
	int m_iNumber;
public:
	CWaiter(){}
	void Set(const string &strName,const string & strSex,const int &iNumber){
		this->m_iNumber=iNumber;
		this->m_strName =strName;
		this->m_strSex =strSex;
	}
};
void main(){
//	int i; 
/*	
	ofstream ofwaiter("waiter.dat",ios_base::out | ios_base::binary);
	CWaiter waiter[4];
	
	if(ofwaiter){
		for(i=0;i<4;i++){
			cin>>waiter[i].m_strName;
			ofwaiter.write((char*)&(waiter[i].m_strName),sizeof(string));
		}
	}
	ofwaiter.close();
*/
	/*
	ifstream ifwaiter("waiter.dat",ios_base::binary);
	CWaiter nwaiter[4];
	if(ifwaiter){
		for(i=0;i<4 && !ifwaiter.eof();i++){
			ifwaiter.read((char*)&(nwaiter[i].m_strName),sizeof(string));
			cout<<nwaiter[i].m_strName<<endl;
		}
	}
	else{
		cout<<"dakaishibai"<<endl;
	}
	ifwaiter.close();
	*/

	ifstream infTemp("7.dat");
	cout<<infTemp<<endl;
	infTemp>>i;
	cout<<infTemp<<endl;
	infTemp>>i;
	i = 5;
	cout<<infTemp<<endl;
/*	
	char ch='a';
	//ch+=100;
	ch = ch + 1000;*/
}

/*
void main(){
	CWaiter waiter[4];
	int i;

	FILE * fpWaiter;
	fpWaiter=fopen("waiter.dat","rb+");	
	for(i=0;i<4;i++){
		cin>>waiter[i].m_strName;//>>waiter[i].m_strSex>>waiter[i].m_iNumber;
		fwrite(waiter[i].m_strName.c_str(),1,waiter[i].m_strName.size(),fpWaiter);
		//fwrite(&waiter[i].m_strName,sizeof(string),1,fpWaiter);
	}
	for(i=0;i<4;i++){
		char  buffer[255];
		fread(buffer,sizeof(string),1,fpWaiter);
		waiter[i].m_strName +=buffer[i];
	}
}
*/
/*
void main(){
	int i; 
//	
	ofstream ofwaiter("waiter.dat",ios_base::out | ios_base::binary);
	CWaiter waiter[4];
	
	if(ofwaiter){
		for(i=0;i<4;i++){
			cin>>waiter[i].m_strName>>waiter[i].m_strSex>>waiter[i].m_iNumber;
			ofwaiter.write(reinterpret_cast<char*>(&waiter[i]),sizeof(waiter[i]));
		}
	}
	ofwaiter.close();
//
	ifstream ifwaiter("waiter.dat",ios_base::binary);
	CWaiter nwaiter[4];
	if(ifwaiter){
		for(i=0;i<4 && !ifwaiter.eof();i++){
			ifwaiter.read(reinterpret_cast<char*>(&nwaiter[i]),sizeof(nwaiter[i]));
			//ifwaiter>>nwaiter[i].m_strName>>nwaiter[i].m_strSex>>nwaiter[i].m_iNumber;
			cout<<nwaiter[i].m_strName<<" "<<nwaiter[i].m_strSex<<" "<<nwaiter[i].m_iNumber<<endl;
		}
	}
	else{
		cout<<"dakaishibai"<<endl;
	}
	ifwaiter.close();
}
*/


/*
void main(){
	int i;
	FILE * fpWaiter;
	CWaiter waiter[10];
	CWaiter newWaiter[10] ;
	if((fpWaiter = fopen("waiter.dat","rb+")) ==NULL){
		cout<<"文件打开失败";
	}
	
	string strName;
	string strSex;
	int iNumber;
	for(i=0;i<10;i++){
		cin>>strName;
		cin>>strSex;
		cin>>iNumber;
		waiter[i].Set(strName,strSex,iNumber);
	}
	for(i=0;i<10;i++){
		fwrite(&waiter[i],sizeof(CWaiter),1,fpWaiter);
	}
	for(i=0;i<10;i++){
		fread(&newWaiter[i],sizeof(CWaiter),1,fpWaiter);
	}
	for (i=0;i<10;i++){
		cout<<newWaiter[i].m_strName<<endl;
	}
}*/