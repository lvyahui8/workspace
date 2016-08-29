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
	// 6.打印空心菱形◇
    // 打印高度为N（偶数）-1  或  N（奇数）-2
    // 打印菱形上部
	int i,j;
    for(i=0; i<N/2; i++)
    {
        for(j=0; j<N/2-1-i; j++) // 控制第一次打空格的个数
            printf(" ");


        printf("*");             // 空格打完直接打星


        for(j=0; j<2*i-1; j++)   // 控制第二次打空格的个数
            printf(" ");


        if(i!=0)                 // 控制第二次打星
            printf("*");


        printf("\n");
    }


    // 打印菱形下部
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

/*		m=5 n=2		   行号i   空格1  *  空格2 * 空格3\n  空格1=2abs(i)  空格2=
	*	____*____        -2      4		   0       4
	*	__*___*__		 -1      2		   3	   2
	*	*_______*         0      0		   7	   0
	*	__*___*__	      1		 2		   3	   2	
	*	___	*____         2      4		   0	   4
*/