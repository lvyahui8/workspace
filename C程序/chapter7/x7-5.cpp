#include <stdafx.h>
#include <string.h>
void main()
{
	int l=4;
	int a[]={8,6,5,4};
	for(int i=0;i<=(l-1)/2;i++)
	{
		int t;
		t=a[i];
		a[i]=a[l-1-i];
		a[l-1-i]=t;
	}
	for(i=0;i<=l-1;i++)
		printf("%d ",a[i]);
	printf("\n");
}