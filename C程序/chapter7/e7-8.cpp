#include <stdafx.h>

void main()
{
	char c[100];
	gets(c);
	int counter=1;
	for(int i=0;c[i]!='\0';i++)
		if(c[i]==' ')
		counter++;
	printf("%d\n",counter);
}
