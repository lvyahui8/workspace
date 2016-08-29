#include <stdafx.h>
#include <stdlib.h>
char * mynew(int n)
{
	char * p;
	p=(char *)malloc(n);
	return p;
}
void main()
{
	char *head=mynew(20);
	for(int i=0;i<20;i++)
	{
		head[i]='a'+i;
		printf("%c ",head[i]);
	}
	free(head);
}