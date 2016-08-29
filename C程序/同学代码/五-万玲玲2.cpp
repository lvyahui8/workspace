#include<stdafx.h>
int main()
{
	int a,s=0,i=0,b=0,sum=0;
	for(i=0;i<=10000;i++)
	{
		s=i; 
		b=0;

		while(s!=0)
		{
			a=s%10;
			b=b*10+a;
			s/=10;
		}
            if(b==i)
			{
				sum=sum+b;
			}
			s=0;	
	}	
	printf("sum=%d\n",sum);
	return 0;
}

