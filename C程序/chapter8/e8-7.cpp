#include <stdafx.h> 
int age(int);
void main()
{	
	printf("%d\n",age(5));	
}
//������ֱ�ӵݹ����
//return age(1) +(n-1)*2
int age(int n)
{
	if(n==1)
		return 10;
	else
		return age(n-1)+2;
}