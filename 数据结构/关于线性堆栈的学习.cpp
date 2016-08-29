#include <stdio.h>
#include <malloc.h>
#define MAXSIZE 1024

typedef struct {
	int data[MAXSIZE];
	int top;
} SeqStack;

//�ÿ�ջ�㷨
SeqStack * Init_SeqStack(){
	SeqStack * s;
	s = (SeqStack *)malloc(sizeof SeqStack);		//����ջ�Ŀռ�
	s->top = -1;									//��ʼ��ջ��ָ��
	return s;
}
//��ջ���㷨
bool Empty_SeqStack(SeqStack *s){
	if( -1 == s->top )
		return 1;
	else
		return 0;
}
//��ջ�㷨
bool Push_SeqStack(SeqStack * s,int x){
	if(MAXSIZE-1 == s->top) return 0;
	else{
		s->top ++;
		s->data[s->top]=x;
		return 1;
	}
}
//��ջ�㷨
bool Pop_SeqStack(SeqStack *s,int * x){
	if(Empty_SeqStack(s))
		return 0;						//ջ�ղ��ܳ�ջ
	else{
		*x = s->data[s->top];
		s->top--;
		return 1;
	}
}
//ȡջ��Ԫ���㷨
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
	
	puts("��ջ��ֱ������Ϊ0Ϊֹ��:");
	while(myX != 0){
		scanf("%d",&myX);
		Push_SeqStack(myS,myX);
	}
	//ȡջ��Ԫ��
	Top_SeqStack(myS,&myX);
	printf("ջ��ֵΪ:%d\n",myX);
	
	puts("��ջ:");
	while(Pop_SeqStack(myS,&myX)){
		printf(" %d \n",myX);
	}
}