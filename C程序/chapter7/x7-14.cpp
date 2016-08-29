#include <stdafx.h>

void main()
{
	char s1[20],s2[20];
	gets(s1);
	gets(s2);
	for(int i=0;i<=19;i++)
	{
		if(s1[i]==s2[i])
		{
			printf("0\n");
			break;
		}
		if(s1[i]>s2[i])
		{
			printf("%d\n",s1[i]-s2[i]);
			break;
		}
		else
		{
			printf("%d\n",s1[i]-s2[i]);
			break;
		}
	}
}