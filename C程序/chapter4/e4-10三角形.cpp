#include "stdafx.h"
#include <math.h>

void main()
{
	int d;
	float a,b,c;
	double s,area;
	do
	{
		printf("�����û��ṩ�����������߱߳��������\n");
		printf("�������������߳��ȣ��м���Ӣ�Ķ��Ÿ��������س���\n");
		scanf("%f,%f,%f",&a,&b,&c);
		while(b+c<=a || a+c<=b || a+b<=c)
		{
			printf("������������!\n");
			printf("�������������߳��ȣ����س���\n");
			scanf("%f%f%f",&a,&b,&c);
			
		}
		while(b-c>=a || a-c>=b || a-b>=c)
		{
			printf("������������!\n");
			printf("�������������߳��ȣ����س���\n");
			scanf("%f%f%f",&a,&b,&c);	
		}
		s=(a+b+c)/2;
		area=sqrt(s*(s-a)*(s-b)*(s-c));
		printf("���=%lg\n",area);	
		printf("��1�س�����\n");
		scanf("%d",&d);

	}while(d==1);
	
}//b+c<=a<b-c&& a+c<=b>a-c   a+b<=c>a-b