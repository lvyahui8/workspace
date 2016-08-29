#include "stdafx.h"
#include <windows.h>
#include <stdlib.h>
#include <math.h>
//#include <color.h>
#define LE 10
// 输入输出模块宏名

#define NAME 20 //名字长度
/*
#include <stdio.h>
#include "format.h"
*/

int number[LE]={0};//学号
char name[LE][20];//姓名
float c_score[LE];//c语言成绩
float m_score[LE];//数学成绩
float e_score[LE];//英语成绩
//统计数据模块
float m1,m2,m3;
int n1,n2,n3;
//输入输出模块
int n=0;
void f_swap(float *f1,float *f2)
{
	float temp;
	temp=*f1;
	*f1=*f2;
	*f2=temp;
}
//************************************************************删除数据模块******************************************************************
void shanchu()
{
	int j;
	int n;
	printf("请输入想删除的序号n\n");
	scanf("%d",&n);
	for(j=0;j<10;j++)
	{
		if(number[j]==n)
		{
			number[j]=0;
			break;
		}
	}
}

//************************************************************排序数据模块******************************************************************
void paixu()
{
	int i,j;
	float a[LE],t;
	for(i=0;i<10;i++)
	{
		a[i]=(float)(c_score[i]+e_score[i]+m_score[i])/3;
	}
	for(i=0;i<9;i++)
	{
		for(j=0;j<9-i;j++)
		{
			if(a[i]>a[i+1])
			{
				t=a[i];
				a[i]=a[i+1];
				a[i+1]=t;
			}
		}
	}
	
	for(i=0;i<10;i++)
	{
		if(a[i]!=0)
			printf("%f ",a[i]);
	}
	system("pause");
	system("cls");
}

//************************************************************插入数据模块******************************************************************


void charu()
{	
	int i,j;
	int m;
	char s[20];
	float c_s;
	float e_s;
	float m_s;
	printf("请输入要插入的学生信息\n");
	printf("请输入学号:");
	scanf("%d%*c",&m);	
	printf("请输入姓名:");
	gets(s);
	printf("请输入C语言成绩:");
	scanf("%f%*c",&c_s);
	printf("请输入英语成绩:");
	scanf("%f%*c",&e_s);
	printf("请输入数学成绩:");
	scanf("%f%*c",&m_s);
	n++;
	printf("n==%d\n",n);
	for(i=0;i<n && number[i]<m && number[i]!=0;i++);
	printf("i==%d\n",i);
	printf("%d %s %.2f %.2f %.2f\n",
			number[0],name[0],c_score[0],e_score[0],m_score[0]);
	if(i == n || number[i]==0)
		;
	else
	{
		for(j=n;j>=i;j--)
		{
			number[j+1]=number[j];
			strcpy(name[j+1],name[j]);
			c_score[j+1]=c_score[j];
			e_score[j+1]=e_score[j];
			m_score[j+1]=m_score[j];
			printf("%d %s %.2f %.2f %.2f\n",
				number[0],name[0],c_score[0],e_score[0],m_score[0]);
		}
	}
	number[i]=m;strcpy(name[i],s);
	c_score[i]=c_s;e_score[i]=e_s;
	m_score[i]=m_s;
	system("echo 按任意键返回上层_ _ _ _ _ _ _ _ & pause > nul");
	system("cls");
}


//************************************************************修改数据模块******************************************************************
void xiugai()
{
	int i;
	int n,m;
	printf("请输入想修改的学号n\n");
	scanf("%d",&n);
	printf("请输入想修改成的学号m\n");
	scanf("%d",&m);
	for(i=0;i<10;i++)
	{
		if(number[i]==n)
		{
			number[i]=m;
			printf("请输入想修改成的姓名:");
			gets(name[n]);
			printf("请输入想修改成的C语言成绩:");
			scanf("%f%*c",&c_score[i]);
			printf("请输入想修改成的英语成绩:");
			scanf("%f%*c",&e_score[i]);
			printf("请输入想修改成的数学成绩:");
			scanf("%f%*c",&m_score[i]);
		}
	}
	system("pause");
	system("cls");
}


//************************************************************查询数据模块******************************************************************
void chaxun1(int a)
{
	int i;
	for(i=0;i<LE;i++)
	{
		while(number[i]==a)
		{
			printf("您所查询的同学的具体信息如下:\n");
			printf("学号:%d\n",number[i]);
			printf("姓名:%");
			puts(name[i]);
			printf("c语言成绩:%.2f\n",c_score[i]);
			printf("英语成绩:%.2f\n",e_score[i]);
			printf("高数成绩:%.2f\n",m_score[i]);
			break;
		}			
	}
	if(number[i]!=a)
		printf("查无此学号\n");
}

