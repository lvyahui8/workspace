#include <stdafx.h>

void main()
{
	int a[5]={0,1,2,3,4};
	int * p;
	p=a;
	printf("%x\n",p);
	p++;
	printf("%x\n",p);
	p=NULL;
	printf("%x\n",p);
}