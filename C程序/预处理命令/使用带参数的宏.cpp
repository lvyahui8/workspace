#include <stdafx.h>

#define PI 3.1415926
#define S(r) PI*r*r //不要有空格，例S (r) PI*r*r，字符串成了(r) PI*r*r

void main()
{
	float a,b,area;
	a=3.6;
	b=2.4;
	area=S(a+b);//预处理只做简单的字符替换，得到的结果是PI*a+b*a+b,除非定义时用PI*(r)*(r)
	printf("r=%12f\narea=%12f\n",a,area);
}