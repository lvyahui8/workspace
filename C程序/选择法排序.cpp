#include <stdafx.h>

// 需要数组名和元素个数两个参数，适合一维数组
void sort(int a[],int n)
{
	int p;
	for(int i=0;i<n-1;i++)
	{
		p=i;
		for(int j=i+1;j<n;j++)
		{
			if(a[j]<a[p])
				p=j;
		}
		int t;
		t=a[i];
		a[i]=a[p];
		a[p]=t;
	}
}