#include <stdafx.h>
#include <string.h>
void main()
{
	int a[3][3]={1,2,3,4,5,6,7,8,9};
	/*1 2 3
	  4 5 6
	  7 8 9*/
	int sum=0;
	for(int i=0;i<=2;i++)
		sum+=a[i][i];
	printf("%d\n",sum);
}