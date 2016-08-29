// 登陆界面.cpp : Defines the entry point for the console application.
//

#include <stdafx.h>
#include<stdlib.h>
#include <windows.h>
char xm[10][20];
int xh[10];
float c[10],sx[10],yy[10];


void lr()  //录入函数
{
	int i;
	for( i=0 ; i<10 ; i++)
	{
		printf("请按次序输入第%d个学生的信息：姓名 学号 c语言成绩 数学成绩 英语成绩:\n",i+1);
		scanf("%s %d %f %f %f",xm[i],&xh[i],&c[i],&sx[i],&yy[i]);
		//printf("%d=%f\n",i,c[i]);
		system("pause");
		system("cls");
	}
	
}

		/*printf("请输入\n姓名:");
		scanf("%s",name[i]);
	
		printf("\n学号:");
		scanf("%d",&a[i]);	
		//getchar();
		printf("c语言成绩:");
		scanf("%d",&b[i]);
		getchar();
		printf("数学成绩:");
		scanf("%d",&e[i]);
		printf("英语成绩:");
		scanf("%d",&d[i]);
		system("cls");
		printf("请继续第%d输入",i+2);*/


void shanchu(int a[10])  //删除函数
{
    int j,k;
	printf("请输入您想要删除信息的学生学号:\n");
	scanf("%d",&j);
    printf("请问您想要删除信息吗？想要删除就请按“1”，否则请按“2”\n");
	scanf("%d",&k);
	if(k==1)
		switch(j)
		{
		case 1:a[0]=0;break;
		case 2:a[1]=0;break;
		case 3:a[2]=0;break;
		case 4:a[3]=0;break;
		case 5:a[4]=0;break;
		case 6:a[5]=0;break;
		case 7:a[6]=0;break;
		case 8:a[7]=0;break;
		case 9:a[8]=0;break;
		case 10:a[9]=0;break;
		}
}










int main(int argc, char* argv[])
{   
	int a,b,i,s[16];
	char C;
	
	/*
	printf("\n\n\n");
	printf("\t	        ___  |   __   __            ___\n");
	printf("\t      \\  /\\  / |___  |  /    /  \\  /\\  /\\  |___\n");
	printf("\t       \\/  \\/  |___  |  \\__  \\__/ /  \\/  \\ |___\n");
	printf("\n\n\n\n\n\n\n\n\n\n\n\n\n\n\t\t作者\t于春晖\t姚婷\t刘杨凡\t谭凯琳");
    for(i=0;i<20;i++)
	{
		system("color 0c");
		Sleep(20);
		system("color 0e");
		Sleep(20);
		system("color 09");
		Sleep(20);
		system("color 0a");
		Sleep(20);
		system("color 0d");
		Sleep(20);
	}
	Sleep(300);
	system("cls");*/
A:	system("color b2");
/*	printf("\n\n\n请输入你的学号");
	scanf("%d",&a);
	while( (ch=getchar()) != '\n');
	printf("\n\n\n正在校检登陆中，请稍后\n");
	for(i=1;i<=80;i++)
	{
		printf("%c",16);
		Sleep(35);
	}
	printf("\n");
	printf("登录成功\n");
	for(i=1;i<=6;i++)
	{
		printf("\n");
		Sleep(200);
	}
	system("cls");*/
 B: printf("\t\t\t\t%d号同学，你好\n\n\t\t\t       欢迎登陆管理系统\n\n\n\n",a);
    printf("\t\t\t\t%c%c索引目录%c%c\n\n",16,16,17,17);
	printf("\t\t\t\t %c%d用户资料\n\t\t\t\t %c%d输入记录\n\t\t\t\t %c%d删除记录\n\t\t\t\t %c%d查询记录\n\t\t\t\t %c%d修改记录\n\t\t\t\t %c%d插入记录\n\t\t\t\t %c%d统计记录\n\t\t\t\t %c%d排序记录\n\t\t\t\t %c%d显示记录\n\t\t\t\t %c%d重新登录\n\n\n\n",3,1,3,2,3,3,3,4,3,5,3,6,3,7,3,8,3,9,3,0);
	printf("请输入你要进入的界面代码");
	
	scanf("%d",&b);
	getchar();
    system("cls");
	switch(b)
	{
		case 1:	system("color 9E");printf("\t\t用户资料查询界面\n");
			    printf("返回查询界面请输入“R”\n");
			    scanf("%c",&C); 
				getchar();
			    if(C=='R')
				{
					system("cls");
					goto B;
				}
				else 
				{
					break;
				}
		case 2:	system("color A1");printf("\t\t输入记录界面\n");
			    lr(); //录入函数
				printf("返回查询界面请输入“R”\n");
				scanf("%c",&C);
				getchar();
					if(C=='R')
					{
						system("cls");
						goto B;
					}
					else 
					{
						break;
					}
		case 3:	system("color B5");printf("\t\t删除记录界面\n");
			  //  shanchu(xh);  //删除函数
			    printf("返回查询界面请输入“R”\n");
				scanf("%c",&C);
				getchar();
					if(C=='R')
					{
						system("cls");
						goto B;
					}
					else
					{
						break;
					}
		case 4:	system("color C1");printf("\t\t查询记录界面\n");
			    printf("返回查询界面请输入“R”\n");
				scanf("%c",&C); 
				getchar();
					if(C=='R')
					{
						system("cls");
						goto B;
					}
					else 
					{
						break;
					}
        case 5:	system("color D1");printf("\t\t修改记录界面\n");
			    printf("返回查询界面请输入“R”\n");
			    scanf("%c",&C); 
				getchar();
			    if(C=='R')
				{
					system("cls");
					goto B;
				}
				else 
				{
					break;
				}
        case 6:	system("color E1");printf("\t\t插入记录界面\n");
			    printf("返回查询界面请输入“R”\n");
			    scanf("%c",&C); 
				getchar();
			    if(C=='R')
				{
					system("cls");
					goto B;
				}
				else 
				{
					break;
				}
        case 7:	system("color F1");printf("\t\t统计记录界面\n");
			    printf("返回查询界面请输入“R”\n");
			    scanf("%c",&C); 
				getchar();
			    if(C=='R')
				{
					system("cls");
					goto B;
				}
				else 
				{
					break;
				}
        case 8:	system("color C1");printf("\t\t排序记录界面\n");
			    printf("返回查询界面请输入“R”\n");
			    scanf("%c",&C); 
				getchar();
			    if(C=='R')
				{
					system("cls");
					goto B;
				}
				else 
				{
					break;
				}
        case 9:	system("color D1");printf("\t\t显示记录界面\n");
			    printf("返回查询界面请输入“R”\n");
			    scanf("%c",&C); 
				getchar();
			    if(C=='R')
				{
					system("cls");
					goto B;
				}
				else 
				{
					break;
				}
       
        
		case 0: system("cls");goto A;
		default:printf("你的输入有误，请重新输入\n");goto B;
	}
	return 0;
}
