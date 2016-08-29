
#include "stdafx.h"

int main(int argc, char* argv[])
{
	/*
	*  s=a+aa+aaa+aaaa+.....+a(n);
	*	f1:
	*/
	int a,b,i,sum=0,temp=0;
	scanf("%d %d",&a,&b);//a==2 b==3  sum==2+22+222==246
	printf("sum=");
	for(i=1;i<=b;i++)
	{
		temp=temp*10+a;	//构造下一项
		sum=sum+temp;
		printf("%d+",temp);
	}
	printf("\b=%d\n",sum);


	
	return 0;
}

