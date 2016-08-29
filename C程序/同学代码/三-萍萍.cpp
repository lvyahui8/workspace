// kaoshixintong.cpp : 定义控制台应用程序的入口点。
//

#include "stdafx.h"
#include"stdlib.h"
#include"windows.h"

void loading();void daan();void jf(int x,int y);void finish();
void ti1();void ti2();void ti3();void ti4();void ti5();
void ti6();void ti7();void ti8();void ti9();void ti10();

char str1[10],str2[10];

int i,j=0,sum=0;
int xf[10];

void main()
{
	system("title 考试系统  & color 1a");
	printf("                              欢迎进入考试，祝你考试顺利!\n");
	printf("\n\n");
	printf("\t\t\t   \n输入姓名：");
	gets(str1);
	printf("\t\t\t   \n输入学号: ");	
	gets(str2);
	printf("\n\n");
	printf("进入答题中，请稍后");
	loading();
	system("cls");
	ti1(); jf(33,i);
	ti2(); jf(0,i);
	ti3(); jf(1,i);
	ti4(); jf(4,i);
	ti5(); jf(100,i);
	ti6(); jf(1,i);
	ti7(); jf(-1,i);
	ti8(); jf(6,i);
	ti9(); jf(2,i);
	ti10(); jf(8,i);
	finish();
	for(j=0;j<=9;j++)
	{
		sum=sum+xf[j];
	}
	printf("你的最后得分是%d\n",sum);
	system("pause");
}
void loading()
{
	for(int i=1;i<=24;i++)
	{
			printf("▇");
			Sleep(50);
	}
}
void ti1()
{
	printf("第一题\n\t“int i=289;char c='a';c=i;”请问输出的c的值为多少？\n你的答案: ");
	daan();
	printf("\n\n");

}
void ti2()
{
	printf("第二题\n\t令i=0，那么i++的值是？\n你的答案：");
	daan();
	printf("\n\n");


}
void ti3()
{
	printf("第三题\n\t用来输出一个字符串的格式符是？\n\t1.s\t\t2.d\t\t3.c\n你的答案：");
	daan();
	printf("\n\n");
}
void ti4()
{
	printf("第四题\n\t编译系统为每一个“float”变量分配多少个字节？\n你的答案：");
	daan();
	printf("\n\n");
}
void ti5()
{
	printf("第五题\n\t“for(int i=1,i<=100,i++）”表示的是循环多少次？\n你的答案：");
	daan();
	printf("\n\n");
}
void ti6()
{
	printf("第六题\n\t“程序总是从main函数开始执行的”这句话对吗？\t请选择：1.对\t2.不对\n你的答案：");
	daan();
	printf("\n\n");
}
void ti7()
{
	printf("第七题\n\t程序“char c=255；printf（“%d”,c）”的输出结果是？\n你的答案：");
	daan();
	printf("\n\n");
}
void ti8()
{
	printf("第八题\n\t“float”数据可以得到多少位有效数字？\n你的答案：");
	daan();
	printf("\n\n");
}
void ti9()
{
	printf("第九题\n\t判断下列表示方式是否正确“int=3；”\n请选择:1.正确	2.错误\n你的答案：");
	daan();
	printf("\n\n");
}
void ti10()
{
	printf("第十题\n\t请问式子“a=（b=4）+（c=4）”中“a”表示的值是?\n你的回答：");
	daan();
	printf("\n\n");
}
void daan()
{
	scanf("%d",&i);
	i=getchar();
	printf("\n\n");
}
void jf(int x,int y)
{
	if(x==y)
	{
		xf[j]=10;
	}
	else
	{
		xf[j]=0;
	}
	j++;
}
void finish()
{
	int a;
	printf("确定提交吗？检查请输入题号并回车，确定提交请输入0回车。");
	scanf("%d",&a);
	if(1==a)
		ti1();
	if(2==a)
		ti2();
	if(3==a)
		ti3();
	if(4==a)
		ti4();
	if(5==a)
		ti5();
	if(6==a)
		ti6();
	if(7==a)
		ti7();
	if(8==i)
		ti8();
	if(9==a)
		ti9();
	if(10==a)
		ti10();
}
