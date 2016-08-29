#include <stdafx.h>
	// 需要数组名和元素个数两个参数，适合一维数组
void qipao(int a[],int n)
{
	for(int i=0;i<n-1;i++)
	{
		for(int j=0;j<n-1-i;j++)
		{
			//a[j+1]= a[j]>a[j+1] ? a[j] : a[j+1];
			if(a[j]>a[j+1])
			{
				int t;
				t=a[j];
				a[j]=a[j+1];
				a[j+1]=t;
			}
		}
	}
}
