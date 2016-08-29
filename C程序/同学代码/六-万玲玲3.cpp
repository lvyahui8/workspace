#include<stdafx.h>
#include<math.h>
int main()
{
	double  x,i=1,temp=0, n,sum=0; 
    scanf("%lf %lf",&x,&n);
	do	
	{
         temp=x*pow(10,i-1)+temp;
		 sum+=temp;
		 i++;
	}
    while(i<=n);
           
	printf("sum=%lf\n",sum);
	
	
	    return 0;
} 