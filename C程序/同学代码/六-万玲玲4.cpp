#include<stdafx.h>
#include<math.h>

int main()
{
	int  x,n,a,sum=0,i;
    scanf("%d %d",&x,&n);

	
    i=1;
	do
	{
			a=x*(pow(10,i)-1)/9;
			sum=sum+a;	
			i++;
	}
	while(i<=n);
	printf("sum=%d\n",sum);
    return 0;
} 