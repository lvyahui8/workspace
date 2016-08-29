// 第十组.cpp : Defines the entry point for the console application.

#include<stdafx.h>
#include<stdlib.h>
#include<conio.h>
int action1();
int action2();

int main()
{
	
	printf("             The C programming Language Test ");
	printf("                                                                               name:______number______\n");
	printf("Blow are ten questions,please choose the right answer you think and mark the A,BorC on the bracket.\n");
	char ch;
	int grade;
    grade=0;
	printf("   1.switch后面括号内的“表达式”，其值的类型不包括以下哪种数型？____\n");
	printf("       A.整数类型   B.字符型    C.浮点型\n");
	ch=getchar();
	getchar();
	if(ch=='C')
	{
		grade+=10;
	}
	system("cls");
	printf("   2.下列使用的switch语句有几处错误？\nswitch\n{\n  casea:\n  caseA:printf(\"you are right!\");break;\n");
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
	printf("  3.根据以下程序，分析结果./n   ch=getchar();\n   pi switch(ch)\n  {\n    case'a':\n    case'b':\n");
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
	printf("your score=%d",grade);
	


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


