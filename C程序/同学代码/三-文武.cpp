// c语言试卷.cpp : Defines the entry point for the console application.

	printf("1.i的初始值是2，则i-- =（ ）\n A.2    B.1   C.0   D.3\n\n\n请输入你的答案：");
	scanf("%c",&ch1);
	getchar();
	if('A'==ch1)
	       sum=sum+10;
	else
	    	sum=sum+0;
	
	//2

	printf("\n\n\n2.有一个变量a,则表达式a+=3的意思是（ ）\n A.a=3   B.a+3=a   C.a=a+3   D.3=a  \n\n\n请输入你的答案");
	scanf("%c",&ch2);
	getchar();
	if('A'==ch2)
	       sum=sum+10;
	else
	    	sum=sum+0;
    
	//3
   printf("\n\n\n3.(double)a是什么意思（ ）\n A.输出两个a   B.将a转换成double类型   C.输出两个（a）   D.输出两个double \n\n\n请输入你的答案：");
	scanf("%c",&ch3);
	getchar();
	if('B'==ch3)
	       sum=sum+10;
	else
	    	sum=sum+0;

    
	//4
	printf("\n\n\n4.&&是什么意思（）\n	A.且    B.或   C.等于   D.不等于 \n\n\n请输入你的答案：");
	scanf("%c",&ch4);
	getchar();
	if('A'==ch4)
	       sum=sum+10;
	else
	    	sum=sum+0;
	//5
	printf("\n\n\n5.当程序中要用到数学函数库中的函数时，需要什么头文件（）\n	A.#include<stdio.h>   B.#include<stdafx.h>   C.#include<math.h>   D.#include<windows.h> \n\n\n请输入你的答案：");
	scanf("%c",&ch5);
	getchar();
	if('C'==ch5)
	       sum=sum+10;
	else
	    	sum=sum+0;
	//6'
		printf("\n\n\n6.printf函数的一般格式为：  printf(\"%%d %%d\n\",a,b)'那么其中的%%d是什么意思（）\n		A.输出表列   B.格式声明   C.d的百分数   D.取地址操作符 \n\n\n请输入你的答案：");
	scanf("%c",&ch6);
	getchar();
	if('B'==ch6)
	       sum=sum+10;
	else
	    	sum=sum+0;
	//7
		printf("\n\n\n7.使用for语句时\“（）\”正确的顺序是（）\n	A.(i++；i<=99;i=1)	B.(i<=99;i++;i=1)	C.（i=1;i<=99;i++）	D.(i++;i=1;i<=99) \n\n\n请输入你的答案：");
	scanf("%c",&ch7);
	getchar();
	if('C'==ch7)
	       sum=sum+10;
	else
	    	sum=sum+0;
	//8
		printf("\n\n\n8.语句printf(\"%%s\",sun);与printf(\"%%s\",'sun');有区别吗？（）\n	A.没有	B.可能有	C.有	D.有没有，我怎么知道？oh,shit!! \n\n\n请输入你的答案：");
	scanf("%c",&ch8);
	getchar();
	if('C'==ch8)
	       sum=sum+10;
	else
	    	sum=sum+0;
	//9
		printf("\n\n\n9.%%s是什么（）\n		A.不知道	B.格式控制符	C.知道，不告诉你	D.输出字符串 \n\n\n请输入你的答案:");
	scanf("%c",&ch9);
	getchar();
	if('D'==ch9)
	       sum=sum+10;
	else
	    	sum=sum+0;
	//10
		printf("\n\n\n10.x%%=3等价于（）\n			A.x=x%%3		B.x=300		C.x=3		D.别选这个，不知道！！？ \n\n\n请输入你的答案：");
	scanf("%c",&ch10);
	getchar();
	if('A'==ch10)
	       sum=sum+10;
	else
	    	sum=sum+0;
   


	printf("\n\n\n您的总分为：%d   \n\n\n\n\n",sum);
}

