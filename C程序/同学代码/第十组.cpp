// ��ʮ��.cpp : Defines the entry point for the console application.

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
	printf("   1.switch���������ڵġ����ʽ������ֵ�����Ͳ����������������ͣ�____\n");
	printf("       A.��������   B.�ַ���    C.������\n");
	ch=getchar();
	getchar();
	if(ch=='C')
	{
		grade+=10;
	}
	system("cls");
	printf("   2.����ʹ�õ�switch����м�������\nswitch\n{\n  casea:\n  caseA:printf(\"you are right!\");break;\n");
	printf("   caseb:\n  caseB:printf(\"you are wrong!\");break;/n  default:putchar('\\a');\n");
	printf("   A.һ��       B.����      C.����     \n");
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
	printf("  3.�������³��򣬷������./n   ch=getchar();\n   pi switch(ch)\n  {\n    case'a':\n    case'b':\n");
	printf("    case'c':printf(\"please try again!\");goto pi;\n    case'd':printf(\"contiue!\");break;\n  }\n������aʱ,�������н����������\n");
	printf("    A.����ʾplease try again!�����ٴ�����   B.����ʾplease try again!����ת����һ��   C.��Ϊ�������������Բ���ȷ����\n");
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


