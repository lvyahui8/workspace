#include <stdafx.h>
#include <math.h>
#include <conio.h>
#define N 10
void main()
{

	

	int i,j,m,n;
	m=5;
	n=m/2;
	for(i=-n;i<=n;i++)
	{
		for(j=1;j<=2*abs(i);j++)
		{
			printf("_");
		}c
	
		if(abs(i)!=n)
		{	
			printf("*");
			for(j=1;j<=m-2*abs(i)-1;j++)
			{
				printf("__");
			}	
			printf("*");
		}
		else
		{
			printf("*");
		}
		for(j=1;j<=2*abs(i);j++)
		{
			printf("_");
		}
		printf("\n");
	}
	
	/*
	// 6.��ӡ�������Ρ�
    // ��ӡ�߶�ΪN��ż����-1  ��  N��������-2
    // ��ӡ�����ϲ�
	int i,j;
    for(i=0; i<N/2; i++)
    {
        for(j=0; j<N/2-1-i; j++) // ���Ƶ�һ�δ�ո�ĸ���
            printf(" ");


        printf("*");             // �ո����ֱ�Ӵ���


        for(j=0; j<2*i-1; j++)   // ���Ƶڶ��δ�ո�ĸ���
            printf(" ");


        if(i!=0)                 // ���Ƶڶ��δ���
            printf("*");


        printf("\n");
    }


    // ��ӡ�����²�
    for(i=N/2-2; i>=0; i--)
    {
        for(j=0; j<N/2-1-i; j++)
            printf(" ");


        printf("*");


        for(j=0; j<2*i-1; j++)
            printf(" ");


        if(i!=0)
            printf("*");


        printf("\n");
    }
	*/



}

/*		m=5 n=2		   �к�i   �ո�1  *  �ո�2 * �ո�3\n  �ո�1=2abs(i)  �ո�2=
	*	____*____        -2      4		   0       4
	*	__*___*__		 -1      2		   3	   2
	*	*_______*         0      0		   7	   0
	*	__*___*__	      1		 2		   3	   2	
	*	___	*____         2      4		   0	   4
*/