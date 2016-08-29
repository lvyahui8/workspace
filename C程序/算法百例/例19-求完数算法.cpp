#include <stdafx.h>

int ws(int n);

void main()
{
	/*
		一个数如果恰好等于它的因子之和，
		这个数就称为"完数"。例如
		6=1+2＋3 
		28=1＋2＋4＋7＋14 
		496=1+2+4+8＋16+31+62＋124 
		8128=1＋2＋4+8＋16＋32+64＋127+254＋508+1016＋2032+4064 


		从1开始到4000万所包括的正整数里：
		只有七个：6 ， 28， 496 ，8128 ，130816 ，2096128，33550336 。 
		直到到2003年，人们才发现共37个。 
		而从第四个完全数到第七个 经过了1000多年，可见其难度… 
	*/
	
	int i;
	for(i=1;i<=1000;i++)
	{
		if(1==ws(i))
		{
			printf("%6d",i);
		}
	}
	printf("\n");
}

int ws(int k)
{
	int sum=0,j;
	for(j=1;j<k;j++)
		if(k%j==0)
			sum=sum+j;
	if(sum==k) return 1;
	else return 0;
} 


/*
void main()
{
	int sum,k,j;
	sum=0;
	for(k=2;k<=1000;k++)
	{
		sum=0;
		for(j=1;j<k;j++)
			if(k%j==0)
				sum=sum+j;
		if(sum==k)
			printf("%5d",k); 
	}
}
*/