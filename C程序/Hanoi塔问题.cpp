//�ƶ�64�����ӣ��ƶ��Ĵ���Ϊ2^64-1=1844 6744 0737 0955 1615��

#include <stdafx.h> 

//�����û��Զ���ĺ���hanoi��move
void hanoi(int i,char one,char two,char three);
void move(char x,char y);

void main()
{
	//���û��������Ӹ���
	int n;
	scanf("%d",&n);
	//����hanoi����
	hanoi(n,'A','B','C');
}

void hanoi(int i,char one,char two,char three)
{
	//���one����ֻ��һ�����ӣ�ֱ�ӽ����Ƶ�three��
	if(i==1)
	{
		//����move����
		move(one,three);
	}
	//����ֹһ�����ӣ�����������
	else
	{
		//��һ�����ݹ����hanoi��������one���ϵ�i-1�����ӽ���three��ȫ���Ƶ�two��
		hanoi(i-1,one,three,two);
		//�ڶ�������one�������ĵ�i������ֱ���Ƶ�three��
		move(one,three);
		//���������ݹ����hanoi��������two���ϵ�i-1�����ӽ���one��ȫ���Ƶ�three��
		hanoi(i-1,two,one,three);
	}
}

void move(char x,char y)
{
	//��ʽ����������裺��x���ƶ�һ�����ӵ�y��
	printf("%c->%c\n",x,y);
}
