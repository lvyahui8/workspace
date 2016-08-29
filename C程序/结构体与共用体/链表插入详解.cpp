/*
**插入到一个有序的单链表，函数参数为头指针和要插入的值。
*/
#include <stdafx.h>
#include <stdlib.h>

#define FALSE 0
#define TRUE  1

typedef struct NODE{
	struct NODE * link;
	int value;
} Node;
/*   1......
int sll_insert(Node *current,int new_value){
	Node * previous;
	Node * m_new;
	//寻找真确的插入位置，方法是按顺序访问链表，直到到达其值大于或等于新插入值的节点
	while(current->value < new_value){
		previous = current;
		current = current->link;
	}
	// 为新节点分配内存，并把新值存到新节点中，如果分配失败，返回FALSE
	m_new =(Node*)malloc(sizeof(Node));
	if(NULL==m_new)
		return FALSE;
	m_new->value = new_value;
	//把新节点放入链表，返回TRUE
	m_new->link=current;
	previous->link=m_new;
	return TRUE;
}
*/
/*   2......
int sll_insert(Node *current,int new_value){
	Node * previous;
	Node * m_new;
	//寻找真确的插入位置，方法是按顺序访问链表，直到到达其值大于或等于新插入值的节点
	while(current != NULL && current->value < new_value){
		previous = current;
		current = current->link;
	}
	// 为新节点分配内存，并把新值存到新节点中，如果分配失败，返回FALSE
	m_new =(Node*)malloc(sizeof(Node));
	if(NULL==m_new)
		return FALSE;
	m_new->value = new_value;
	//把新节点放入链表，返回TRUE
	m_new->link=current;
	previous->link=m_new;
	return TRUE;
}
*/
/*   3......
int sll_insert(Node **rootp,int new_value){
	Node * current;
	Node * previous;
	Node * m_new;
	// 得到指向第一个节点的指针。
	current = *rootp;
	previous=NULL;
	//寻找真确的插入位置，方法是按顺序访问链表，直到到达其值大于或等于新插入值的节点
	while(current != NULL && current->value < new_value){
		previous = current;
		current = current->link;
	}
	// 为新节点分配内存，并把新值存到新节点中，如果分配失败，返回FALSE
	m_new =(Node*)malloc(sizeof(Node));
	if(NULL==m_new)
		return FALSE;
	m_new->value = new_value;
	//把新节点放入链表，返回TRUE
	m_new->link = current;
	if(previous==NULL);
		*rootp = m_new;
	else
		previous->link=m_new;
	return TRUE;
}
*/

///*   4......
int sll_insert(Node **linkp,int new_value){
	register Node * current;
	Node * m_new;
	//寻找真确的插入位置，方法是按顺序访问链表，直到到达其值大于或等于新插入值的节点
	while((current = *linkp)!=NULL  &&  current->value < new_value){	
		linkp = &current->link;
	}
	// 为新节点分配内存，并把新值存到新节点中，如果分配失败，返回FALSE
	m_new =(Node*)malloc(sizeof(Node));
	if(NULL==m_new)
		return FALSE;
	m_new->value = new_value;
	//把新节点放入链表，返回TRUE
	m_new->link = current;
	*linkp=m_new;
	return TRUE;
}
//*/
void main()
{
	Node * root,* p;
	Node a,b,c;
	a.value=10;
	b.value=12;
	c.value=14;
	p=root=&a;
	a.link=&b;
	b.link=&c;
	c.link=NULL;

	do
	{
		printf("Node[value:%d]\n",p->value);
		p=p->link;
	}
	while(p!=NULL);
	sll_insert(&root,11);
	printf("\n");
	p=root;
	do
	{
		printf("Node[value:%d]\n",p->value);
		p=p->link;
	}
	while(p!=NULL);
}
