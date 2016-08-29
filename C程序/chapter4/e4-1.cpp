#include "stdafx.h"

int main(int argc, char* argv[])
{
	char a,b,c;
	int ia,ib,ic;
	a='B';
	b='O';
	c='Y';
	ia=putchar(a);
	putchar('\n');
	ib=putchar(b);
	putchar('\n');
	ic=putchar(c);
	putchar('\n');
	printf("%d %d %d\n",ia,ib,ic);
	return 0;
}