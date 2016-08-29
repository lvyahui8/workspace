#include <stdafx.h>

void main()
{
	/*
	*题目：求s=a+aa+aaa+aaaa+aa...a的值，其中a是一个数字。例如2+22+222+2222+22222
	*/
	int a,n,count=1; 
	long int sn=0,tn=0; 
	printf("please input a and n\n"); 
	scanf("%d %d",&a,&n); 
	printf("a=%d,n=%d\n",a,n); 
	while(count<=n) 
	{ 
		tn=tn+a; 
		sn=sn+tn; 
		a=a*10; 
		++count; 
	} 
	printf("a+aa+...=%ld\n",sn); 


}