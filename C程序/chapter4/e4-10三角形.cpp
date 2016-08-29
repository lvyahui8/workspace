#include "stdafx.h"
#include <math.h>

void main()
{
	int d;
	float a,b,c;
	double s,area;
	do
	{
		printf("根据用户提供的三角形三边边长计算面积\n");
		printf("请依次输入三边长度，中间用英文逗号隔开，并回车。\n");
		scanf("%f,%f,%f",&a,&b,&c);
		while(b+c<=a || a+c<=b || a+b<=c)
		{
			printf("不构成三角形!\n");
			printf("请依次输入三边长度，并回车。\n");
			scanf("%f%f%f",&a,&b,&c);
			
		}
		while(b-c>=a || a-c>=b || a-b>=c)
		{
			printf("不构成三角形!\n");
			printf("请依次输入三边长度，并回车。\n");
			scanf("%f%f%f",&a,&b,&c);	
		}
		s=(a+b+c)/2;
		area=sqrt(s*(s-a)*(s-b)*(s-c));
		printf("面积=%lg\n",area);	
		printf("按1回车继续\n");
		scanf("%d",&d);

	}while(d==1);
	
}//b+c<=a<b-c&& a+c<=b>a-c   a+b<=c>a-b