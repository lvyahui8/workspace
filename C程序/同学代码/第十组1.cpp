// 第十组.cpp : Defines the entry point for the console application.

#include<stdafx.h>
#include<stdlib.h>
#include<conio.h>
void xuanze(char a);
void xuanze1();void xuanze2();
void xuanze3();void xuanze4();
void xuanze5();void xuanze6();
void xuanze7();void xuanze8();
int mi();
int action1();
int action2();
int i,j=0,sum=0;
int xf[10];


void main()
{
	printf("……………………欢迎进入c语言考试……………………\n");
	printf("一、选择题（请以大写的A、B、C、D作答）\n");

	xuanze1();xuanze('C');
	xuanze2();xuanze('B');
    xuanze3();xuanze('A');
    xuanze4();xuanze('B');
	xuanze5();xuanze('A');
	xuanze6();xuanze('B');
	xuanze7();xuanze('B');
	xuanze8();xuanze('A');
	mi();

	for (j=0;j<=9;j++)
	{
		sum=sum+xf[j];
	}


	

	system("pause");
}

void xuanze(char a)
{
	char ch;
	scanf("%c%*c",&ch);
	if(a==ch)
	{
		sum+=10;
	}
}

int mi()
{
	
	printf("             The C programming Language Test ");
	printf("                                                                               name:______number______\n");
	printf("Blow are ten questions,please choose the right answer you think and mark the A,BorC on the bracket.\n");
	char ch;
	int grade;
    grade=0;
	printf("   9.switch后面括号内的“表达式”，其值的类型不包括以下哪种数型？____\n");
	printf("       A.整数类型   B.字符型    C.浮点型\n");
	ch=getchar();
	getchar();
	if(ch=='C')
	{
		grade+=10;
	}
	system("cls");
	printf("   10.下列使用的switch语句有几处错误？\nswitch\n{\n  casea:\n  caseA:printf(\"you are right!\");break;\n");
	printf("   caseb:\n  caseB:printf(\"you are wrong!\");break;/n  default:putchar('\\a');\n");
	printf("   A.一处       B.二处      C.三处     \n");
	ch=getchar();
	getchar();
	switch(ch)
	{
	  case'A':
	  case'C':grade+=action1();break;
	  case'B':grade+=action2();break;
	  default:putchar('\a');
	}
	system("cls");
	printf("  11B.根据以下程序，分析结果./n   ch=getchar();\n   pi switch(ch)\n  {\n    case'a':\n    case'b':\n");
	printf("    case'c':printf(\"please try again!\");goto pi;\n    case'd':printf(\"contiue!\");break;\n  }\n当输入a时,程序运行结果是怎样？\n");
	printf("    A.会显示please try again!并可再次输入   B.会显示please try again!并跳转到下一题   C.因为程序不完整，所以不能确定！\n");
	ch=getchar();
	getchar();
	switch(ch)
	{
	  case'A':
	  case'C':grade+=action1();break;
	  case'B':grade+=action2();break;
	  default:putchar('\a');
	}
	printf("your score=%d",grade+sum);
	return 0;
}





	int action1()
	{
		return 0;
	}

	int action2()
	{
		return 10;
	}
	void xuanze1()
	{
		printf("1.以下描述正确的是______。");
		printf("A. goto语句只能用于退出多层循环 ");
		printf("B. switch语句中不能出现continue语句"); 
		printf("C. 只能用continue语句来终止本次循环 ");
		printf("D. 在循环中break语句不能独立出现 ");
	}

    void xuanze2()
    {
		printf("2. 对于for(表达式；；表达式3)可理解为______。");
		printf("A. for(表达式；0；表达式3)");
		printf("B. for(表达式；1；表达式3)");
		printf("C. for(表达式；表达式1；表达式3)");
		printf("D. for(表达式；表达式3；表达式3)");
    }

    void xuanze3()
	{
		printf("3.以下不正确的if语句形式是 ______。\nA.if(x>y&&x!=y);\nB.if(x==y)x+=y;\nC.if(x!=y)scanf(\"'%%''d'\",&x)else scanf(\"'%''d'\",&y);\nD.if(x<y){x++;y++;}\n");
	}
	void xuanze4()
	{
		printf("4.当a=1,b=3,c=5,d=4时，执行完下面一段程序后x的值是______。\nif(a<b)\n if(c<d)x=1;\n else\n   if(a<c)\n    if(b<d)x=2;\n    else x=3;\n   elsex=6\n  else x=7;\nA.1  B.2  C.3  D.6\n");
	}
	void xuanze5()
	{
		printf("5.若运行下面程序时,给变量a输入15,则输出结果是______。\nmain( ) { int a,b;\nscanf(\"'%''d'\",&a);\nb=a>15?a+10:a-10;\nprintf(\"'%''d'\\n\",b) ; }\nA) 5    B) 25   C) 15    D) 10 \n");
	}
    void xuanze6()
	{
		printf("6.当a=1，b=3，c=5，d=4时，执行下面一段程序后，x的值为______。if (a<b)\nif (c<d) x=1;else\nif (a<c)\nif (b<d) x=2;\nelse x=3;\nelse x=6;\n else x=7;\nA) 1         B) 2\nC) 3         D) 6\n");
	}
    void xuanze7()
	{
		printf("7.假定所有变量均已正确说明,下列程序段运行后x的值是______。 \na=b=c=0;x=35;\nif (!a) x--; \nelse if (b);\nif (c) x=3;\nelse x=4;\nA) 34        B) 4\nC) 35        D) 3");
    }
    void xuanze8()
	{
		printf("8.与 y=(x>0?1:x<0?-1:0); 的功能相同的if语句是______。\nA) if (x>0) y=1;        B) if(x)  \nelse if (x<0) y=-1;      if (x>0) y=1;\nelse y=0;                else if (x<0) y=-1; \n                         else y=0;\nC) y=-1;                D) y=0;  \nif(x)                   if (x>=0)  \nif (x>0) y=1;             if (x>0) y=1; \nelse if (x==0) y=0;     else y=-1; \nelse y=-1;");
	}



