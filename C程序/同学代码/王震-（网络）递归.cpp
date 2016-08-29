#include<stdafx.h>

int h(int a);
int main()
{
	int a,b,sum;
	printf("请输入一个数");
	scanf("%d",&a);
	sum=a;
	b=h(a);

	if(sum==b)
		printf("这个数是回文数。\n");
	else
	{
		printf("这个数不是回文数。\n");
	}
	return 0;
}
int h(int a)
{
	int t,n;
	if(a<10)
		return a;
	else
	{
		
		n=h(a/10);
		t=n;
	    a=a%10;
		while(t>0)
		{
			a*=10;
			t/=10;
		}
		return n+a;
	}
}

