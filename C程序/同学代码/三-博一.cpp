// 大家好.cpp : 定义控制台应用程序的入口点。
// 我得 70 分

#include "stdafx.h"
#include<stdlib.h>
#include<windows.h>
int sum=80;
void main()
{
	char i;

	 printf("★☆★☆★☆★☆★☆★☆★☆\tExam\t★☆★☆★☆★☆★☆★☆★☆★☆★☆\t\n");
	 printf("Please write down your answer,e.g:Y or F\n\n");
	 printf("1.若有以下程序段int r=8; printf(\"%%d\n\",r/2);输出结果是4吗 ?\n\n");
	 printf("your answer is:\n");
	 scanf("%s",&i);
	 if(i=='Y')
	 {
		printf("Good job！10 points got!\n");
	 sum+=10;
	 }
     else
	 {
	    printf("How shit you are!\n");
		sum-=20;
	Sleep(1000);
	printf("Like a shit!\n");
	Sleep(1000);
	printf(" A terrible shit!\n");
	Sleep(1000);
	printf("20 points lost....\n");
	 }
	 Sleep(3000);
	 system("cls");
	 
	 printf("2.条件是i=1,i=i++,那么下一轮的结果是i==2,yes or no?\n");
      printf("Please write down your answer,e.g:yes is'■' or no is'θ'\n");
	  printf("your answer is:\n");
	  scanf("%s",&i);
	  if(i=='■')
	 {
		printf("Good job！5 points got!\n");
		sum+=10;
	 
	 }
     else
	 {
	   printf("How shit you are!\n");
	Sleep(1000);
	sum-=20;
	printf("Like a shit!\n");
	Sleep(1000);
	printf(" A terrible shit!\n");
	Sleep(1000);
	printf("20 points lost....\n");
	 }
	 Sleep(5000);
	 system("cls");

printf("Now ,you are listening a short conversation.\nListen carefully and write down what you got \n\n\n\n");
Sleep(3000);
printf("Sorry,your radio is broken....I cannot give you any score.\n\n\n\n");
Sleep(1000);
printf("Give up or not?\n");
Sleep(3000);
system("cls");
printf("接下来，才是知识的考验！接招吧！\n");
Sleep(1000);
printf("4.如果我想让printf语句里头换行，应该使用什么转义字符？\n");
printf("A.\\n    B.\\t\n"); 
scanf("%s",&i);
  
 if(i=='A')
	 {
		printf("Good job！5 points got!\n");
		sum+=10;
	 
	 }
     else
	{
	   
	printf("How shit you are!\n");
	Sleep(1000);
	printf("Like a shit!\n");
	Sleep(1000);
	printf(" A terrible shit!\n");
	Sleep(1000);
	printf("20 points lost....\n");
  }
	 Sleep(5000);




	
	 printf("5.下列关于C语言文件的叙述中正确的是\n\nA.文件由数据序列组成，可以构成二进制文件或文本文件      B.文件由字符序列组成，其类型只能是文本文件\n\n");
	 printf("your answer is:\n");
	 scanf("%s",&i);
	 if(i=='A')
	 {
		printf("Good job！10 points got!\n");
	 sum+=10;
	 }
     else
	 {
	    printf("How shit you are!\n");
		sum-=20;
	Sleep(1000);
	printf("Like a shit!\n");
	Sleep(1000);
	printf(" A terrible shit!\n");
	Sleep(1000);
	printf("20 points lost....\n");
	 }
	 Sleep(3000);
	




	 printf("6.C语言中若想使用sleep语句\n\nA.预处理中加入#include<windows.h>      B.预处理中加入#include<stdlib.h>\n\n");
	 printf("your answer is:\n");
	 scanf("%s",&i);
	 if(i=='A')
	 {
		printf("Good job！10 points got!\n");
	 sum+=10;
	 }
     else
	 {
	    printf("How shit you are!\n");
		sum-=20;
	Sleep(1000);
	printf("Like a shit!\n");
	Sleep(1000);
	printf(" A terrible shit!\n");
	Sleep(1000);
	printf("20 points lost....\n");
	 }
	 Sleep(3000);
	printf("Your score is.......\n");
	 printf("sum=%d",sum);
	  Sleep(3000);
	  system("pause");


	 
	

	 

	 //printf("\n");

}
    


