#include<stdafx.h>
#include<math.h>
int main()
{

	double x,n,sum=0;
    scanf("%lf %lf",&x,&n);

	sum=sum+(x*pow(x,n-1));
	if (n == 0) 
       return 1; 
    else  
      printf("sum=%f",sum);
	
	return 0;
} 
