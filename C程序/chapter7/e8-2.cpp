#include <stdafx.h>

int max(int x,int y)
{
	//等价 return x>y ? x : y;
	int z;
	z =x>y ? x : y;
	return z;
	
	//形参的改变不会引起实参的改变；
	//函数未被调用时，形参并不分配内存单元
	x++;
	y++;
}
void main()
{
	int a,b,c;
	scanf("%d %d",&a,&b);
	c=max(a,b); 
	printf("%d %d\n",a,b);
	printf("max = %d\n",c);
}
