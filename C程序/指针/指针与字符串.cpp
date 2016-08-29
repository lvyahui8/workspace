#include <stdafx.h>

void main()
{
	//char string[]="Hello Wrorld!";
	//    数组名虽然是地址，但它是地址常量，不是地址变量（指针）
	//char * string="I love China!";
	//printf("%s\n",string);

	char a[]="I am a boy.",b[20];
	int i;	
	char * p,* q;

	for(i=0;*(a+i) != '\0';i++)
	{
		*(b+i) = *(a+i);
		//*(a+i)==a[i]  *(b+i)==b[i]
	}
	*(b+i)='\0';
	//printf("%s\n",b);
	for(i=0;b[i]!='\0';i++)
		printf("%c",b[i]);
	printf("\n");

	
	for(p=a,q=b;*p != '\0';p++,q++)
		*q=*p;
	q=b;
	printf("%s\n",q);

}