#include <stdio.h>
#include <malloc.h>
#define MAXSIZE 1024

typedef struct {
	int data[MAXSIZE];
	int top;
} SeqStack;

//置空栈算法
SeqStack * Init_SeqStack(){
	SeqStack * s;
	s = (SeqStack *)malloc(sizeof SeqStack);		//申请栈的空间
	s->top = -1;									//初始化栈顶指针
	return s;
}
//判栈空算法
bool Empty_SeqStack(SeqStack *s){
	if( -1 == s->top )
		return 1;
	else
		return 0;
}
//入栈算法
bool Push_SeqStack(SeqStack * s,int x){
	if(MAXSIZE-1 == s->top) return 0;
	else{
		s->top ++;
		s->data[s->top]=x;
		return 1;
	}
}
//出栈算法
bool Pop_SeqStack(SeqStack *s,int * x){
	if(Empty_SeqStack(s))
		return 0;						//栈空不能出栈
	else{
		*x = s->data[s->top];
		s->top--;
		return 1;
	}
}
//取栈顶元素算法
bool Top_SeqStack(SeqStack *s,int *x){
	if(Empty_SeqStack(s))
		return 0;
	else{
		*x = s->data[s->top];
		return 1;
	}
}

void main(){
	SeqStack *myS;
	int myX = -1;
	myS = Init_SeqStack();
	
	puts("入栈（直到输入为0为止）:");
	while(myX != 0){
		scanf("%d",&myX);
		Push_SeqStack(myS,myX);
	}
	//取栈顶元素
	Top_SeqStack(myS,&myX);
	printf("栈顶值为:%d\n",myX);
	
	puts("出栈:");
	while(Pop_SeqStack(myS,&myX)){
		printf(" %d \n",myX);
	}
}