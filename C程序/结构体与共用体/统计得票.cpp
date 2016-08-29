#include "stdafx.h"
#include <string.h>
struct person
{
	char name[20];
	int count;

};
void main()
{
	struct person leader[3]={
		{"Li",0},
		{"Zhang",0},
		{"Fun",0}};
	int i,j;
	char name[20];
	for(i=0;i<10;i++)
	{
		scanf("%s",name);
		for(j=0;j<3;j++)
		{
			if(strcmp(name,leader[j].name)==0)
				leader[j].count++;
		}
	}

	for(i=0;i<3;i++)
	{
		printf("name:%s\n",leader[i].name);
		printf("count:%d\n",leader[i].count);
	}
}