#include <stdafx.h>

void main()
{
	int a[3][4]={1,2,3,4,5,6,7,8};
	int max=a[0][0],row=0,column=0;
	for(int i=0;i<=2;i++)
	{
		for(int j=0;j<=3;j++)
		{
			if(a[i][j])
			{
				max=a[i][j];
				row=i;
				column=j;
			}
		}
	}
	printf("%d %d %d\n",max,row,column);
}


