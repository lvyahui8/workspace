#include <stdafx.h>
int main()
{
	int a,b,i,temp,sum=0;
	// a=���� b=���� i=ѭ������ temp=�� sum=�ܺ�

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
