#include<iostream.h>
#include<stdlib.h>
#include"company.h"
void come();
int flag;
void yi()
{
	int n;
	company mycompany;
	mycompany.set();
	cout<<"���óɹ�"<<endl;
	mycompany.save();
	cout<<"�˳��밴0�����������밴1"<<endl;
	cin>>n;
	if(n==0){system("cls");come();}
	if(n==1){system("cls");yi();}
}
void er()
{
	int n;
	company mycompany;
	mycompany.add();
	mycompany.save();
	cout<<"�˳��밴0�����������밴1"<<endl;
	cin>>n;
	if(n==0){system("cls");come();}
	if(n==1){system("cls");er();}
}

void san()
{
	int n;
	company mycompany;
	mycompany.modify();
	mycompany.save();
	cout<<"�˳��밴0�������޸��밴1"<<endl;
	cin>>n;
	if(n==0){system("cls");come();}
	if(n==1){system("cls");san();}
}

void si()
{
	int n;
	company mycompany;
	mycompany.del();
	mycompany.save();
	cout<<"�˳��밴0������ɾ���밴1"<<endl;
	cin>>n;
	if(n==0){system("cls");come();}
	if(n==1){system("cls");si();}
}

void wu()
{
	int n;
	company mycompany;
	mycompany.search();
	mycompany.save();
	cout<<"�˳��밴0��������ѯ�밴1"<<endl;
	cin>>n;
	if(n==0){system("cls");come();}
	if(n==1){system("cls");wu();}
}

void liu()
{
	int n;
	company mycompany;
	mycompany.show();
	cout<<"��ʾ�ɹ�"<<endl;
	cout<<"�˳��밴0��������ʾ�밴1"<<endl;
	cin>>n;
	if(n==0){system("cls");come();}
	if(n==1){system("cls");liu();}
}
void come()
{
	
	int a;
	char m;
	company c;
	do
	{
	cout<<"\n\t*** ��˾��Ա����ϵͳ ***\n";
	cout<<"\t*    1-��������        *\n";
	cout<<"\t*    2-������Ա        *\n";
	cout<<"\t*    3-�޸���Ա��Ϣ    *\n";
	cout<<"\t*    4-ɾ����Ա        *\n";
	cout<<"\t*    5-��ѯ��Ա��Ϣ    *\n";
	cout<<"\t*    6-��ʾ��Ա��Ϣ    *\n";
	cout<<"\t*    0-�˳�            *\n";
	cout<<"\t************************\n";
	cout<<"��ѡ��<0-6>:";
	cin>>a;
	switch(a)
		{
			case 1:yi();break;
			case 2:er();break;
			case 3:san();break;
			case 4:si();break;
			case 5:wu();break;
			case 6:liu();break;
			case 7:c.save();break;
			case 8:c.load();break;
			case 0:
				{
					cout<<"\aȷ���˳���<y/n>:";cin>>m;
					if(m=='y'||m=='Y')
					{
						flag=0;
					}
					else if(m=='n'||m=='N')
						flag=1;
				}

		}
	}
	while(flag);	
}
void main()
{
	system("color 4F");
	int accounts=201201,passwords=000000;
	int account,password;
	int m=1,n=1;
/*
	while(m)
	{
	cout<<"�������ʺ�:"<<endl;
	cin>>account;
		if(account==accounts)
		{
			m=0;
			while(n)
			{
				cout<<"���������룺";
				cin>>password;
				if(password==passwords)		
					{
						n=0;
						system("cls");
						come();	
					}
				else
					{
						cout<<"�����������������"<<endl;
					}
					
			}	
		}
		else
			cout<<"�ʺŴ�������������"<<endl;
	}
	*/
	come();
}

