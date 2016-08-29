#include "stdafx.h"
/*
void copy_string(char from[],char to[])
{
	int i=0;
	while(from[i] != '\0')
	{
		to[i]=from[i];
		i++;
	}
}
void copy_string(char * from,char * to)
{
	int i=0;
	while(from[i] != '\0')
	{
		to[i]=from[i];
		i++;
	}
}

void copy_string(char * from,char * to)
{
	int i=0;
	while(* (from+i) != '\0')
	{
		* (to+i)=* (from+i);
		i++;
	}
}

void copy_string(char * from,char * to)
{
	for(;*from != '\0';from++,to++)
		*to=*from;
	//*to='\0';
}
*/
void copy_string(char * from,char * to)
{
	while(*to++=*from++);
	//     '\0' µÄÖµÎª 0
}

void main()
{
	char a[]="I am teacher.";
	char b[]="You are student.";

	printf("string a=%s\nstring b=%s\n",a,b);

	printf("copy string a to string b:\n");
	copy_string(a,b);
	printf("string a=%s\nstring b=%s\n",a,b);

}
