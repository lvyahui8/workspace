// chapter7.cpp : Defines the entry point for the console application.
//

#include "stdafx.h"
#include <string.h>
int main(int argc, char* argv[])
{
	//printf("Hello World!\n");
	/*int grade[10];
	for(int i=0;i<=9;i++)
		scanf("%d",&grade[i]);
	i=0;
	for(;i<=9;i++)
		printf("%d ",grade[i]);*/
	
	
	/*int a[10];
	for(int i=0;i<=9;i++)
		a[i]=i;
	printf("%d\n",a[])*/

/*	int a[10];
	for(int i=0;i<=9;i++)
		a[i]=i;
	for(i=9;i>=0;i--)
		printf("%d  ",a[i]);
	printf("\n");*/

	/*int a[10]={0};
	for(int i=9;i>=0;i--)
		printf("%d  ",a[i]);*/
	
	
	// 功能》求Fibonacci数列
	/*int f[20],sum=0;
	f[0]=1;
	f[1]=1;
	printf("f[0]=%d\n",f[0]);
	printf("f[1]=%d\n",f[1]);
	for(int i=2;i<=19;i++)
	{
		f[i]=f[i-1]+f[i-2];
		printf("f[%d]=%d\n",i,f[i]);
	}
	for(i=0;i<=19;i++)
		sum=sum+f[i];
	printf("sum=%d\n",sum);

	
	#include <stdafx.h>

void main()
{
	// 功能》求Fibonacci数列前40项
	int a1=1,a2=1;
	for(int i=1;i<=20;i++)
	{
		printf("%d\n%d\n",a1,a2);
		a1=a1+a2;
		a2=a1+a2;
	}

}*/
	/*int f[20],sum=0;
	f[0]=1;
	f[1]=1;
	sum=2;
	printf("%12d",f[0]);
	printf("%12d",f[1]);
	for(int i=2;i<=19;i++)
	{
		f[i]=f[i-1]+f[i-2];
		printf("%12d",f[i]);
		sum=sum+f[i];
		if((i+1)%5==0)
			printf("\n");
	}
	printf("\tsum=%d\n",sum);*/
	
	
	//int a[3][4]={{1,2,3,4},{5,6,7,8},{9,10,11,12}};
	//int a[3][4]={0}; //1,2,3,4,5,6,7,8,9,10,11,12};
	//int a[3][4]={{1,2,3,4},{1},{9,11,12}};

	/*for(int i=0;i<=2;i++)
	{
		for(int j=0;j<=3;j++)
		{
			printf("%d ",a[i][j]);
		}
		printf("\n");
	}*/
	
	/*char c[20];
	gets(c);
	puts(c);*/

	/*char str1[100]="hello ";
	char str2[]="world!";

	strcat(str1,str2);
	printf("%s\n",str1);//将str2接在str1后面
	puts(str1);*/

	/*char str1[100];
	char str2[]="world!";
	strcpy(str1,str2);//将str2中的字符串复制到str1中；
	puts(str1);*/
	/*
	//char str1[]="wello";
	//char str2[]="horld!";
	char str1[]="hello";
	char str2[]="world!";
	int i;
	i=strcmp(str1,str2);//比较字符串的大小，
	//逐个比较字符ASCII码，比较出大小后结束比较，并不是比较字符串长短
	printf("%d\n",i);	
	*/
	/*
	char str1[]="we\0llo";
	int i;
	i=strlen(str1);//计字符串子符数，从第一个字符计起
	//到\0结束，不计\0.
	printf("%d\n",i);
	*/
//	char str1[]="wElLO";
//	printf("%s\n",strlwr(str1));//将大写转换成小写
	
//	char str1[]="wElLO";
//	printf("%s\n",strupr(str1));//将小写转换成大写
	
	
	return 0;

}

