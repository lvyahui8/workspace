#include <stdafx.h>

#define R 11
#define C 6

void s_aver(int score[R][C]);//����ÿ��ѧ����ƽ���ɼ�
void ss_aver(int score[R][C]);//����ÿ�ųɼ���ƽ���ɼ�
void s_max(int score[R][C]);//�ҳ���߷�
double fc_aver(int score[R][C]);//ƽ������

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
	

	printf("����Ϊ��%lf\n",fc_aver(int_s));

}

//ÿ��ѧ��ƽ����
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
	
	printf("ÿ���˵�ƽ������:%4d\n  ",int_s[i][5]);

}


//ÿ�ſ�ƽ����
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
	printf("ÿ�ſε�ƽ�����ǣ�%4d\n",int_s[10][j]);//���ÿ���γ̵�ƽ����
}




//�ҳ�50����������߷�����Ӧ��ѧ���Ϳγ�

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
	printf("��߷֣�%d\n",int_s[i][j]);//�����߷�
	printf("ѧ����%d\n",int_s[i][0]);//���ѧ��
	printf("ѧ�ƣ�%d\n",int_s[0][j]);//���ѧ��			
}




//����ƽ������


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
	
