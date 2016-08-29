#include <stdafx.h>

void main()
{
	char * name[]={"Follow me","BASIC",
		"Great Wall","FORTRAN","Computer"};
	char * * p;
	int i;
	//p=name;
	// * p==
	//printf("%x\n",p);
/*
	for(i=0;i<5;i++)
	{
		p=name+i;
		printf("%s\n",*p);
	}
*/
	p=name+1;
	printf("%c\n",*(*p+1));// A
}