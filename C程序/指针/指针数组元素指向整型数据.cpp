#include <stdafx.h>

void main()
{
	int a[5]={1,2,3,4,5};
	int * num[5]={&a[0],&a[1],&a[2],&a[3],&a[4]};
	int i;
	int * * p;
	p=num;
	for(i=0;i<5;i++)
	{
		printf("%d ",**p);
		p++;
	}
	printf("\n");
}