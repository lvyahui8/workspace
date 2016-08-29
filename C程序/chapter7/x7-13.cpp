#include <stdafx.h>

void main()
{
	char str1[]="hello";
	char str2[]="world!";
	char str3[20]={0};
	int i=0,k=0;
	while(str1[i] != '\0')
	{
		str3[k]=str1[i];
		i++;
		k++;
	}
	str3[k]=' ';
	i=0;
	k++;
	while(str2[i] != '\0')
	{
		str3[k]=str2[i];
		i++;
		k++;
	}
	printf("%s\n",str3);
}