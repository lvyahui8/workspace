#include<stdafx.h>
#include<math.h>
int main()
{
	int  x,n,a=0,sum=0,i;
    scanf("%d %d",&x,&n);
	for(i=1;i<=n;i++)
	{
		a=x * ((pow(10,i)-1)/9);
		sum=sum+a;
	}
	printf("sum=%d\n",sum);
    return 0;
} 