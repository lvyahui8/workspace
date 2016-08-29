#include <stdafx.h>
int fac(int n);
void main()
{
	for(int i=1; i<=5;i++)
		printf("%d\n",fac(i));

}
int fac(int n)
{
	//静态局部变量会保存函数上一次调用后的值
	//静态局部变量只会声明一次
	static int f=1;
	f=f*n;
	return f;
}