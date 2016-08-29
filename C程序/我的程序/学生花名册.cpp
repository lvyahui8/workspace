// 花名册.cpp : Defines the entry point for the console application.
/*
需求：制作员工花名册

步骤：
1.输入序号和姓名
2.根据序号用起泡法排序
3.输出序号和姓名
*/
#include "stdafx.h"
#include <string.h>
#define M 5  // 指明人数
#define N 10 // 指明人名长度
void int_swap(int *p1,int *p2)
{	// 交换变量值
	*p1=*p1+*p2;
	*p2=*p1-*p2;
	*p1=*p1-*p2;
}

void float_swap(float *p1,float *p2)
{	// 交换变量值
	*p1=*p1+*p2;
	*p2=*p1-*p2;
	*p1=*p1-*p2;
}

void str_swap(char str1[],char str2[])
{	// 交换字符串
    char temp[20];
	strcpy(temp,str1);
	strcpy(str1,str2);
	strcpy(str2,temp);
}

void sort(int i_n[],char str[][N],float score[],int i_long)
{
	int i,j,k;
	for(i=0;i<i_long-1;i++)
	{
		for(j=i+1;j<i_long;j++)
		{
			if(i_n[j]>i_n[j+1])
			{
				k=j;
			}
			if(k!=i)
			{
				int_swap(&i_n[k],&i_n[i]);
				str_swap(str[k],str[i]);
				float_swap(&score[k],&score[i]);
			}
		}
	}
}

int find(float array[],float k,int i_long)
{
	int high=9,low=0,m;
	while(high>=low)
	{
		m=(high+low)/2;
		if(k<array[m])
			high=m-1;
		else if(k>array[m])
			low=m+1;
		else
			return m;
	}
	return -1;
}
void input(int i_n[],char str[][N],float score[],int i_long)
{
	int i;
	for(i=0;i<i_long;i++)
	{
		scanf("%d%*c",&i_n[i]);
		scanf("%s%*c",str[i]);
		scanf("%f%*c",&score[i]);
	}
}

void output(int i_n[],char str[][N],float score[],int i_long)
{
	int i;
	for(i=0;i<i_long;i++)
	{
		printf("Number:%d Name:%s Score:%f\n",i_n[i],str[i],score[i]);
	}
}

void main()
{
	int i_num[M];
	char c_name[M][N];
	float f_score[M];
	int sign;
	float key;
	// 输入初值
	input(i_num,c_name,f_score,M);
	// 排序
	sort(i_num,c_name,f_score,M);	
	output(i_num,c_name,f_score,M);
	// 输出
	puts("输入你要查找的学生的成绩：");
	scanf("%f",&key);
	sign=find(f_score,key,sign);
	if(sign>=0)
		printf("Number:%4dName:%s Score:%f\n",i_num[sign],c_name[sign],f_score[sign]);
	else
		printf("没有该值\n")
}