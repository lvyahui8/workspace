#include <stdafx.h>

void hw(int x);

void main()
{
	int j,sum=0;// j 循环变量 
	
	for(j=1;j<=10000;j++)
	{
		i=0;//每循环一次对i复位为0
		hw(j);//把j 倒序后存到 i 里
		if(i==j)//如果是回文数 将它加到总和里
			sum+=j;
	}

	printf("1+...+9999(回文数)=%d\n",sum);

}

void hw(int n)
{
	
	static int i=0;
	if( n != 0 )	
	{		
		i=i*10+n%10;		
		hw(n/10);	
	}
}