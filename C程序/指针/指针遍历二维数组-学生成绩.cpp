#include <stdafx.h>

void search(float (*p)[4],int n);
float average(float * p,int n);

void main()
{
	float score[3][4]={{45,67,68,76},{70,80,60,82},{55,66,77,88}};

	printf("average=%g\n",average(*score,12));// *score==score[0]
	
	search(score,2);
}


float average(float * p,int n)
{
	float * start;
	float sum=0.0;
	for(start=p; p<=start+n-1 ; p++)
	{
		sum+=*p;		
	}

	return sum/n;
}

void search(float (*p)[4],int n)
{
	for(int i=0;i<4;i++)
	{
		printf("%g\n",*(*(p+n)+i));
	}
	printf("\n");
}