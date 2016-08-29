#include <stdafx.h>
//需要两个整型变量地址
void swap(int * x,int * y)
{
	int temp;
	temp=*x;
	*x=*y;
	*y=temp;
}
