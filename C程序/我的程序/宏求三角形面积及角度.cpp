#include <stdafx.h>
//定义带参数的宏
//第一个宏用来求面积
#define QAREA(A,B,C,SUM,AREA) SUM=(A+B+C)/2;AREA=sqrt(SUM*(SUM-A)*(SUM-B)*(SUM-C));
//第二个宏用来求角度
#define ARCCOS(X,Y,Z,CA,CB,CC) CC=acos((X*X+Y*Y-Z*Z)/(2*X*Y));CA=acos((Z*Z+Y*Y-X*X)/(2*Z*Y));CB=acos((Z*Z+X*X-Y*Y)/(2*Z*X));
void main()
{
	int i;
	float a,b,c,sum,area;		//用来存边，周长一半，及面积
	float ca,cb,cc;				//用来存角度
	printf("依次输入三边，留空格\n");
	scanf("%f %f %f",&a,&b,&c);	//将用户输入的三边存到a,b,c里
	if(a+b>c && a+c>b && b+c>a)	//判断是否构成三角形，是则计算面积，不是则打印错误信息
	{
		QAREA(a,b,c,sum,area);	//使用宏计算面积
		ARCCOS(a,b,c,ca,cb,cc);	//使用宏计算角度
		printf("  12345678901234567890\n");
		printf("a=%-9.3f米\tb=%-9.3f米\tc=%-9.3f米\narea=%-9.5f平方米\n",a,b,c,area);	//打印三边及面积
		printf("A=%-8.6frad\tB=%-8.6frad\tC=%-8.6frad\n",ca,cb,cc);						//打印角度
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

/*程序运行结果
依次输入三边，留空格
3 4 5
a=3.000    米   b=4.000    米   c=5.000    米
area=6.000    平方米
A=0.643501rad   B=0.927295rad   C=1.570796rad
按1回车继续:
*/