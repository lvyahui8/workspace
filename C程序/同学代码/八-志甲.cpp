#include<stdafx.h>

int huiwen(int x,int n);

int main()
{
	int n,x,y;
	printf("请输入数字的位数\n");
	scanf("x=%d",&x);
	printf("请把一串数字输入\n");
	scanf("%d",&n);
	y=huiwen(n);
	if(n==y)
			printf("此数是回文数");
	else
			printf("此数不是回文数");
	return 0;
}


int huiwen(int x,int n)
{
	int f,a,s=0;
	f=n;
	if(n<10)
	{
		printf("此数是回文数");
	}
	else
	{
		if(x!=0)
		{
			if(f!=0)
			{
				a=f%10;
				s=s*10+a;
				f/=10;
				huiwen(x-1)=f;
			}
		}
	}
	return s;
	
	
}
