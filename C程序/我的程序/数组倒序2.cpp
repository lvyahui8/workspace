/*
需求：将一个由有限个数组成的数列倒序

思路：
1.输入，并记录输入数的个数
2.倒序，根据个数将输入的数倒序
3.输出，根据个数将倒序排好的数列输出
*/

#include <stdafx.h>
#define LENGTH 100

int input(int * i_array,int length)
{	// 输入，length指明数组长度
	int i;
	char ch;
	printf("The input array:\n");
	for(i=0;i<length && ch!='\n';i++)
	{
		scanf("%d",&i_array[i]);
		ch=getchar();
	}
	return i;// 返回用户输入数的个数
}

void swap(int * x,int * y)
{   //需要两个整型变量地址,可以交换变量值
	int temp;
	temp=*x;
	*x=*y;
	*y=temp;
}

void inversion(int * i_array,int length)
{	//数组倒序，length指明数的个数
	int i;
	for(i=0,length--;length>i;i++,length--)
	{
		swap(&i_array[i],&i_array[length]);
	}
}

void output(int * i_array,int length) 
{	//输出数组，length指明数的个数
	int i;
	printf("The output array:\n");
	for(i=0;i<length;i++)
		printf("%d ",i_array[i]);
	putchar('\n');
}

void void_fuc(int * i_array,int length,void (*p)(int * m,int))
{
	p(i_array,length);// p为指向函数的指针  
	//例如传值时形参为output，则p==output,表达式就变成了output(i_array,length);
}

int int_fuc(int * i_array,int length,int (*p)(int * m,int))
{
	return p(i_array,length);
}

void main()
{
	int array[LENGTH];
	int p;

	p=int_fuc(array,LENGTH,input);
	void_fuc(array,p,inversion);
	void_fuc(array,p,output);
}