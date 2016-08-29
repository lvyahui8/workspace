#include <stdafx.h>
#include <string.h>

void sort(char * name[],int n);
void print(char * name[],int n);

void main()
{
	char * name[]={"Follow me","BASIC",
		"Great Wall","FORTRAN","Computer"};
	
	sort(name,5);

	print(name,5);
}

void sort(char * name[],int n)
{
	int i,j;
	int p;
	char * temp;
	for(i=0;i<n-1;i++)
	{
		p=i;
		for(j=i+1;j<n;j++)
		{
			if( strcmp(name[j],name[p]) < 0)
			{
				p=j;
			}
		}
		if(p != i)
		{
			temp=name[i];
			name[i]=name[p];
			name[p]=temp;
		}
	}
}

void print(char * name[],int n)
{
	int i;
	for(i=0;i<n;i++)
		printf("%s\n",name[i]);
}
