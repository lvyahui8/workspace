#include <stdafx.h>

void main()
{
	char s1[20]={0};
	char s2[5]="abcd";
	for(int i=0;i<=4;i++)
	{
		s1[i]=s2[i];
	}
	printf("%s\n",s1);
	
}