#include<stdio.h>
#define R 11
#define C 6
void s_aver(int score[11][6]);
void main()
{
	int int_s[R][C];
	int i,j;
	for(i=0;i<R;i++)
	{
		for(j=0;j<C;j++)
			scanf("%4d",&int_s[i][j]);

	}
	s_aver(int_s);
	for(i=0;i<10;i++)//���ÿ��ͬѧ��ƽ����
		printf("%d",int_s[i][5]);
}




#include<stdio.h>
#define R 11
#define C 6
void s_aver(int score[11][6]);
void main()
{
	int int_s[R][C];
	int i,j;
	for(i=0;i<R;i++)
	{
		for(j=0;j<C;j++)
		scanf("%4d",&int_s[i][j]);  
	}
	s_aver(int_s);
	for(j=0;j<5;j++)//���ÿ�ſε�ƽ����
		printf("%d",int_s[10][j]);

}




//�ҳ�50����������߷�����Ӧ��ѧ���Ϳγ�
#include<stdio.h>
#define R 11
#define C 6
void h_score(int score[11][6])
void main()
{
	int int_score[R][C];
	int i,j;
	for(i=0;i<R;i++)
	{
		for(j=0;j<C;j++)
			scanf("%4d",&int_s[i][j]);
	}
	h_score(int_s)
	for(i=0,j=0;i<10,j<5;i++,j++)
	{
		do
		{
			printf("%d",int_s[i][j]);//�����߷�
			printf("%d",int_s[0][j]);//���ѧ��
			printf("%d",int_s[i][0]);//���ѧ��
		}
		while(int_s[i][j]>int_s[i++][j++]);
	}
}




//����ƽ������
#include<stdio.h>
#define R 11
#define C 6
void s_aver(int score[11][6]);
void main()
{
	int int_s[R][C];
	int i,j,x,y,u=0;
	for(i=0;i<R;i++)
	{
		for(j=0;j<C;j++)
			scanf("%4d",&int_s[i][j]);

	}
	s_aver(int_s);
	for(i=0;i<10;i++)//ÿ��ͬѧ��ƽ����
	{
		x=int_s[i][5];
		y=x*x;
	}

	 



}
	
	 