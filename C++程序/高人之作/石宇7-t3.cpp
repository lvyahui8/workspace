#include<iostream>
using namespace std;
class people
{
	public:
		char name[11]; 
		char number[7]; 
		char sex[3]; 
		struct {  char year[5];  char month[3];  char day[3]; } bir;  char id[16];   
		void setValue(char* cname,    char* cnumber,    char * csex,    char*cyear,    char *cmonth,    char*cday,    char*cid)   
		{   
			memset(name,0,11);    
			memcpy(name,cname,strlen(cname));    
			memset(number,0,7);    
			memcpy(number,cnumber,strlen(cnumber));    
			memset(sex,0,3);    
			memcpy(sex,csex,strlen(csex));    
			memset(bir.year,0,5);    
			memcpy(bir.year,cyear,strlen(cyear));    
			memset(bir.month,0,3);    
			memcpy(bir.month,cmonth,strlen(cmonth));    
			memset(bir.day,0,3);    
			memcpy(bir.day,cday,strlen(cday));    
			memset(id,0,16);    
			memcpy(id,cid,strlen(cid));   
		}   
		void print()   
		{    
			cout<<name<<endl;    
			cout<<number<<endl;    
			cout<<sex<<endl;    
			cout<<bir.year<<endl;    
			cout<<bir.month<<endl;    
			cout<<bir.day<<endl;    
			cout<<id<<endl;   
		}
};
void main()
{ 
	char cname[11]; 
	char cnumber[7]; 
	char csex[3]; 
	char cyear[5]; 
	char cmonth[3]; 
	char cday[3]; 
	char cid[16]; 
	cin>>cname  >>cnumber  >>csex  >>cyear  >>cmonth  >>cday  >>cid;
	people peo;
	peo.setValue(cname,cnumber,csex,cyear,cmonth,cday,cid);peo.print();
}