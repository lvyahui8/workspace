#include"stdafx.h"
int xpj[10];//xpj��ʾѧ��ƽ����
int kpj[5];//  kpj��ʾÿ�ſ�ƽ����
int zg[2];//zg��ʾ��߷�
int f[10];//f��ʾ����
int score[10][5];
void av1(int x[][5],int y[10]);//  ��ѧ��ƽ���ֵ��Զ��庯��
void av2(int k[][5],int p[5]);//��ÿ�ſ�ƽ�����Զ��庯��
void max(int x[][5],int y[2]);
int fc(int x[][5]);//�󷽲���Զ��庯��
int m=0,n=0;
int i,j;
int main()
{
	for(i=0;i<=9;i++)
	{
		printf("�������%dλͬѧ����Ƴɼ���\n",i+1);
		for(j=0;j<=4;j++)
			scanf("%d",&score[i][j]);
    }

	av1(score,xpj);

	for(i=0;i<=9;i++)
		printf("��%dλͬѧ��ƽ���ɼ��ǣ�%d\n",i+1,xpj[i]);
	printf("\n\n");
	av2(score,kpj);
	for(j=0;j<=4;j++)
		printf("��%d����Ŀ��ƽ���ɼ��ǣ�%d\n",j+1,kpj[j]);
	printf("\n\n");
	max(score,zg);
	printf("��%dλѧ���ĵ�%d����Ŀ�ɼ����\n",zg[1],zg[2]);
	printf("\n\n");
	fc(score);
	printf("ƽ���ַ���Ϊ��%d\n",fc(score));
	return 0;
}

//��ѧ��ƽ���ֵ��Զ��庯��

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

//��ÿ�ſ�ƽ�����Զ��庯��
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
 //�����ֵ
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
//�󷽲�
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