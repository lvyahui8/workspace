// ��Һ�.cpp : �������̨Ӧ�ó������ڵ㡣
// �ҵ� 70 ��

#include "stdafx.h"
#include<stdlib.h>
#include<windows.h>
int sum=80;
void main()
{
	char i;

	 printf("���������������\tExam\t�������������������\t\n");
	 printf("Please write down your answer,e.g:Y or F\n\n");
	 printf("1.�������³����int r=8; printf(\"%%d\n\",r/2);��������4�� ?\n\n");
	 printf("your answer is:\n");
	 scanf("%s",&i);
	 if(i=='Y')
	 {
		printf("Good job��10 points got!\n");
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
	 
	 printf("2.������i=1,i=i++,��ô��һ�ֵĽ����i==2,yes or no?\n");
      printf("Please write down your answer,e.g:yes is'��' or no is'��'\n");
	  printf("your answer is:\n");
	  scanf("%s",&i);
	  if(i=='��')
	 {
		printf("Good job��5 points got!\n");
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
printf("������������֪ʶ�Ŀ��飡���аɣ�\n");
Sleep(1000);
printf("4.���������printf�����ͷ���У�Ӧ��ʹ��ʲôת���ַ���\n");
printf("A.\\n    B.\\t\n"); 
scanf("%s",&i);
  
 if(i=='A')
	 {
		printf("Good job��5 points got!\n");
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




	
	 printf("5.���й���C�����ļ�����������ȷ����\n\nA.�ļ�������������ɣ����Թ��ɶ������ļ����ı��ļ�      B.�ļ����ַ�������ɣ�������ֻ�����ı��ļ�\n\n");
	 printf("your answer is:\n");
	 scanf("%s",&i);
	 if(i=='A')
	 {
		printf("Good job��10 points got!\n");
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
	




	 printf("6.C����������ʹ��sleep���\n\nA.Ԥ�����м���#include<windows.h>      B.Ԥ�����м���#include<stdlib.h>\n\n");
	 printf("your answer is:\n");
	 scanf("%s",&i);
	 if(i=='A')
	 {
		printf("Good job��10 points got!\n");
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
    


