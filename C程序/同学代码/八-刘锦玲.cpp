#include<stdafx.h>

void f(int n);

int main()
{	
	
	int hw=0,n;
	scanf("%d",&n);
	if(n<0)
	{
		printf("error");
	}
	else
	{
		if(0==n)
		{ 
			return hw=0;
		}
		else
		{
			return hw=(hw*10)+f(n%10);
		}
	}
}

int f(int n)
{
	int n,s;
	scanf("%d",&n);

	if(n!=0)
	{
		s=n%10;
		n=n/10;
	}
	f(n%10);
	return s;
}
