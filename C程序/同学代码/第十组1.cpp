// ��ʮ��.cpp : Defines the entry point for the console application.

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
	printf("������������������ӭ����c���Կ��ԡ���������������\n");
	printf("һ��ѡ���⣨���Դ�д��A��B��C��D����\n");

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
	printf("   9.switch���������ڵġ����ʽ������ֵ�����Ͳ����������������ͣ�____\n");
	printf("       A.��������   B.�ַ���    C.������\n");
	ch=getchar();
	getchar();
	if(ch=='C')
	{
		grade+=10;
	}
	system("cls");
	printf("   10.����ʹ�õ�switch����м�������\nswitch\n{\n  casea:\n  caseA:printf(\"you are right!\");break;\n");
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
	printf("  11B.�������³��򣬷������./n   ch=getchar();\n   pi switch(ch)\n  {\n    case'a':\n    case'b':\n");
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
		printf("1.����������ȷ����______��");
		printf("A. goto���ֻ�������˳����ѭ�� ");
		printf("B. switch����в��ܳ���continue���"); 
		printf("C. ֻ����continue�������ֹ����ѭ�� ");
		printf("D. ��ѭ����break��䲻�ܶ������� ");
	}

    void xuanze2()
    {
		printf("2. ����for(���ʽ�������ʽ3)�����Ϊ______��");
		printf("A. for(���ʽ��0�����ʽ3)");
		printf("B. for(���ʽ��1�����ʽ3)");
		printf("C. for(���ʽ�����ʽ1�����ʽ3)");
		printf("D. for(���ʽ�����ʽ3�����ʽ3)");
    }

    void xuanze3()
	{
		printf("3.���²���ȷ��if�����ʽ�� ______��\nA.if(x>y&&x!=y);\nB.if(x==y)x+=y;\nC.if(x!=y)scanf(\"'%%''d'\",&x)else scanf(\"'%''d'\",&y);\nD.if(x<y){x++;y++;}\n");
	}
	void xuanze4()
	{
		printf("4.��a=1,b=3,c=5,d=4ʱ��ִ��������һ�γ����x��ֵ��______��\nif(a<b)\n if(c<d)x=1;\n else\n   if(a<c)\n    if(b<d)x=2;\n    else x=3;\n   elsex=6\n  else x=7;\nA.1  B.2  C.3  D.6\n");
	}
	void xuanze5()
	{
		printf("5.�������������ʱ,������a����15,����������______��\nmain( ) { int a,b;\nscanf(\"'%''d'\",&a);\nb=a>15?a+10:a-10;\nprintf(\"'%''d'\\n\",b) ; }\nA) 5    B) 25   C) 15    D) 10 \n");
	}
    void xuanze6()
	{
		printf("6.��a=1��b=3��c=5��d=4ʱ��ִ������һ�γ����x��ֵΪ______��if (a<b)\nif (c<d) x=1;else\nif (a<c)\nif (b<d) x=2;\nelse x=3;\nelse x=6;\n else x=7;\nA) 1         B) 2\nC) 3         D) 6\n");
	}
    void xuanze7()
	{
		printf("7.�ٶ����б���������ȷ˵��,���г�������к�x��ֵ��______�� \na=b=c=0;x=35;\nif (!a) x--; \nelse if (b);\nif (c) x=3;\nelse x=4;\nA) 34        B) 4\nC) 35        D) 3");
    }
    void xuanze8()
	{
		printf("8.�� y=(x>0?1:x<0?-1:0); �Ĺ�����ͬ��if�����______��\nA) if (x>0) y=1;        B) if(x)  \nelse if (x<0) y=-1;      if (x>0) y=1;\nelse y=0;                else if (x<0) y=-1; \n                         else y=0;\nC) y=-1;                D) y=0;  \nif(x)                   if (x>=0)  \nif (x>0) y=1;             if (x>0) y=1; \nelse if (x==0) y=0;     else y=-1; \nelse y=-1;");
	}



