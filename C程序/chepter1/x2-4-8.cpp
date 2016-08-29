
#include "stdafx.h" /*声明头文件stafx.h*/
#include "math.h"   /*声明头文件math.h*/
int main(int argc, char* argv[])  /*定义主函数main*/
{
	float a,b,c,disc;       /*定义四个单精度浮点数*/
	scanf("a=%f b=%f c=%f",&a,&b,&c);   /*用户输入变量值，格式为"a= b= c= "*/
    disc=b*b-4*a*c;    /*根据用户提供的参数求的disc的值*/
	if(disc>0)    /*判断disc的值是否大于0，是则执行该函数，否则不执行*/
	{
		printf("x1=%f和x2=%f是方程的两个实根",(-b+sqrt(disc))/(2*a),(-b-sqrt(disc))/(2*a));   /*按格式"x1= 和x2= 是方程的两个实根"输出两实根的值*/
	}
	if(disc=0)   /*判断disc的值是否等于0，是则执行该函数，否则不执行*/
	{
		printf("x=%f是方程唯一实根",-b/(2*a));    /*按格式"x=%f是方程唯一实根"输出两实根的值*/
	}
	if(disc<=0)       /*判断disc的值是否小于0，是则执行该函数，否则不执行*/
	{
		printf("方程没有实根！");   /*输出"方程没有实根！"*/
	}
	return 0;  /*返回数值*/
}