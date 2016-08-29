#include <stdafx.h>
void sort(int b[],int n);
void main()
{
	int a[5]={3,6,1,2,9};
	sort(a,5);
	for(int i=0;i<5;i++)
		printf("%d ",a[i]);
	printf("\n");
}
void sort(int b[],int n)
{
	int p;
	for(int i=0; i<n-1; i++)
	{
		p=i;
		for(int j=i+1;j<n;j++)
		{
			if(b[j]<b[p])
				p=j;
		}
		int t;
		t=b[i];
		b[i]=b[p];
		b[p]=t;
	}
}