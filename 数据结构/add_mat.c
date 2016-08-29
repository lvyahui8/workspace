/* 如果用三元组数组表示稀疏矩阵A、B，编写一个求解A+B的C语言函数，要求结果也为三元组表示*/

# include "stdio.h"
# define MAXN 100
void addmat(int a[][3],int b[][3],int c[][3])
{
	int m,n,topa,topb,topc,ta,tb,tc;
	m=a[0][0];n=a[0][1];ta=a[0][2];
	c[0][0]=m;c[0][1]=n;tb=b[0][2];
	topa=topb=topc=1;
	while(topa<=ta && topb<=tb)            /*当两个稀疏矩阵非0元素都未处理完时*/
	{ 
		if (a[topa][0]==b[topb][0])          /*行标等*/
			if (a[topa][1]==b[topb][1])      /*列标等*/
				if (a[topa][2]+b[topb][2]!=0) /*对应元素相加不为0 */
				{ 
					c[topc][0]=a[topa][0];c[topc][1]=a[topa][1];  /*产生新元素 */
					c[topc][2]=a[topa][2]+b[topb][2];
					topa++;topb++;topc++;     /*各指针后移 */
				}
				else
				{ 
					topa++;topb++;}           /*对应元素相加=0 ,两指针后移*/
				else if (a[topa][1]<=b[topb][1])    /*列标不等时判断将小的作为新元素加入 */
				{ 
					c[topc][0]=a[topa][0];c[topc][1]=a[topa][1];
					c[topc][2]=a[topa][2];
					topa++;topc++;
				}
				else
				{ 
					c[topc][0]=b[topb][0];c[topc][1]=b[topb][1];  /*列标不等时将大的作为新元素加入 */
					c[topc][2]=b[topb][2];
					topb++;topc++;
				}
				else if (a[topa][0]<b[topb][0])     /*行标不等时判断将小的作为新元素加入 */
				{ 
					c[topc][0]=a[topa][0];c[topc][1]=a[topa][1];
					c[topc][2]=a[topa][2];
					topa++;topc++;
				}
				else
				{ 
					c[topc][0]=b[topb][0];c[topc][1]=b[topb][1];   /*行标不等判断将大的作为新元素加入*/
					c[topc][2]=b[topb][2];
					topb++;topc++;
				}
	}
	while(topa<=ta)                                      /*有一个三元组结束后直接将另一三元组元素加入*/
	{
		c[topc][0]=a[topa][0];c[topc][1]=a[topa][1];
		c[topc][2]=a[topa][2];
		topa++;topc++;
	}
	while (topb<=tb)
	{ 
		c[topc][0]=b[topb][0];c[topc][1]=b[topb][1];
		c[topc][2]=b[topb][2];
		topb++;topc++;
	}
	c[0][2]=topc-1;
}


main()
{ 
	int a[][3]={4,4,4,0,1,2,0,3,3,1,1,4,3,0,6};
	int b[][3]={4,4,4,0,1,2,0,3,-3,2,2,5,3,3,7};
	int c[MAXN][3];
	int i,j,k;
	addmat(a,b,c);
	
	printf("\nOutput mat A:\n");
	k=a[0][2];
	for (i=0;i<=k;i++)
		printf("%4d%4d%4d\n",a[i][0],a[i][1],a[i][2]);
	
	printf("\nOutput mat B:\n");
	k=b[0][2];
	for (i=0;i<=k;i++)
		printf("%4d%4d%4d\n",b[i][0],b[i][1],b[i][2]);
	
	printf("\nOutput mat C:\n");
	k=c[0][2];
	for (i=0;i<=k;i++)
		printf("%4d%4d%4d\n",c[i][0],c[i][1],c[i][2]);
	getch();
}

