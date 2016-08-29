#include <stdafx.h>


void main()
{
	int z,temp;
	int i,sum=0; 

	for(i=1;i<=10000;i++)
	{
		z=0;	//每次循环会改变z的值，所以要重新调整为0
		temp=i; //操作中不能改变i的值，所以先把i的值赋给temp，对temp进行操作
		// 求倒序数
		while( temp != 0 )
		{
			z=z*10+temp%10;	//每循环一次，把z每位抬高一位，个位放temp mod 10的值
			temp=temp/10;	//每循环一次，把temp的最低位丢掉
		}
		//判断是不是回文数
		if(i==z)
		{
			sum=sum+z;
		}
	}
	printf("1+...+9999(回文数)=%d\n",sum);
}
