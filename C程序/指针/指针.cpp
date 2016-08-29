#include "stdafx.h"

int main(int argc, char* argv[])
{
	//int i=1,j=2;
	//int *i_pointer,*j_pointer;
	///i_pointer=&i;
	//j_pointer=&j;	

	/*
	printf("%d\n",i);
	printf("%d\n",j);
	printf("%x\n",&i);
	printf("%x\n",&j);
	*/

	//printf("%dbyte\n",sizeof(i_pointer));

	//i=5;j=6;
	//printf("i=%d  j=%d\n",*i_pointer,*j_pointer);
	
	//char str[]="dengjie";//地址常量
	char * str="dengjie";//地址变量
	str++;
	printf("%s\n",str);
	return 0;
}