void chaxun2(char z[20])
{
	int i;
	for(i=0;i<LE;i++)
	{
		while(strcmp(name[i],z)==0)
		{
			printf("您所查询的同学的具体信息如下:\n");
			printf("学号:%d\n",number[i]);
			printf("姓名:");
			puts(name[i]);
			printf("c语言成绩:%.2f\n",c_score[i]);
			printf("英语成绩:%.2f\n",e_score[i]);
			printf("高数成绩:%.2f\n",m_score[i]);
			break;
		}
	}
	if(strcmp(name[i],z)!=0)
		printf("查无此同学\n");
}

int Chaxun_main()
{
	int a,x;
	char ch;
	char z[20];
	int b;
P:	printf("请选择查询方式：\n");
	printf("1.按学号查询\n2.按姓名查询\n3.返回主界面\n");
	scanf("%d",&a);
	while(( ch=getchar() ) != '\n');
	switch(a)
	{
		case 1:
			printf("请输入您要查询的同学的学号:");
			scanf("%d",&x);
			chaxun1(x);
			break;
		case 2:
			printf("请输入您要查询的同学的姓名:");
			gets(z);
			chaxun2(z);
			break;
		case 3:;break;
		default:printf("输入错误，请重新输入!");system("cls");goto P;
	}

	printf("继续查询或返回主菜单？\n");
	printf("1.继续\n2.返回主菜单\n");
	scanf("%d",&b);
	while(( ch=getchar() ) != '\n');
	system("cls");
	if(b==1)
		goto P;
	return 0;
}

//************************************************************输入输出模块******************************************************************
void Entry_record()
{
	printf("请输入学号:");
	scanf("%d%*c",&number[n]);
	printf("请输入姓名:");
	gets(name[n]);
	printf("请输入C语言成绩:");
	scanf("%f%*c",&c_score[n]);
	printf("请输入英语成绩:");
	scanf("%f%*c",&e_score[n]);
	printf("请输入数学成绩:");
	scanf("%f%*c",&m_score[n]);
	n++;
	system("echo 按任意键返回上层_ _ _ _ _ _ _ _ & pause > nul");
	system("cls");
}

void Display_records()
{
	int i;
	puts("学号\t姓名\tC语言\t英语\t数学\n");
	for(i=0;i<LE;i++)//i<n && 
	{
		if(0!=number[i])
			printf("%d %s %.2f %.2f %.2f\n",
			number[i],name[i],c_score[i],e_score[i],m_score[i]);
	}
	system("echo 按任意键返回上层_ _ _ _ _ _ _ _ & pause > nul");
	system("cls");
}

//************************************************************统计数据模块******************************************************************
void my_max(float x[LE])
{
	float m;
	int i,n;
	m=x[0];
	n=0;
	for(i=0;i<LE;i++)
	{
		if(x[i]>m)
		{
			m=x[i];
			n=i;
		}
	}
	printf("本科目最高分是%.2f.\n",x[n]);
}

void no_pass(float y[LE])
{
	int i,j;
	j=0;
	for(i=0;i<LE;i++)
	{
		if(y[i]<60)
			j++;
	}
	printf("本科目共有%d个不及格的同学.\n",j);
}

void all()
{
	int i;
	m1=c_score[0];
	m2=m_score[0];
	m3=e_score[0];
	n1=0;n2=0;n3=0;
	for(i=0;i<LE;i++)
	{
		if(c_score[i]>m1)
		{
			m1=c_score[i];
		}
	}
	for(i=0;i<LE;i++)
	{
		if(m_score[i]>m2)
		{
			m2=m_score[i];
		}
	}
	for(i=0;i<LE;i++)
	{
		if(e_score[i]>m3)
		{
			m3=e_score[i];
		}
	}
	for(i=0;i<LE;i++)
	{
		if(c_score[i]<60)
			n1++;
	}
	for(i=0;i<LE;i++)
	{
		if(m_score[i]<60)
			n2++;
	}
	for(i=0;i<LE;i++)
	{
		if(e_score[i]<60)
			n3++;
	}
}

