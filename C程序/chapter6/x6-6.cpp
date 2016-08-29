#include <stdafx.h>

void main()
{
	/*输出所有“水仙花数”，所谓“水仙花数”
	是指一个各位数字立方和等于该数本身的三
	位数。例如，153是一个水仙花数，因为
	     153=1^3+5^3+3^3                */
	
	int a1=0,a2=0,a3=0,sum=0;
	for(int i=111;i<=999;i++)
	{
		a1=i/100;
		a2=i/10-a1*10;
		a3=i-a1*100-a2*10;
		//printf("%d %d %d\n",a1,a2,a3);
		sum=a1*a1*a1+a2*a2*a2+a3*a3*a3;
		if(sum==i)
			printf("%d\n",i);
	}
}

