#include <stdafx.h>
#include <stdlib.h>
#include <math.h>
//两个自定义函数，第一个求面积，第二个求角度
float area(float x,float y,float z);
float arccos(float x,float y,float z);	
void main()
{	
	int i;
	float a,b,c;
	//用来存边
	printf("依次输入三边，留空格\n");
	scanf("%f %f %f",&a,&b,&c);	//将用户输入的三边存到a,b,c里
	if(a+b>c && a+c>b && b+c>a)	//判断是否构成三角形，是则计算面积，不是则打印错误信息
	{
		printf("a=%-9.3f米\tb=%-9.3f米\tc=%-9.3f米\narea=%-9.3f平方米\n",a,b,c,area(a,b,c));	//打印三边及面积
		printf("A=%-8.6frad\tB=%-8.6frad\tC=%-8.6frad\n",arccos(b,c,a),arccos(c,a,b),arccos(a,b,c));	//打印角度
	}
	else
	{
		printf("不能构成三角形\n");
	}
	//下面代码的作用是让程序能计算多次
	printf("按1回车继续:");
	scanf("%d",&i);
	if(1==i) 
	{
		system("cls");
		main();
	}
}

float area(float x, float y,float z)
{
	

	float sum;
	sum=(x+y+z)/2;
	return sqrt(sum*(sum-x)*(sum-y)*(sum-z));
}

float arccos(float x,float y,float z)
{
	return acos((x*x+y*y-z*z)/(2*x*y));
}

/*程序运行结果
依次输入三边，留空格
3 4 5
a=3.000    米   b=4.000    米   c=5.000    米
area=6.000    平方米
A=0.643501rad   B=0.927295rad   C=1.570796rad
按1回车继续:
*/