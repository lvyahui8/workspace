#include <stdafx.h>
#include <string.h>
void main()
{
	char max[20];
	char str[3][20];
	for(int i=0;i<=2;i++)
		gets(str[i]);
	if(strcmp(str[0],str[1])>0)	
		strcpy(max,str[0]);
	else
		strcpy(max,str[1]);
	if(strcmp(max,str[2])<0)
		strcpy(max,str[2]);
	puts(max);
}