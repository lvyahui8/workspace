/*
*	采用牛顿莱布尼茨公式，运算速度快，但通用性低
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

double fun1(double x,double y){
	// 被积函数: 1+x
	return (y+y*y/2)-(x+x*x/2);
}
double fun2(double x,double y){
	// 被积函数: 2*x+3
	return (y*y+3*y)-(x*x+3*x);
}
double fun3(double x,double y){
	// 被积函数: E^x+1
	return (pow(E,y)+y)-(pow(E,x)+x);
}
double fun4(double x,double y){
	// 被积函数: (1+x)^2
	return (pow(1+y,3)-pow(1+x,3))/3;
}
double fun5(double x,double y){
	// 被积函数: x^3
	return (pow(y,4)-pow(x,4))/4;
}
double integral(double a,double b,double (*fun)(double,double)){
	return (*fun)(a,b);
}

void main(){
	double  a,b;
	printf("积分下限:");
	scanf("%lf",&a);
	printf("积分上限:");
	scanf("%lf",&b);
	printf("fun1==%lf\n",integral(a,b,fun1));
	printf("fun2==%lf\n",integral(a,b,fun2));
	printf("fun3==%lf\n",integral(a,b,fun3));
	printf("fun4==%lf\n",integral(a,b,fun4));
	printf("fun5==%lf\n",integral(a,b,fun5));
	getchar();
}