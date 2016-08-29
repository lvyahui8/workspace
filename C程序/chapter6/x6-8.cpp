#include <stdafx.h>

void main()
{
	int fenzi=2,fenmu=1,zhong=0;
	double sum=0;
	for(int i=1;i<=20;i++)
	{
		printf("%d->%d/%d\n",i,fenzi,fenmu);
		sum=sum+(float)fenzi/fenmu;
		zhong=fenzi;
		fenzi=fenzi+fenmu;
		fenmu=zhong;		
	}
	printf("%lf\n",sum);

}