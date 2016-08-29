#include <stdafx.h>

void main()
{
	//×÷ÓÃ£º¼ÆËãsum=a+aa+aaa+aaaa+...+n(a)
	int a,n;
	int term=0,sum=0;
	scanf("%d%d",&a,&n);
	for(int i=1;i<=n;i++)
	{
		term=term*10+a;
		printf("%d->%d\n",i,term);
		sum=sum+term;
	}
	printf("%d\n",sum);
}