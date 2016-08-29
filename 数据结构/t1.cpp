#include <stdio.h>
#include <string.h>

#define MaxSize 50
typedef struct {              /* 定义栈结构 */
	char data[MaxSize];
	int top;
}SeqStack; 

SeqStack *S;

int Push_SeqStack(SeqStack *s,char x)  /* 元素入栈函数 */
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

int Empty_SeqStack(SeqStack *S)    /* 判空栈函数 */
{ 
	if (S->top==-1)
		return 1;
	else
		return 0;
}

int Pop_SeqStack(SeqStack *s,char *x)   /* 元素出栈函数 */
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

/* 以下是判别字符串是否是回文序列的函数，是则提示"Yes" 返回1，*/
/* 否则提示"Not" 返回0  */
int Palindrome_Test(char ch[])
{ 
	/***********************  完成下列代码***************************/
	char hw[50];
	int i=0;
	SeqStack myStack;
	myStack.top=-1;
	//  入栈
	while(Push_SeqStack(&myStack,ch[myStack.top+1]));
	//出栈
	while(Pop_SeqStack(&myStack,&hw[i++]));
	hw[i]='\0';
	if(strcmp(ch,hw) == 0)
		return 1;
	else
		return 0;
	/**************************************************************/
}      /* Palindrome_Test */

main()                    /* 主函数 */
{ 
	char string[MaxSize];     /*定义一字符数组*/
	int i ;
	printf("Input string=");
	gets(string);              /*输入一串字符（小于50个）*/

	Palindrome_Test(string);  /*调用回文数判断函数 */

	getchar();
}  /*判别输入的字符串是否是回文序列，是则返回1，否则返回0 */
