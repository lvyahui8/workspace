#include <stdafx.h>

int hw(int x)
{
	int z=0,temp;
	temp=x;//循环中改变形参x的值，所以先把x的值赋给temp，留着跟回文数比较
	// 求倒序数
	while( x != 0 )
	{
		z=z*10+x%10;//每循环一次，把z的每位抬高一位，个位放x mod 10的值
		x=x/10;		//每循环一次，把x的最低位丢掉
	}
	//判断是不是回文数
	if( z == temp )	
		return temp;
	else	
		return 0;
}

void main()
{
	int i,sum=0; 
	for(i=1;i<=10000;i++)
	{
		sum+=hw(i);
	}
	printf("1+...+9999(回文数)=%d\n",sum);
}

