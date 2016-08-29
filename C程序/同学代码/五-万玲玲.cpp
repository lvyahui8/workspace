#include <stdafx.h>

int hw(int x);

int main()
{
	int i,sum=0;
	for(i=1;i<=10000;i++)
	{
		if(hw(i)==1)
			sum+=i;
	}
			
	printf("sum=%d\n",sum);
	
	return 0;	
}

int hw(int x)
{
	int a=0,flag=0,temp;
	temp=x;
	do
	{
		a=a*10+x%10;
		x=x/10;
	}
	while(x!=0);
	if(temp==a)
		flag=1;
	return flag;
}