int Tonji_main()
{
	int a,b,c;
	char ch;
A1:	printf("                                                                                \n");
	printf("                                  统计记录模块                                  \n");
	printf("\n\n\n\n");
	printf("                                  1.单科统计\n");
	printf("                                  2.总体统计\n");
	printf("                                  3.返回主菜单\n");
	printf("\n\n");
	printf("                                   请选择:");
	scanf("%d",&c);
	while(( ch=getchar() ) != '\n');
	system("cls");
	if(c==1)
	{
A2:		printf("请输入:\n1.C语言\t2.数学\t3.英语\n4.返回统计记录模块菜单\n");
		scanf("%d",&a);
		while(( ch=getchar() ) != '\n');
		if(a==4)
		{
			system("cls");
			goto A1;
		}
		else if(a==1)
		{
			printf("请选择您要查询的项目:\n1.最高分\t2.不及格人数\n");
			scanf("%d",&b);
			if(b==1)
			{
				my_max(c_score);
				system("pause");
				system("cls");
				goto A2;
			}
			else if(b==2)
			{
				no_pass(c_score);
				system("pause");
				system("cls");
				goto A2;
			}
			else
			{
				printf("输入有误,请重新输入.\n");
				system("pause");
				system("cls");
				goto A2;
			}
		}
		else if(a==2)
		{
			printf("请选择您要查询的项目:\n1.最高分\t2.不及格人数\n");
			scanf("%d",&b);
			if(b==1)
			{
				my_max(m_score);
				system("pause");
				system("cls");
				goto A2;
			}
			else if(b==2)
			{
				no_pass(m_score);
				system("pause");
				system("cls");
				goto A2;
			}
			else
			{
				printf("输入有误,请重新输入.\n");
				system("pause");
				system("cls");
				goto A2;
			}
			
		}
		else if(a==3)
		{
			printf("请选择您要查询的项目:\n1.最高分\t2.不及格人数\n");
			scanf("%d",&b);
			if(b==1)
			{
				my_max(e_score);
				system("pause");
				system("cls");
				goto A2;
			}
			else if(b==2)
			{
				no_pass(e_score);
				system("pause");
				system("cls");
				goto A2;
			}
			else
			{
				printf("输入有误,请重新输入.\n");
				system("pause");
				system("cls");
				goto A2;
			}
			
		}
		else
		{
			printf("输入有误,请重新输入.\n");
			system("pause");
			system("cls");
			goto A2;
		}
	}
	else if(c==2)
	{
		all();
		printf("********************************************************************************\n");
		printf("***********************     最高分     ***********     不及格人数     **********\n");
		printf("********************************************************************************\n");
		printf("***   C语言   *********       %.2f     ***********          %d        **********\n",m1,n1);
		printf("********************************************************************************\n");
		printf("***   数 学   *********       %.2f     ***********          %d        **********\n",m2,n2);
		printf("********************************************************************************\n");
		printf("***   英 语   *********       %.2f     ***********          %d        **********\n",m3,n3);
		printf("********************************************************************************\n");
		system("pause");
		system("cls");
		goto A1;
	}
	else if(c==3)
	{

	}
	else
	{
		printf("输入有误,请重新输入.\n");
		system("pause");
		system("cls");
		goto A1;
	}
	return 0;
}

//************************************************************主调函数**********************************************************************
void menu()
{
	int key=-1,i;
	char ch;
	system("color 1d");
	while(key!=0)
	{
		system("title 学生成绩管理系统");
		puts("\t     _____                 &&&&_) )");
		puts("\t   \\/,---<                &&&&&&\\ \\");
		puts("\t   ( )c~c~~@~@            )- - &&\\ \\");
		puts("\t    C   >/                \\<   |&/		1. 录入记录");
		puts("\t     \\_O/ - 哇塞          _`*-'_/ /	\t2. 删除记录");
		puts("\t   ,- >o<-.              / ____ _/		3. 查询记录");
		puts("\t  /   \\/   \\            / /\\  _)_)	\t4. 修改记录");
		puts("\t / /|  | |\\ \\          / /  )   |		5. 插入记录");
		puts("\t \\ \\|  | |/ /          \\ \\ /    |	\t6. 统计记录");
		puts("\t  \\_\\  | |_/            \\ \\_    |	\t7. 排序记录");
		puts("\t  /_/`___|_\\            /_/\\____|		8. 保存记录(维护中)");
		puts("\t    |  | |                  \\  \\|		9. 显示记录");
		puts("\t    |  | |                   `. )		0. 退出系统");
		puts("\t    |  | |                   / /");
		puts("\t    |__|_|_                 /_/|");
		puts("\t    (____)_)                |\\_\\_");
		printf("请输入你要进入的模块的标号:");
		scanf("%d",&key); 
		while( (ch=getchar()) != '\n');
		for(i=0;i<6;i++)
		{
				system("title 等待响应.");Sleep(70);
				system("title 等待响应. .");Sleep(70);
				system("title 等待响应. . . ");Sleep(70);
				system("title 等待响应. . . .");Sleep(70);
				system("title 等待响应. . . . .");Sleep(70);
				system("title 等待响应. . . . . .");Sleep(70);
		}
		system("title 学生成绩管理系统");
		system("cls");
		switch(key)
		{	
		case 1:Entry_record();break;
		case 2:shanchu();break;
		case 3:Chaxun_main();break;
		case 4:xiugai();break;
		case 5:charu();break;
		case 6:Tonji_main();break;
		case 7:paixu();break;
		//case 8:
		case 9:Display_records();break;
		case 0:break;
		default :break;
		}
	}
}

void main()
{	
	
	menu();
}
