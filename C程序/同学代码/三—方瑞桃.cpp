#include <stdafx.h>
#include <stdlib.h>
void diyiti();void dierti();void disanti();void disiti();void diwuti();void diliuti();void diqiti();void dibati();void dijiuti();void dishiti();
float a,b,c,d,e,f,g,h,i,j,k,m,q,u,v,w,x,y,l,sum;

int main()
{
	//33, 1, 4, 1 ,2 ,2 , C, B, C, A
	diyiti();
	dierti();
	disanti();
	disiti();
	diwuti();
	diliuti();
	diqiti();
	dibati();
	dijiuti();
	dishiti();
	return 0;
}
void diyiti()
{
    sum=0;
    printf("һ.����⣺ÿ��10�֣���Ե�10��,�����0��.\n");
	printf("1. a=3,b=3,��a*=b+8��ֵc=");
	scanf("%f",&c);
	d=33;
	if(d==c)
	{
		sum=sum+10;
		printf("sum=%f\n",sum);
	}
	else
	{
		diyiti();
	}
}
void dierti()
{
	printf("2. e=4����e%%3��ֵf=");
	scanf("%f",&f);
	g=1;
    if(f==g)
	{
		sum=sum+10;
		printf("sum=%f\n",sum);
	}
	else
	{
		dierti();
	}
}
void disanti()
{	
	printf("3. i=3,i++=");
	scanf("%f",&q);
	u=4;
	if(q==4)
	{
		sum=sum+10;
		printf("sum=%f\n",sum);
	}
	else
	{
		disanti();
	}
}
void disiti()
{
	printf("��.�ж��⣬��������1����������2��ÿ��10��,������С��\n");
	printf("4. h=87,i=86,h>i����������1������������2\n");
	scanf("%f",&j);
	k=1;
	if(j==k)
	{
		sum=sum+10;
		printf("sum=%f\n",sum);	
	}
		else
		{
			disiti();
		}
}
void diwuti()
{
	printf("5. ���ų���ռ�ڴ�����������1������������2\n");
	scanf("%f",&l);
	m=2;
	if(l==m)
	{
		sum=sum+10;
		printf("sum=%f\n",sum);
	}
	else
	{
		diwuti();
	}
}
void diliuti()
{
	printf("6. �ܷ�Է��ų���������ֵ? ��������1������������2\n");
	scanf("%f",&w);
	x=2;
	if(w==x)
	{
		sum=sum+10;
		printf("sum=%f\n",sum);
	}	
	else
	{
		diliuti();
	}
}
void diqiti()
{
	printf("��.ѡ���⣺ÿ����Ŀֻ��һ����ȷ�𰸣���ȷ��10�֣���ѡ��0�֣����ĸ�С��\n");
	char chn;
	printf("7. ת���ַ�\\r����˼��? A.��ҳ B.�˸� C.�س� D.����\n");
	scanf("%*c%c",&chn);
	getchar();
	if('C'==chn)
	{
		sum=sum+10;
	}
		else
	{
		diqiti();
	}
}
void dibati()
{
	printf("8. 'fly'ռ������? A.1 B.3 C.6 D.8\n");
	char cho;
	scanf("%c",&cho);
	getchar(); 
	if('B'==cho)
	{
		sum=sum+10;
		printf("sum=%f\n",sum);	
	}
	else
	{
		dibati();
	}
}
void dijiuti()
{
	char chp;
	printf("9.�����ĸ��ǲ���ȷ�ı�ʶ���� A. sun B.-total C.#77 D.BASIC\n"); 
	scanf("%c",&chp);
	getchar();
	if('C'==chp)
	{
		sum=sum+10;
		printf("sum=%f\n",sum);
	}
	else
	{
		dijiuti();
	}
}
void dishiti()
{
	char chy;
	printf("10. �����Ƿ��Ǵ�main������ʼִ��? A.�� B.��C.��һ�� D.��ȷ�� \n");
	scanf("%c",&chy);
	getchar();
	if('A'==chy)
	{
		sum=sum+10;
		printf("sum=%f\n",sum);
	}
	else
	{
		dishiti();
	}
}
