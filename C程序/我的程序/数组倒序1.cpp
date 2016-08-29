/*
需求：将一个由有限个数组成的数列倒序

思路：
1.输入，并记录输入数的个数
2.倒序，根据个数将输入的数倒序
3.输出，根据个数将倒序排好的数列输出
*/
#include <stdafx.h>
#define LENGTH 100
//需要两个整型变量地址
void swap(int * x,int * y)
{
	int temp;
	temp=*x;
	*x=*y;
	*y=temp;
}

void inversion(int * i_array,int length)
{
	//数组倒序，length指明数的个数
	int i;
	for(i=0,length--;length>i;i++,length--)
	{
		swap(&i_array[i],&i_array[length]);
	}
}

void main()
{
	int array[LENGTH];
	int i,p;
	char ch;
	printf("The input array:\n");

	for(i=0;i<LENGTH && ch!='\n';i++)
	{
		scanf("%d",&array[i]);
		ch=getchar();
	}
	p=i;  //将循环记录的个数赋值给p保存
	inversion(array,p);

	printf("The output array:\n");

	for(i=0;i<p;i++)
		printf("%d ",array[i]);

	putchar('\n');
}