#include "stdafx.h"
#define PI 3.1415926

void main()
{
	float r;
	double l,v,s;
	printf("input radius :");
	scanf("%f",&r);
	l=2*PI*r;
	//#undef PI  //结束宏PI的作用域
	s=PI*r*r;
	v=4.0/3.0*PI*r*r*r;
	printf("I=%10.4lf\ns=%10.4lf\nv=%10.4lf\n",l,s,v);
}