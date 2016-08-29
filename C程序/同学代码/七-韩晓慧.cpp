#include"stdafx.h"
int xpj[10];//xpj表示学生平均分
int kpj[5];//  kpj表示每门课平均分
int zg[2];//zg表示最高分
int f[10];//f表示方差
int score[10][5];
void av1(int x[][5],int y[10]);//  求学生平均分的自定义函数
void av2(int k[][5],int p[5]);//求每门课平均分自定义函数
void max(int x[][5],int y[2]);
int fc(int x[][5]);//求方差的自定义函数
int m=0,n=0;
int i,j;
int main()
{
	for(i=0;i<=9;i++)
	{
		printf("请输入第%d位同学的五科成绩：\n",i+1);
		for(j=0;j<=4;j++)
			scanf("%d",&score[i][j]);
    }

	av1(score,xpj);

	for(i=0;i<=9;i++)
		printf("第%d位同学的平均成绩是：%d\n",i+1,xpj[i]);
	printf("\n\n");
	av2(score,kpj);
	for(j=0;j<=4;j++)
		printf("第%d个科目的平均成绩是：%d\n",j+1,kpj[j]);
	printf("\n\n");
	max(score,zg);
	printf("第%d位学生的第%d个科目成绩最高\n",zg[1],zg[2]);
	printf("\n\n");
	fc(score);
	printf("平均分方差为：%d\n",fc(score));
	return 0;
}

//求学生平均分的自定义函数

void av1(int x[][5],int y[10])
{
	for(i=0;i<=9;i++)
	{
		for(j=0;j<=4;j++)
		  m=m+score[i][j];
		y[i]=m/5;
		m=0;
	}

}

//求每门课平均分自定义函数
void av2(int k[][5],int p[5])
{
	for(j=0;j<=4;j++)
	{
		for(i=0;i<=9;i++)
		  m=m+score[i][j];
		p[j]=m/10;
		m=0;
	}
}
 //求最大值
void max(int x[][5],int y[2])
{
	int b=score[0][0];
	for(i=0;i<=9;i++)
	{
		for(j=1;j<=4;j++)
		{
			if(b<score[i][j])
			{
				b=score[i][j];
		        y[1]=i+1;
	            y[2]=j+1;
			}
		}
	}
}
//求方差
int fc(int x[][5])
{
	int t;
	for(i=0;i<=9;i++)
	{
			m=m+xpj[i]*xpj[i];
			n=n+xpj[i];
	}
	t=m/10-n*n/100;
	
	return t;
}