#include <stdafx.h>

void main()
{
	printf("用于运输公司计算运费\n");
	double p,w,s,f;//
	int d,e,i;
	do
	{
		printf("依次输入基本运费，货物重量，运输距离。之间用英文逗号隔开，并回车\n");
		scanf("%lf,%lf,%lf",&p,&w,&s); //供用户输入数据
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
		printf("基本运费=%g 货物重量=%g 运输距离=%g\n优惠折扣=%d%%\n总运费=%g\n",p,w,s,d,f);
		printf("按1回车继续\n");
		scanf("%d",&i);
	}
	while(i==1);
}