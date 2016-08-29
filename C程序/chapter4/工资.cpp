
#include<stdafx.h>
void main()
{
	int d;
	float a,b,c;
	printf("作用：根据您输入的工资（单位为元且工资只能是正数）和税率（用小数表示；税率只能是正数，但不能大于1）计算税后的实际工资。");
	do
	{
		printf("\n\n\n请输入您的工资：");
		scanf("%f",&b);
		while(b<0)
		{
			fflush(stdin);
			printf("警告！您输入的工资有误，请重新输入！（工资只能是正数。）\n");
			printf("\n请输入您的工资：");
			scanf("%f",&b);
		}
		printf("请输入您需要交的税率：");
		scanf("%f",&c);
		while(c<0||c>1)
		{
			fflush(stdin);
			printf("警告！您输入的税率有误，请重新输入！（税率只能是正数，但不能大于1。）\n");
			printf("\n请输入您需要交的税率：");
			scanf("%f",&c);
		}
		printf("\n\n您输入的工资是：%.2f\n您输入的税率是：%.2f\n您的税后工资是：%.2f\n\n输入1继续...\n",b,c,a=b-b*c);
		scanf("%d",&d);
	}while(d==1);
}

