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
    printf("一.填空题：每题10分，答对得10分,否则得0分.\n");
	printf("1. a=3,b=3,求a*=b+8的值c=");
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
	printf("2. e=4，求e%%3的值f=");
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
	printf("二.判断题，是则输入1，否则输入2，每题10分,共三个小题\n");
	printf("4. h=87,i=86,h>i吗？是请输入1，否则请输入2\n");
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
	printf("5. 符号常量占内存吗？是请输入1，否则请输入2\n");
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
	printf("6. 能否对符号常量赋以新值? 是请输入1，否则请输入2\n");
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
	printf("三.选择题：每个题目只有一个正确答案，正确得10分，错选的0分，共四个小题\n");
	char chn;
	printf("7. 转义字符\\r的意思是? A.换页 B.退格 C.回车 D.警告\n");
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
	printf("8. 'fly'占几个字? A.1 B.3 C.6 D.8\n");
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
	printf("9.下面哪个是不正确的标识符？ A. sun B.-total C.#77 D.BASIC\n"); 
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
	printf("10. 程序是否都是从main函数开始执行? A.是 B.否C.不一定 D.不确定 \n");
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
