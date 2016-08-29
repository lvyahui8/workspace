#include <iostream>
#include <string>
#include "CEmployee.h"
/*
using std::cout;
using std::cin;
using std::endl;
using std::string;
*/
using namespace std;
//CEmployeeÀà·½·¨
CEmployee::CEmployee(const string &name,		
					 const string &address,		
					 const string &city,		
					 const unsigned &zipCode)	
		:m_sName(name),m_sAddress(address),m_sCity(city),m_uZipCode(zipCode){}

CEmployee::CEmployee():m_sName(""),m_sAddress(""),m_sCity(""),m_uZipCode(0){}

void CEmployee::fnChange_Name(const string &name){
	this->m_sName = name;
}

void CEmployee::fnDisplay() const{
	cout<<'\t'<<this->m_sName<<endl
		<<'\t'<<this->m_sAddress<<endl
		<<'\t'<<this->m_sCity<<endl
		<<'\t'<<this->m_uZipCode<<endl<<endl;
}