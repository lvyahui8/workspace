#include <stdafx.h>

#define PI 3.1415926
#define S(r) PI*r*r //��Ҫ�пո���S (r) PI*r*r���ַ�������(r) PI*r*r

void main()
{
	float a,b,area;
	a=3.6;
	b=2.4;
	area=S(a+b);//Ԥ����ֻ���򵥵��ַ��滻���õ��Ľ����PI*a+b*a+b,���Ƕ���ʱ��PI*(r)*(r)
	printf("r=%12f\narea=%12f\n",a,area);
}