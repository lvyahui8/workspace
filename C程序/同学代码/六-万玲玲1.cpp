#include <stdafx.h>
int main()
{
	int a,b,i,temp,sum=0;
	// a=首项 b=项数 i=循环变量 temp=项 sum=总和

	scanf("%d %d",&a,&b);
	temp=a;
	for(i=1;i<=b;i++)
	{
		sum+=temp;
		temp=temp*10+a;
		
	}
	printf("sum=%d\n",sum);
	return 0;
}
