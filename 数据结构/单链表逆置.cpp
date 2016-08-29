#include "stdio.h"
#include <malloc.h>

#define LEN sizeof Node
#define FALSE 0
#define TRUE  1

typedef struct node{
	int value;		
	struct node * link;	
} Node;

Node * create(){
	Node * head,* p,* tail;
	head=NULL;
	do
	{
		p=(Node*)malloc(LEN);
		scanf("%ld",&p->value);
		
		if(0 == p->value) 
		{	free(p);break;	}	//输入为0，表示输入结束。释放这个废节点

		if(NULL == head)		//	每一次都去判断	浪费时间
			head=p;
		else
			tail->link=p;
		tail=p;
	}
	while(1);
	tail->link=NULL;		//表尾指向为空
	return head;
}
/*
Node * fnReverse(Node * head){
	Node * p, *q;
	p = head;
	q = p->link;
	p->link = NULL;
	while(q){
		head = q->link;
		q->link = p;
		p = q;
		q = head;
	}
	return p;
}
*/
Node * fnReverse(Node * head){
	Node * p,*q;
	q= head;
	p = head->link;
	head = NULL;
	while(p)
	{	
        //  接到新链表里面去
		q->link = head; 
		head  = q;
        //  继续遍历原来的链表
		q = p;
		p = p->link;
	}
	q->link = head; 
	head  = q;
	return  head;
}

void print(Node * p){
	while(p != NULL)
	{
		printf("node[value==%d]\n",p->value);
		p=p->link;
	}
}

void main(){
	Node * head;
	head = create();
	print(head);
	head = fnReverse(head);
	print(head);
}
