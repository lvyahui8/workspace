#include <stdafx.h>
#include <stdlib.h>
#include <math.h>
//�����Զ��庯������һ����������ڶ�����Ƕ�
float area(float x,float y,float z);
float arccos(float x,float y,float z);	
void main()
{	
	int i;
	float a,b,c;
	//�������
	printf("�����������ߣ����ո�\n");
	scanf("%f %f %f",&a,&b,&c);	//���û���������ߴ浽a,b,c��
	if(a+b>c && a+c>b && b+c>a)	//�ж��Ƿ񹹳������Σ��������������������ӡ������Ϣ
	{
		printf("a=%-9.3f��\tb=%-9.3f��\tc=%-9.3f��\narea=%-9.3fƽ����\n",a,b,c,area(a,b,c));	//��ӡ���߼����
		printf("A=%-8.6frad\tB=%-8.6frad\tC=%-8.6frad\n",arccos(b,c,a),arccos(c,a,b),arccos(a,b,c));	//��ӡ�Ƕ�
	}
	else
	{
		printf("���ܹ���������\n");
	}
	//���������������ó����ܼ�����
	printf("��1�س�����:");
	scanf("%d",&i);
	if(1==i) 
	{
		system("cls");
		main();
	}
}

float area(float x, float y,float z)
{
	

	float sum;
	sum=(x+y+z)/2;
	return sqrt(sum*(sum-x)*(sum-y)*(sum-z));
}

float arccos(float x,float y,float z)
{
	return acos((x*x+y*y-z*z)/(2*x*y));
}

/*�������н��
�����������ߣ����ո�
3 4 5
a=3.000    ��   b=4.000    ��   c=5.000    ��
area=6.000    ƽ����
A=0.643501rad   B=0.927295rad   C=1.570796rad
��1�س�����:
*/