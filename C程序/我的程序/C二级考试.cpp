#include <stdafx.h>
void pd1(int a,int b);
void zuoda();
void timu2();void timu3();
void timu4();void timu5();
int i,sum;
char ch;

void timu1()
{
	printf("41. C语言规定：在一个源程序中，main函数的位置\n");
	printf("A. 必须在最开始\nB. 必须在系统调用的库函数的后面\nC. 可以任意\nD. 必须在最后");
	zuoda();
}
void main()
{
	timu1();pd1('C',ch);
	timu2();pd1('B',ch);
	timu3();pd1('B',ch);
	timu4();pd1('D',ch);
	timu5();pd1('D',ch);	
	/*timu6();pd();
	timu7();pd();	
	timu8();pd();		
	timu9();pd();
	timu10();pd();
	*/
	printf("%d\n",sum);
}

void zuoda()
{
	printf("输入选项:");
	ch=getchar();
	getchar();
}

void pd1(char a,char b)
{
	if(a==b)
	{
		sum++;
	}
}


void timu2()
{
	printf("22）有以下定义语句，编译时会出现编译错误的是\n");
	printf("A）char a='a'%;   B）char a='a\\n'%;    C）char a='aa'%;    D）char a='\\x2d'%; ");
	zuoda();
}

void timu3()
{
	printf("42. 下面四个选项中，均是合法浮点数的选项是\n");
	printf("A. +1e+1    5e-9.4   03e2\nB. -.60     12e-4    -8e5");
	printf("C. 123e    1.2e-.4   +2e-1\nD. -e3      .8e-4   5.e-0");
	zuoda();
}

void timu4()
{
	printf("27.以下叙述中不正确的是\n");
	printf("A）预处理命令行都必须以#号开始 \nB）在程序中凡是以#号开始的语句行都是预处理命令行 ");
	printf("C）宏替换不占用运行时间，只占编译时间\nD）在以下定义是正确的： ＃define PI 3.1415926; ");
	zuoda();
}

void timu5()
{
	printf("49. 以下正确的函数形式是\n");
	printf("A. double fun(int x,int y) { z=x+y;return z;}\nB. fun(int x,y) { int z; return z;}");
	printf("C. fun(x,y) { int x,y; double z; z=x+y; return z;}\nD. double fun( int x,int y) {double z; z=x+y; return z; }");
	zuoda();
}


/*
	int an[10];
	char str[10];
	for(i=0;i<=100;i++)
	{
		printf("你还需要修改吗？需要则输入题号，否则按0回车\n请输入:");
		scanf("%d",&i);
		if(i!=0)
		{
			printf("输入答案:");
			scanf("%d",&an[i]);
		}
		else
		{
			break;
		}

	}
	*/