#include <stdafx.h>

void main()
{
	printf("�������乫˾�����˷�\n");
	double p,w,s,f;//
	int d,e,i;
	do
	{
		printf("������������˷ѣ�����������������롣֮����Ӣ�Ķ��Ÿ��������س�\n");
		scanf("%lf,%lf,%lf",&p,&w,&s); //���û���������
		e=s/250;
		switch(e)
		{
		case 0:
			d=0;
			break;
		case 1:
			d=2;
			break;
		case 2:
		case 3:
			d=5;
			break;
		case 4:
		case 5:
		case 6:
		case 7:
			d=8;
			break;
		case 8:
		case 9:
		case 10:
		case 11:
			d=10;
			break;
		default:
			d=15;
		}
		f=p*w*s*(1-d/100);
		printf("�����˷�=%g ��������=%g �������=%g\n�Ż��ۿ�=%d%%\n���˷�=%g\n",p,w,s,d,f);
		printf("��1�س�����\n");
		scanf("%d",&i);
	}
	while(i==1);
}