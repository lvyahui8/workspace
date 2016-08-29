#include<stdafx.h>
int main()
{
	int i=1,b=0,sum,s=0;i<=10000,i++;
	sum=b;
	do
	{
		s=0;
		i=sum%10;
		s=s*10+i;
		sum/=10;
	}
		while(sum!=0);
		if(s==b)
			sum+=b;
	
	printf("sum=%d\n",sum);
	return 0;
}
