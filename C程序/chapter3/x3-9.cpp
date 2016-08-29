#include "stdafx.h" /*声明头文件stafx.h*/

int main(int argc, char* argv[])  /*定义主函数main*/
{
	float x=2.5,y=4.7;
	int a=7,b;
	printf("%lf\n",x+a%3*(int)(x+y)%2/4);
	a=2;
	b=3;
	x=3.5;
	y=2.5;
	printf("%lf\n",(float)(a+b)/2+(int)x%(int)y);
}