#include <stdafx.h>
#include <math.h>

void main()
{
	/*
	题目：判断101-200之间有多少个素数，
	并输出所有素数。 
	
	1.程序分析： 检查一个正整数N是否
	为素数，最简单的方法就是试除法，将
	该数N用小于等于根号N的所有素数去试
	除，若均无法整除，则N为素数，参见
	素数判定法则。
	
	2.程序源代码：*/
	int i,j,k,leap=0; 
	scanf("%d",&i);
	for(j=2;j<=sqrt(i);j++)
	{
		if(i%j==0)
			leap++;
	}
	if(leap==0)
		printf("%d是素数",i);
	else
		printf("%d不是素数",i);

	/*int m,i,k; 
	scanf("%d",&m); 
	k=sqrt(m); 
	for(i=2;i<=k;i++) 
		if(m%i==0)break; 
	if(i>=k+1) 
		printf("%d 是素数\n",m); 
	else 
		printf("%d 不是素数\n",m); 
	*/
}