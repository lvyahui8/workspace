#include "stdafx.h"

void main()
{
	struct student
	{
		long int num;
		char name[20];
		char sex;
		char addr[20];
	} a={41555,"LVyhau ",'M',"Beijing"};
	
	printf("a.num=%d",a.num);
}