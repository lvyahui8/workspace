/*	
*	采用微分极限思想，通用性高，但运算速度低
*	当  n==9999999  时得到以下值，与用牛顿布莱尼茨公式所得结果一样
*	积分下限:2
*	积分上限:3
*	fun1==3.500000
*	fun2==8.000000
*	fun3==13.696481
*	fun4==12.333333
*	fun5==16.250000
*/
#include "stdafx.h"
#include <math.h>
#define E 2.7182818284  // 自然常量e

double f1(double x){
	// 被积函数: 1+x
	return x+1;
}
double f2(double x){
	// 被积函数: 2*x+3
	return 2*x+3;
}
double f3(double x){
	// 被积函数: E^x+1
	return pow(E,x)+1;
}
double f4(double x){
	// 被积函数: (1+x)^2
	return (1+x)*(1+x);
}
double f5(double x){
	// 被积函数: x^3
	return x*x*x;
}

long double integral(double a,double b,double (*fun)(double)){
	long double i,unit,sum=0.0;
							//  1844674407370955161
	unsigned long double n; //  1844674407370955300.000000
//	long double n;			//  1844674407370955300.000000
//	double n;				//  1844674407370955300.000000
//	printf("1234567890123456789\n");
	//n=999999999999999;
	n=9999999;	// 将整个曲边梯形等分成n份
	unit=(b-a)/n;	// 每一个小梯形的高
	for(i=a;i<b;i+=unit)
	{							//   每一个小梯形的面积
		sum = sum + ( ( (*fun)((double) i) + (*fun)((double)(i+unit)) ) * unit /2 );
	}
	return sum;
}

void main(){

	double  a,b;
	printf("积分下限:");
	scanf("%lf",&a);
	printf("积分上限:");
	scanf("%lf",&b);
	printf("fun1==%lf\n",integral(a,b,f1));
	printf("fun2==%lf\n",integral(a,b,f2));
	printf("fun3==%lf\n",integral(a,b,f3));
	printf("fun4==%lf\n",integral(a,b,f4));
	printf("fun5==%lf\n",integral(a,b,f5));
	getchar();
}
