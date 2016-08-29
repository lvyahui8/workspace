#include <stdafx.h>
#include <stdlib.h>
#include <math.h>
//声明做答函数
void zuoda1();void zuoda2();
//每个题目单独为一个函数
void timu1();void timu2();void timu3();
void timu4();void timu5();void timu6();
void timu7();void timu8();void timu9();
void timu10();

// 整型变量用来存 填空题答案
// 字符型变量用来存 选择题答案
int i;
char ch;

void main()
{
	ch='x'; while('C'!=ch) {timu1();system("cls");}//   while(执行条件){循环体}
	ch='x'; while('B'!=ch) {timu2();system("cls");}
	ch='x'; while('B'!=ch) {timu3();system("cls");}
	ch='x'; while('D'!=ch) {timu4();system("cls");}
	ch='x'; while('D'!=ch) {timu5();system("cls");}
	i=0; while(3!=i) {timu6();system("cls");}
	i=0; while(7!=i) {timu7();system("cls");}
	i=0; while(3!=i) {timu8();system("cls");}
	i=0; while(3025!=i) {timu9();system("cls");}
	i=0; while(1!=i) {timu10();system("cls");}
	
	system("pause");
}
void zuoda1()
{
	// 输入选择题答案
	printf("输入选项:");
	ch=getchar();
	getchar();
	printf("\n\n");
}
void zuoda2()
{
	//输入填空题答案
	printf("写出结果:");
	scanf("%d",&i);
	getchar();
	printf("\n\n");
}
// 下面 是题目  每个题目后面调用作答函数
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
	printf("main()\n{\tint a=5,b=6,c=8,k;\n\tk=N(M(a,b),c);\n\tprintf(\"%%d\\n\",k);\n}\n");
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


