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
	cout<<"设置成功"<<endl;
	mycompany.save();
	cout<<"退出请按0，重新设置请按1"<<endl;
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
	cout<<"退出请按0，继续增加请按1"<<endl;
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
	cout<<"退出请按0，继续修改请按1"<<endl;
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
	cout<<"退出请按0，继续删除请按1"<<endl;
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
	cout<<"退出请按0，继续查询请按1"<<endl;
	cin>>n;
	if(n==0){system("cls");come();}
	if(n==1){system("cls");wu();}
}

void liu()
{
	int n;
	company mycompany;
	mycompany.show();
	cout<<"显示成功"<<endl;
	cout<<"退出请按0，重新显示请按1"<<endl;
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
	cout<<"\n\t*** 公司人员管理系统 ***\n";
	cout<<"\t*    1-数据设置        *\n";
	cout<<"\t*    2-增加人员        *\n";
	cout<<"\t*    3-修改人员信息    *\n";
	cout<<"\t*    4-删除人员        *\n";
	cout<<"\t*    5-查询人员信息    *\n";
	cout<<"\t*    6-显示人员信息    *\n";
	cout<<"\t*    0-退出            *\n";
	cout<<"\t************************\n";
	cout<<"请选择<0-6>:";
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
					cout<<"\a确定退出？<y/n>:";cin>>m;
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
	cout<<"请输入帐号:"<<endl;
	cin>>account;
		if(account==accounts)
		{
			m=0;
			while(n)
			{
				cout<<"请输入密码：";
				cin>>password;
				if(password==passwords)		
					{
						n=0;
						system("cls");
						come();	
					}
				else
					{
						cout<<"密码错误！请重新输入"<<endl;
					}
					
			}	
		}
		else
			cout<<"帐号错误，请重新输入"<<endl;
	}
	*/
	come();
}

