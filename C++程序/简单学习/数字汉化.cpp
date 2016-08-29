#include <iostream>
#include <string>
#include <math.h>
using std::cout;
using std::endl;
using std::string;

/*
const char refer1[10][4]={
	{"\0零"},{"\1一"},{"\2二"},{"\3三"},{"\4四"},
	{"\5伍"},{"\6六"},{"\7七"},{"\10八"},{"\11九"},
};*/
const string refer1[10]={
	{"零"},{"一"},{"二"},{"三"},{"四"},
	{"伍"},{"六"},{"七"},{"八"},{"九"},
};
const string refer2[6]={{"亿"},{""},{"十"},{"百"},{"千"},{"万"}};

void Change(const int & iValue,string & strCase){
	int iTemp=iValue;//120340
	int iHight=0;
	bool iFlags=false;
	while(iTemp){
		iHight++;
		iTemp/=10;
	}
	iTemp=iValue;
	int i,icurrent;
	for(i=iHight;i>0;i--){
		icurrent=iTemp/((int)pow(10,i-1));
		iTemp= iTemp - iTemp/((int)pow(10,i-1)) * pow(10,i-1);
		if(iFlags == false || icurrent!=0)  strCase += refer1[icurrent];
		if(icurrent!=0){
			switch(i){
			case 2:
				strCase+=refer2[2];
				break;
			case 3:
				strCase+=refer2[3];
				break;
			case 4:
				strCase+=refer2[4];
				break;
			case 5:
				strCase+=refer2[5];
				break;
			case 6:
				strCase += refer2[2];
				break;
			case 7:
				strCase += refer2[3];
				break;
			case 8:
				strCase += refer2[4];
				break;
			case 9:
				strCase += refer2[0];
			default:
				;
			}
		}
		if(0==icurrent){
			iFlags = true;
		}
		else{
			iFlags = false;
		}
		if(0==iTemp) break;
	}
}
void main(){
	string strTemp="";

	Change(120345,strTemp);
	cout<<120345<<"  "<<strTemp<<endl;
	strTemp="";
	Change(12134560,strTemp);
	cout<<12134560<<"  "<<strTemp<<endl;
	strTemp="";
	Change(100002034,strTemp);
	cout<<100002034<<"  "<<strTemp<<endl;
	strTemp="";
	Change(23030201,strTemp);
	cout<<23030201<<"  "<<strTemp<<endl;
}