#include <stdafx.h>

double power(double x,int n);

void main()
{
	int a,b,sum=0;
	scanf("%d %d",&a,&b);
	a=a*(power(10,b)-1)/9;// ����������
	printf("sum=");
	while(a!=0)
	{
		printf("%d+",a);
		sum=sum+a;
		a=a/10;// ѭ��һ�ζ���һλ
	}
	
	printf("\b=%d\n",sum);

}

double power(double x,int n)
{
	if(n==0) return 0;
	double j=x;
	int i;

	for(i=1;i<n;i++)
	{
		x=x*j;
	}
	return x;
}
