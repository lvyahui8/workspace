#include <stdio.h>
#define MAXSIZE 10

int top1=-1,top2=MAXSIZE;
bool Push(int *s,int i,int x)
{
	if(0 == i)
	{
		s[++top1]=x;
		return 1;
	}
	else if(1 == i)
	{
		s[--top2]=x;
		return 1;
	}
	else
		return 0;
}
int Pop(int *s,int i)
{
	int p;
	if(0 == i)
	{
		p=top1--;
		return s[p];
	}
	else if(1 == i)
	{
		p=top2++;
		return s[p];
	}
	else
		return 0;
}
int top(int *s,int i)
{

	if(0 == i)
	{
		return s[top1];
	}
	else if(1==i)
	{
		return s[top2];
	}
	else
		return 0;
}
void main()
{
	int data[MAXSIZE];
	int i,j;
	Push(data,0,23);
	Push(data,0,34);
	Push(data,0,45);
	Push(data,1,2);
	Push(data,1,3);
	Push(data,1,4);
	for(i=0;i<MAXSIZE;i++)
		printf("Õ»¿Õ¼ä%d\n",data[i]);
	printf("È¡Õ»1¶¥:%d\n",top(data,0));
	printf("È¡Õ»2¶¥:%d\n",top(data,1));
	printf("³öÕ»1¶¥:%d\n",Pop(data,0));
	printf("³öÕ»2¶¥:%d\n",Pop(data,1));

}