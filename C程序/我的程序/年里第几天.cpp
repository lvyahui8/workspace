/*
��������ĳ��ĳ��ĳ�գ��ж���һ������һ��ĵڼ���

˼·��
1.������������������-��������-���������������ɡ�
2.�Զ���һ���������ú����϶���Ҫ3���βΣ��������ͷ���ֵ
3.���Զ��庯��������switch�����Ĵ�͸�Լ�������
4.�����ǵ���������

���裺
1.�����������ø�ʽ����������
2.�ж������Ƿ����Ҫ��������ú���fatalism�����������������������
3.��fatalism�������Ƚ�����֮ǰ�����µ�����������
4.���жϸ����Ƿ������꣬���ǲ���2���Ժ��������1�죬���򲻼ӡ�
*/

// 1   2  3  4  5  6  7  8  9  10  11  12
// 31  28 31 30 31 30 31 31 30 31  30  31

#include <stdafx.h>

int fatalism(int year,int month,int day)
{
	int sum=0,leap;
	switch(month)
	{
	case 12:sum+=30;// Ҫ��monthǰ���·ݵ�����ȫ������
	case 11:sum+=31;
	case 10:sum+=30;
	case 9:sum+=31;
	case 8:sum+=31;
	case 7:sum+=30;
	case 6:sum+=31;
	case 5:sum+=30;
	case 4:sum+=31;
	case 3:sum+=28;
	case 2:sum+=31;
	default : break;
	}
	sum=sum+day;//�ټ���ĳ�������
	if(year%400==0 || year%100!=0)//�ж��ǲ�������
		leap=1;
	else
		leap=0;
	if(leap==1 && month>2) //������������·ݴ���2��������Ӧ�ü���һ��
		sum++;
	return sum;
}
void main()
{
	int i_year,i_month,i_day;
	puts("Please enter the date.For example 2012.3.7");
p:	scanf("%d.%d.%d%*c",&i_year,&i_month,&i_day);
	if(i_month<=12 && i_day<=31)
		printf("%d.%d.%d_number of days:%dth\n",i_year,i_month,i_day,fatalism(i_year,i_month,i_day));
	else
	{
		puts("Input error,Please input again.");
		goto p;
	}
}