#include <stdafx.h>

union data
{
	int i;
	char ch;
	float f;
};
void  main()
{
	union data a,b,c;
	printf("a==%x\n",&a);
	printf("b==%x\n",&b);
	printf("c==%x\n\n",&c);

	printf("&a.i==%x\n",&a.i);
	printf("&a.ch==%x\n",&a.ch);
	printf("&a.f==%x\n\n",&a.f);
	
	printf("执行运算\na.i=1;\na.f=2.0;\na.ch='a';\n\n");
	a.i=1;
	a.f=2.0;
	a.ch='a';
	printf("得到结果\n");
	printf("a.i==%d\n",a.i);
	printf("a.f==%f\n",a.f);
	printf("a.ch==%c\n",a.ch);

}