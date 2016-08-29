// 新作业.cpp : Defines the entry point for the console application.
//

#include "stdafx.h"

void asd(int score[10][5])
{
	int i,j;
	for(i=0;i<=10;i++)
	{
		printf("请输出学生的成绩%2d:\n",i+1);
		for(j=0;j<=5;j++)
			scanf("%d",&score[i][j]);
	}
}

void stu_aver(int score[][5],float stu_aver[10])
{
	//float aver;
	int i,j;
    double s;
	for(i=0;i<=10;i++)
	{
		s=0;
		for(j=0;j<=5;j++)
			s+=score[i][j];
		stu_aver[i]=s/10.0;
	}
}

void sub_aver(int score[][5],float sub_aver[5])
{
	int i,j;
	double s;
	for(j=0;j<5;j++)
	{
		s=0;
		for(i=0;i<10;i++)
			s+=score[i][j];
		sub_aver[j]=s/5.0;		
	}
}


void main()
{
	int score[10][5];
	float stu1_aver[10],sub1_aver[5]; 
	int i,j;

 
    asd(score);

    stu_aver(score,stu1_aver);

    sub_aver(score,sub1_aver);

    printf("\n NO.  cour1   cour2   cour3   cour4   cour5     aver\n");
	for(i=0;i<=10;i++)
	{
		printf("\nNO%2d",i+1);
		for(j=0;j<5;j++)
			printf("%8.2f",score[i][j]);
		printf("%8.2f\n",stu1_aver[i]);
	}

	for(j=0;j<=5;j++)
	{
		printf("\nNO%2d",j+1);
		for(i=0;i<10;i++)
			printf("%8.2f",score[i][j]);
		printf("%8.2f\n",sub1_aver[j]);
	}

}


