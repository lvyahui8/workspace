/*
*	练习单项链表的操作
*	程序包含输入（创建）、输出、删除、插入4个部分
*/
#include <stdafx.h>
#include <stdlib.h>

#define LEN sizeof Node
#define FALSE 0
#define TRUE  1

typedef struct NODE{
	struct NODE * link;
	int value;
} Node;


Node * create(){
	Node * head,* p,* tail;
    //  这里创建不带头节点的链表
	head=NULL;
	do
	{
		p=(Node*)malloc(LEN);
		scanf("%ld",&p->value);
		
		if(p->value ==0) break;
        //  第一次插入
		if(head==NULL)
			head=p;
		else
			tail->link=p;
		tail=p;
	}
	while(1);
	tail->link=NULL;
	return head;
}

int delet(Node **linkp,int del_value){
    register Node * current;
	Node * m_del;

	//寻找正确的删除位置，方法是按顺序访问链表，直到到达等于的节点
	while((current = *linkp)!=NULL  &&  current->value != del_value)
	{	
		linkp = &current->link;
	}

	if(NULL==current)
		return FALSE;
	else
	{
		//把该节点删除，返回TRUE
		m_del=current->link;
		free(current);
		*linkp=m_del;
	}
	return TRUE;
}
//需要形参为链表头指针的地址和要插入的值
int insert(Node **linkp,int new_value){
    register Node * current;
	Node * m_new;

	//寻找真确的插入位置，方法是按顺序访问链表，直到到达其值大于或等于新插入值的节点
	while((current = *linkp)!=NULL  &&  current->value < new_value)
	{	
		linkp = &current->link;
	}
	//为新节点分配内存，并把新值存到新节点中，如果分配失败，返回FALSE
	m_new =(Node*)malloc(LEN);
	if(NULL==m_new)
		return FALSE;
	m_new->value = new_value;
	//把新节点放入链表，返回TRUE

	m_new->link = current;
	*linkp=m_new;

	return TRUE;
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
	head=create();
	printf("插入之前\n");
	print(head);
	if(TRUE==insert(&head,5)) //  将 5 插入
	{
		printf("插入之后\n");
		print(head);
	}
	else
		printf("插入失败\n");
	
	if(TRUE==delet(&head,6)) //   将 6 删除
	{
		printf("删除之后\n");
		print(head);
	}
	else
		printf("删除失败\n");
}
