	#include <stdafx.h>

	void main()
	{
		int a[6]={8, 4, 5, 9, 2, 0};
		for(int i=0;i<6-1;i++)
		{
			int swap = 0;
			for(int j=0;j<6-i;j++)
			{
				//a[j+1]= a[j]>a[j+1] ? a[j] : a[j+1];
				if(a[j]>a[j+1])
				{
					int t;
					t=a[j];
					a[j]=a[j+1];
					a[j+1]=t;
					swap = 1;
				}
			}
			if(0 == swap) break;
		}
		for(int k=0;k<=5;k++)
			printf("%d ",a[k]);
		printf("\n");
	}