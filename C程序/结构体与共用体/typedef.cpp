#include <stdafx.h>
// typedef用来给数据类型换名字
// 与 #include I int  有区别
typedef int I;  // 把 int 换成 I
typedef float F;

typedef struct data // 把data 换成 DATA
{
	I month;
	I day;
	I year;
} DATA;
typedef int ARR[10];  // ARR在下面用来定义10个元素的一维整型数组
typedef char * STR;//STR
typedef int (*P)(int ,float);//P

void main()
{
	I i,j;
	F a,b;
	DATA bir;//struct data nir
	ARR arr;// int arr[10];

	for(i=0;i<=9;i++)
	{
		arr[i]=i;
	}
	STR po;
	P p;
}