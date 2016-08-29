#include <stdafx.h>
#include <math.h>
#include <stdlib.h>
//#include <stdlib.h>
float qarea(float x,float y,float z);
int main()
{	
	system("color 2f");
	int i=1;
		do
	{
	float a,b,c;
	printf("请输入三角形三边：\n");
	scanf("%f%f%f",&a,&b,&c);	
	printf("%f\n",qarea(a,b,c));
	system("title 三角形面积计算程序 & pause  ");
	system("cls");
	i++;
	}
	while(i<=999);
	   
			return 0;


}

float qarea(float x,float y,float z)
{
	float s;
	s=(x+y+z)/2;// &&  || !
	if(x+y>z && y+z>x && x+z>y)
		return sqrt(s*(s-x)*(s-y)*(s-z));
	

	else 
		printf("此三边构不成三角形\n");
		return 0;
}
