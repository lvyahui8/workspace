#include <stdafx.h>
#include <stdlib.h>
//声明改错函数
void gaicuo();
//声明判断函数
void pd1(char a,char b);
void pd2(int x,int y);
//声明做答函数
void zuoda1();void zuoda2();
//每个题目单独为一个函数
void timu1();void timu2();void timu3();
void timu4();void timu5();void timu6();
void timu7();void timu8();void timu9();
void timu10();


int i,j=0,sum=0;
int xf[10];  //用来存每个题目的成绩
char ch;

void main()
{
	printf("==============================C 语言试题==================================\n");
	printf("一、单项选择题（请以英文大写做答）\n");
	timu1();pd1('C',ch);
	timu2();pd1('B',ch);
	timu3();pd1('B',ch);
	timu4();pd1('D',ch);
	timu5();pd1('D',ch);
	printf("二、填空题（答案均为一个整数）\n");
	timu6();pd2(3,i);
	timu7();pd2(7,i);
	timu8();pd2(3,i);		
	timu9();pd2(3025,i);
	timu10();pd2(1,i);
	gaicuo();
	for(j=0;j<=9;j++)
	{
		sum=sum+xf[j];
	}
	if(sum>=60)
	{
		printf("很好，你的成绩是%d\n",sum);
	}
	else
	{
		printf("杯具了！你还没及格，你的成绩是%d\n！",sum);
	}
	system("pause");
	
	//printf("答案:1、C 2、B 3、B 4、D 5、D 6、3 7、7 8、3 9、3025 10、1\n");
}
void gaicuo()
{
	int k;
	k=1;
	while(k!=0)
	{
		printf("你还需要修改吗？需要则输入题号，否则按0回车\n请输入:");
		scanf("%d",&k);
		getchar();
		switch(k)
		{
				case 1:timu1();j=k-1;pd1('C',ch);break;
				case 2:timu2();j=k-1;pd1('B',ch);break;
				case 3:timu3();j=k-1;pd1('B',ch);break;
				case 4:timu4();j=k-1;pd1('D',ch);break;
				case 5:timu5();j=k-1;pd1('D',ch);break;
				case 6:timu6();j=k-1;pd2(3,i);break;
				case 7:timu7();j=k-1;pd2(7,i);break;
				case 8:timu8();j=k-1;pd2(3,i);break;
				case 9:timu9();j=k-1;pd2(3025,i);break;
				case 10:timu10();j=k-1;pd2(1,i);break;
				default : break;
		}
	}

}
void zuoda1()
{
	printf("输入选项:");
	ch=getchar();
	getchar();
	printf("\n\n");
}
void zuoda2()
{
	printf("写出结果:");
	scanf("%d",&i);
	getchar();
	printf("\n\n");
}

void pd1(char a,char b)
{
	if(a==b)
	{
		xf[j]=10;
	}
	else
	{
		xf[j]=0;
	}
	j++;
}

void pd2(int x,int y)
{
	if(x==y)
	{
		xf[j]=10;
	}
	else
	{
		xf[j]=0;
	}
	j++;
}

void timu1()
{
	printf("1. C语言规定：在一个源程序中，main函数的位置\n");
	printf("A. 必须在最开始\nB. 必须在系统调用的库函数的后面\nC. 可以任意\nD. 必须在最后\n");
	zuoda1();
}

void timu2()
{
	printf("2）有以下定义语句，编译时会出现编译错误的是\n");
	printf("A）char a='a'%;   B）char a='a\\n'%;    C）char a='aa'%;    D）char a='\\x2d'%; \n");
	zuoda1();
}

void timu3()
{
	printf("3. 下面四个选项中，均是合法浮点数的选项是\n");
	printf("A. +1e+1    5e-9.4   03e2\nB. -.60     12e-4    -8e5");
	printf("C. 123e    1.2e-.4   +2e-1\nD. -e3      .8e-4   5.e-0\n");
	zuoda1();
}

void timu4()
{
	printf("4.以下叙述中不正确的是\n");
	printf("A）预处理命令行都必须以#号开始 \nB）在程序中凡是以#号开始的语句行都是预处理命令行\n");
	printf("C）宏替换不占用运行时间，只占编译时间\nD）在以下定义是正确的： ＃define PI 3.1415926;\n");
	zuoda1();
}

void timu5()
{
	printf("5. 以下正确的函数形式是\n");
	printf("A. double fun(int x,int y) { z=x+y;return z;}\nB. fun(int x,y) { int z; return z;}\n");
	printf("C. fun(x,y) { int x,y; double z; z=x+y; return z;}\nD. double fun( int x,int y) {double z; z=x+y; return z; }\n");
	zuoda1();
}

void timu6()
{
	printf("6.阅读下列程序段，则程序的输出结果为\n");
	printf("#include <stdio.h>\n#define M(X,Y) (X)*(Y)");
	printf("main()\n{ int a=5,b=6,c=8,k;\n\tk=N(M(a,b),c);\n\tprintf(\"%%d\\n\",k);\n}\n");
	zuoda2();
}

void timu7()
{
	printf("7.以下程序的输出结果是\n");
	printf("#define MAX(x,y) (x)>(y) ?(x):(y)\n");
	printf("main()\n{\tint a=5,b=2,c=3,d=3,t;\n\tt=MAX(a+b,c+d)*10;\n\tprintf(\"%d\\n\",t);\n}\n");
	zuoda2();
}

void timu8()
{
	printf("8.以下程序的输出结果是\n");
	printf("main()\n{\tint c=2,k=2;\n\tswitch (k)\n{\tdefault: c+=k\n");
	printf("\tcase 2: ++c;break;\n\tcase 3: c++;break;\n}\n\tprintf(\"%%d\\n\",c);\n}\n");
	zuoda2();
}

void timu9()
{
	printf("9.以下程序的输出结果是\n");
	printf("int a=5;\nvoid fun(int b)\n{\n\tint a=10;\n\ta+=b;printf(\"%%d\",a);\n}\n");
	printf("void main()\n{\n\tint c=20;\n\tfun(c);a+=c;\n\tprintf(\"%%d\\n\",a);\n}\n");
	zuoda2();
}

void timu10()
{
	printf("10.以下程序的输出结果是\n");
	printf("void main()\n{\n\tint x=1, y=2, z=3;\n\tif(x>y)\n\tif(y<z) printf(\"%%d\",++z);\n}\n");
	printf("else printf(\"%%d\", ++y);\n\tprintf(\"%%d\\n\", x++);\n}\n");
	zuoda2();
}


