/* �������Ԫ�������ʾϡ�����A��B����дһ�����A+B��C���Ժ�����Ҫ����ҲΪ��Ԫ���ʾ*/

# include "stdio.h"
# define MAXN 100
void addmat(int a[][3],int b[][3],int c[][3])
{
	int m,n,topa,topb,topc,ta,tb,tc;
	m=a[0][0];n=a[0][1];ta=a[0][2];
	c[0][0]=m;c[0][1]=n;tb=b[0][2];
	topa=topb=topc=1;
	while(topa<=ta && topb<=tb)            /*������ϡ������0Ԫ�ض�δ������ʱ*/
	{ 
		if (a[topa][0]==b[topb][0])          /*�б��*/
			if (a[topa][1]==b[topb][1])      /*�б��*/
				if (a[topa][2]+b[topb][2]!=0) /*��ӦԪ����Ӳ�Ϊ0 */
				{ 
					c[topc][0]=a[topa][0];c[topc][1]=a[topa][1];  /*������Ԫ�� */
					c[topc][2]=a[topa][2]+b[topb][2];
					topa++;topb++;topc++;     /*��ָ����� */
				}
				else
				{ 
					topa++;topb++;}           /*��ӦԪ�����=0 ,��ָ�����*/
				else if (a[topa][1]<=b[topb][1])    /*�б겻��ʱ�жϽ�С����Ϊ��Ԫ�ؼ��� */
				{ 
					c[topc][0]=a[topa][0];c[topc][1]=a[topa][1];
					c[topc][2]=a[topa][2];
					topa++;topc++;
				}
				else
				{ 
					c[topc][0]=b[topb][0];c[topc][1]=b[topb][1];  /*�б겻��ʱ�������Ϊ��Ԫ�ؼ��� */
					c[topc][2]=b[topb][2];
					topb++;topc++;
				}
				else if (a[topa][0]<b[topb][0])     /*�б겻��ʱ�жϽ�С����Ϊ��Ԫ�ؼ��� */
				{ 
					c[topc][0]=a[topa][0];c[topc][1]=a[topa][1];
					c[topc][2]=a[topa][2];
					topa++;topc++;
				}
				else
				{ 
					c[topc][0]=b[topb][0];c[topc][1]=b[topb][1];   /*�б겻���жϽ������Ϊ��Ԫ�ؼ���*/
					c[topc][2]=b[topb][2];
					topb++;topc++;
				}
	}
	while(topa<=ta)                                      /*��һ����Ԫ�������ֱ�ӽ���һ��Ԫ��Ԫ�ؼ���*/
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
