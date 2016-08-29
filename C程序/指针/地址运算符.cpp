
#include "stdafx.h"

int main(int argc, char* argv[])
{
	int a=1;
	int *pointer_1=&a;

	printf("%x\n",&a);

	printf("&a=%x\n",&*pointer_1);

	printf("a=%d\n",*&a);

	printf("a++=%d\n",(*pointer_1)++);

	return 0;
}