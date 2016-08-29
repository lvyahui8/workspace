// chapter8.cpp : Defines the entry point for the console application.
//

#include "stdafx.h"
//void printstar();
//void print_message();

/*int a()
{
	int i=1;
	return i;
}
*/
int f(int a);
int main(int argc, char* argv[])
{
	
	//printstar();
	//print_message();
	//printstar();
	//for(int i=1;i<=10;i++)  printf("%x\n",&i);
	int a=2,i;
	for(i=0;i<=3;i++) printf("%d\n",f(a));
	
	return 0;
}

int f(int a)
{
	auto int b=0;
	static int c=3;

	b=b+1;
	c+=1;
	//for(int i=1;i<=10;i++) printf("%x %x\n",&b,&c);
	return (a+b+c);
}

