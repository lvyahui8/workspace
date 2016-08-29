#include "stdafx.h"
#include <string.h>
void px(char *x[10]);
int main(int argc, char* argv[])
{
	int i=0;
	char *a[10];
	for(;i<10;i++)
		scanf("%s",a[i]);
	px(a);
	printf("please output the sorted name:\n");
    char *p;
	p=a[0];
	while(i<10)
	{
		p=*(a+i++);
		printf("%s\n",p);
	}
	return 0;
}

void px(char *x[10])
{
	int i,j,k;
	char *temp;
	for(i=0;i<9;i++)
	{k=i;
	for(j=i+1;j<10;j++)
		if(strcmp(x[k],x[j])>0)
			k=j;
	if(k!=i)
		{temp=x[i];x[i]=x[k];x[k]=temp;}
		
	}
}
