#include <stdafx.h>

void main()
{
	int a[3][4]={0,1,2,3,4,5,6,7,8,9,10,11};

	int * a_p;

	for(a_p=a[0];a_p<=a[0]+11;a_p++)
	{
		if( (a_p-a[0])  % 4 == 0 )
		{
			printf("\n");
		}
		printf("%d ",*a_p);
	}
	printf("\n");
}