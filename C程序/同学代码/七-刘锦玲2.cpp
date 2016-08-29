#include <stdafx.h>

#define R 11
#define C 6

void s_aver(int score[R][C]);//计算每个学生的平均成绩
void ss_aver(int score[R][C]);//计算每门成绩的平均成绩
void s_max(int score[R][C]);//找出最高分
double fc_aver(int score[R][C]);//平均方差

void main()
{
	int int_s[R][C];
	int i,j;
	for(i=0;i<R;i++)
	{
		for(j=0;j<C;j++)
			scanf("%d",&int_s[i][j]);
	}

	s_aver(int_s);
	ss_aver(int_s);
	s_max(int_s);
	

	printf("方差为：%lf\n",fc_aver(int_s));

}

//每个学生平均分
void s_aver(int score[R][C])
{
	int i,j;
	int int_s[11][5]={0};
	for(i=0;i<R-1;i++)
	{
		for(j=0;j<C-1;j++)
		{
			score[i][5]+=score[i][j];
			score[i][5]/=5;
		}
	}
	
	printf("每个人的平均分是:%4d\n  ",int_s[i][5]);

}


//每门课平均分
void ss_aver(int score[R][C])
{
	int i,j;
	int int_s[10][5]={0};
	for(i=0;i<R-1;i++)
	{
		for(j=0;j<C-1;j++)
		{
			score[10][j]+=score[i][j];
			score[10][j]/=10;
		}

	}
	printf("每门课的平均分是：%4d\n",int_s[10][j]);//输出每个课程的平均分
}




//找出50个分数中最高分所对应的学生和课程

void s_max(int int_s[11][6])
{
	int i,j;
	
	for(i=0;i<10;i++)
	{
		for(j=0;j<5;j++)
		{
			if(int_s[0][0]>int_s[i][j++])
			{
				int_s[i][j]=int_s[0][0];
			}
			else
			{
				int_s[i][j]=int_s[i][j++];
				
			}
		}
	}
	printf("最高分：%d\n",int_s[i][j]);//输出最高分
	printf("学生：%d\n",int_s[i][0]);//输出学生
	printf("学科：%d\n",int_s[0][j]);//输出学科			
}




//计算平均方差


double fc_aver(int score[R][C])
{
	int i,j;
	double x,y,sum;
	void s_aver(int score[R][C])
	{
		x=x+(int_s[i][C-1]*int_s[i][C-1]);
		y=y+int_s[i][C-1];
	}
	sum=0.1*x-powe(0.1*y,2);
	return sum;

}
	
