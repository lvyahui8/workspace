#include <stdafx.h>
//����������ĺ�
//��һ�������������
#define QAREA(A,B,C,SUM,AREA) SUM=(A+B+C)/2;AREA=sqrt(SUM*(SUM-A)*(SUM-B)*(SUM-C));
//�ڶ�����������Ƕ�
#define ARCCOS(X,Y,Z,CA,CB,CC) CC=acos((X*X+Y*Y-Z*Z)/(2*X*Y));CA=acos((Z*Z+Y*Y-X*X)/(2*Z*Y));CB=acos((Z*Z+X*X-Y*Y)/(2*Z*X));
void main()
{
	int i;
	float a,b,c,sum,area;		//������ߣ��ܳ�һ�룬�����
	float ca,cb,cc;				//������Ƕ�
	printf("�����������ߣ����ո�\n");
	scanf("%f %f %f",&a,&b,&c);	//���û���������ߴ浽a,b,c��
	if(a+b>c && a+c>b && b+c>a)	//�ж��Ƿ񹹳������Σ��������������������ӡ������Ϣ
	{
		QAREA(a,b,c,sum,area);	//ʹ�ú�������
		ARCCOS(a,b,c,ca,cb,cc);	//ʹ�ú����Ƕ�
		printf("  12345678901234567890\n");
		printf("a=%-9.3f��\tb=%-9.3f��\tc=%-9.3f��\narea=%-9.5fƽ����\n",a,b,c,area);	//��ӡ���߼����
		printf("A=%-8.6frad\tB=%-8.6frad\tC=%-8.6frad\n",ca,cb,cc);						//��ӡ�Ƕ�
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

/*�������н��
�����������ߣ����ո�
3 4 5
a=3.000    ��   b=4.000    ��   c=5.000    ��
area=6.000    ƽ����
A=0.643501rad   B=0.927295rad   C=1.570796rad
��1�س�����:
*/