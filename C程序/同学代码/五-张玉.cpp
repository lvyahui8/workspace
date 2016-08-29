//#include <stdafx.h>
#include <stdio.h>

int main()
{
    int a,x,sum=0,temp;
	for(x=1;x<=10000;x++)//for循环后面最好接花括号，吧循环体写在花括号里面。否则会默认为其后 ; 截止的一句做为循环体
	{
		a=0;	// a是用来存倒序数的，每次循环要复位为0
		temp=x;	// x是循环变量，如果直接用 x 来求倒序数，会使for变成死循环，所以用temp来求倒序数
		while(temp!=0)
		{
			a=a*10+temp%10;
			temp/=10;
		}
		if(x==a)
		{
			sum=sum+a;
		}	
	}
	printf("sum=%d\n",sum);
	return 0;
}
