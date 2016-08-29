// 测试题01.cpp : Defines the entry point for the console application.
//

#include <stdafx.h>
#include <stdlib.h>

void tj(char x,char y);
int sum=0;

int main()
{
    char a;
	float b;
	printf("		***同学，欢迎进入考试界面\n		请仔细阅读以下题目，并给出最佳答案。\n		本套试卷共十二题，每题十分，满分120分。\n		每道题您仅有一次作答机会，做后将不予更改\n		请按规则作答，否则将不予受理\n");
	printf("请按任意键回车继续");
	a=getchar();
	getchar();
	tj('_',a);

	printf("1.下列语句正确的是\nA.if(a+b=10)	B.if(i<10)		C.if(a=1) i=a-b;	D.以上表达式全错\n  {  	          {			  {\n	i++;					else if(a<1) i=a+b;\n  else		  else\n	++i;		++i;		  }\n  }		  }			\n\n");
	a=getchar();
	getchar();
	tj('C',a);//scanf("%d %d",&tihao,&daan)   switch(tihao) {case 1: if(daan!=zdaan) goto pi;}

	/*if( a=='B')
	{ b=10;
	 printf("b=%f分\n",b);
    } 
	else 
	{ b=0;
      system("cls");
	}*/
    printf("2.下列语句中错误的地方在哪\nswitch(ch)\n{\ncase '1':i+=10;\ncase '2':i+=0;\n}\nA.表达式中ch错误	B.常量中的''号	C.没有default语句	D.没有错误\n");
    a=getchar();
	getchar();
	tj('B',a);

	/*if( a=='C')
	{ b=10;
	 printf("b=%f分\n",b);
    } 
	else 
	{ b=0;
      system("cls");
	}
	*/
	printf("3.下列程序中错误的地方是\n#include\"stdio.h\"----1\nint main()\n{\n	int i;\n	char ch;----2\n		swtich----3(ch)\n	{\n		case 'a':i+=5;\n	case 'b':i+=5;\n	case 'c':i+=0;\nA.第1处有错误\nB.第2处有错误\nC.第3处有错误\nD.没有错误\n");
	a=getchar();
	getchar();
	tj('C',a);


	printf("4.在双分支结构if* else中的*处嵌入单分支结构if，在Vc中运行会怎样\n");
	printf(" A.照样执行两个结构，而且所有内容都会按次序输出\n"); 
    printf(" B.照样执行程序，但会造成丢失\n"); 
    printf(" C.无法运行，会报错\n"); 
    printf(" D.以上答案都不对\n");
	a=getchar();
	getchar();
	tj('C',a);

	printf("5.if语句中的“表达式”不可以是（） \n");
	printf("A.关系表达式  B.逻辑表达式  C.数值表达式  D.判断表达式 \n");
	a=getchar();
	getchar();
	tj('D',a);

	printf("6. switch后面括号内的“表达式”，其值的类型应为（）类型。\n");
	printf("A.单精度  B.整数  C.空  D.函数\n");
	a=getchar();
	getchar();
	tj('B',a);

	printf("7.关系运算符的优先级（）算术运算符，关系运算符的优先级（）赋值运算符。\n");	
	printf("A.低于、高于   B.高于、高于   C.高于、低于   D.低于、低于\n");
	a=getchar();
	getchar();
	tj('A',a);

	printf("8.下列关于C语言的叙述错误的是____ \n");
	printf("A. 大写字母和小写字母的意义相同 \nB. 不同类型的变量可以在一个表达式中 \nC. 在赋值表达式中等号(=)左边的变量和右边的值可以是不同类型  \nD. 同一个运算符号在不同的场合可以有不同的含义 \n");
    a=getchar();
	getchar();
	tj('A',a);

	printf("9.if语句中, if后面没有花括号可以执行几条语句\n");
	printf("A.一条	B.两条	C.多条	D.无法执行\n");
	a=getchar();
	getchar();
	tj('A',a);

    printf("10.switch语句中，case常量可以相同么\n");
	printf("A.可以，只会执行第一条	B.可以，但会丢失	C.可以，全部执行	D.不可以\n");
    a=getchar();
	getchar();
	tj('D',a);

	printf("11.if语句中的“表达式”可以是数值表达式么__;\nswitch后面的括号内的表达式其值类型可以是字符型么__ \n");
	printf("A.可以，不可以	B.可以，可以	C.不可以，可以	D.不可以，不可以\n");
    a=getchar();
	getchar();
	tj('B',a);

	printf("12.在双分支结构if“{ }”else中在嵌入一个双分支if else结构，如果没有“{}”会怎样\n");
	printf("  A.只执行一个if else\n  B.都会执行，但会造成丢失\n  C.无法执行，会报错\n  D.无太大影响，只是不便找错\n");
    a=getchar();
	getchar();
	tj('D',a);

    if(sum>=90)
	{
		 printf("		您的总得分为%d分\n",sum);
	     printf("		恭喜您，您的成绩达到优秀!\n");
	}
	else
	{
         
         printf("		您的总得分为%d分\n",sum);
	     printf("		您还需继续努力!\n");
	}
	printf("		合作愉快，谢谢您的参与!\n");
	a=getchar();
	getchar();
	tj('_',a);
	return 0;
}

void tj(char x,char y)
{
	if(x==y)
	{
		sum+=10;
	}
	system("cls");
}

