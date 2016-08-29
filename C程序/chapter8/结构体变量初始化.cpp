#include <stdafx.h>

void main()
{
	struct student
	{
		long int num;
		char name[20];
		char sex;
		char addr[20];
	} a={20120102,"Lv Yahui",'M',"Hu Nan"};

	printf("%d %s %c %s\n",a.num,a.name,a.sex,a.addr);
}