#include<stdafx.h>

int huiwen(int x,int n);

int main()
{
	int n,x,y;
	printf("���������ֵ�λ��\n");
	scanf("x=%d",&x);
	printf("���һ����������\n");
	scanf("%d",&n);
	y=huiwen(n);
	if(n==y)
			printf("�����ǻ�����");
	else
			printf("�������ǻ�����");
	return 0;
}


int huiwen(int x,int n)
{
	int f,a,s=0;
	f=n;
	if(n<10)
	{
		printf("�����ǻ�����");
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
