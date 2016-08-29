#include <stdio.h>
#include <string.h>

#define MaxSize 50
typedef struct {              /* ����ջ�ṹ */
	char data[MaxSize];
	int top;
}SeqStack; 

SeqStack *S;

int Push_SeqStack(SeqStack *s,char x)  /* Ԫ����ջ���� */
{ 
	if(s->top==MaxSize-1)
    {
		printf("\n Stack is full!");
		return 0;
    }
	s->top++;
	s->data[s->top]=x;
	return 1; 
}

int Empty_SeqStack(SeqStack *S)    /* �п�ջ���� */
{ 
	if (S->top==-1)
		return 1;
	else
		return 0;
}

int Pop_SeqStack(SeqStack *s,char *x)   /* Ԫ�س�ջ���� */
{ 
	if(Empty_SeqStack (s)) 
    { 
		printf("\n Stack is free!"); 
		return 0;
    }
	*x=s->data[s->top];
	s->top--;
	return 1;
}

/* �������б��ַ����Ƿ��ǻ������еĺ�����������ʾ"Yes" ����1��*/
/* ������ʾ"Not" ����0  */
int Palindrome_Test(char ch[])
{ 
	/***********************  ������д���***************************/
	char hw[50];
	int i=0;
	SeqStack myStack;
	myStack.top=-1;
	//  ��ջ
	while(Push_SeqStack(&myStack,ch[myStack.top+1]));
	//��ջ
	while(Pop_SeqStack(&myStack,&hw[i++]));
	hw[i]='\0';
	if(strcmp(ch,hw) == 0)
		return 1;
	else
		return 0;
	/**************************************************************/
}      /* Palindrome_Test */

main()                    /* ������ */
{ 
	char string[MaxSize];     /*����һ�ַ�����*/
	int i ;
	printf("Input string=");
	gets(string);              /*����һ���ַ���С��50����*/

	Palindrome_Test(string);  /*���û������жϺ��� */

	getchar();
}  /*�б�������ַ����Ƿ��ǻ������У����򷵻�1�����򷵻�0 */
