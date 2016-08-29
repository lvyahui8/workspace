#include <stdafx.h>
#include <stdlib.h>
#include <math.h>
float area(float x,float y,float z);
void main()
{
	float a,b,c;
	printf("输入边长\n");
	scanf("%f %f %f",&a,&b,&c);	
	if(a+b>c && a+c>b && b+c>a)
	{
		printf("area=%f\n",a,b,c,area);
	}
	else
	{
		printf("不能构成三角形!\n");
	}
}

float area(float x,float y,float z)
{
	float sum;
	sum=(x+y+z)/2;
	return sqrt(sum*(sum-x)*(sum-y)*(sum-z));
}
