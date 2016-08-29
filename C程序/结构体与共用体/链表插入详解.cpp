/*
**���뵽һ������ĵ�������������Ϊͷָ���Ҫ�����ֵ��
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
	//Ѱ����ȷ�Ĳ���λ�ã������ǰ�˳���������ֱ��������ֵ���ڻ�����²���ֵ�Ľڵ�
	while(current->value < new_value){
		previous = current;
		current = current->link;
	}
	// Ϊ�½ڵ�����ڴ棬������ֵ�浽�½ڵ��У��������ʧ�ܣ�����FALSE
	m_new =(Node*)malloc(sizeof(Node));
	if(NULL==m_new)
		return FALSE;
	m_new->value = new_value;
	//���½ڵ������������TRUE
	m_new->link=current;
	previous->link=m_new;
	return TRUE;
}
*/
/*   2......
int sll_insert(Node *current,int new_value){
	Node * previous;
	Node * m_new;
	//Ѱ����ȷ�Ĳ���λ�ã������ǰ�˳���������ֱ��������ֵ���ڻ�����²���ֵ�Ľڵ�
	while(current != NULL && current->value < new_value){
		previous = current;
		current = current->link;
	}
	// Ϊ�½ڵ�����ڴ棬������ֵ�浽�½ڵ��У��������ʧ�ܣ�����FALSE
	m_new =(Node*)malloc(sizeof(Node));
	if(NULL==m_new)
		return FALSE;
	m_new->value = new_value;
	//���½ڵ������������TRUE
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
	// �õ�ָ���һ���ڵ��ָ�롣
	current = *rootp;
	previous=NULL;
	//Ѱ����ȷ�Ĳ���λ�ã������ǰ�˳���������ֱ��������ֵ���ڻ�����²���ֵ�Ľڵ�
	while(current != NULL && current->value < new_value){
		previous = current;
		current = current->link;
	}
	// Ϊ�½ڵ�����ڴ棬������ֵ�浽�½ڵ��У��������ʧ�ܣ�����FALSE
	m_new =(Node*)malloc(sizeof(Node));
	if(NULL==m_new)
		return FALSE;
	m_new->value = new_value;
	//���½ڵ������������TRUE
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
	//Ѱ����ȷ�Ĳ���λ�ã������ǰ�˳���������ֱ��������ֵ���ڻ�����²���ֵ�Ľڵ�
	while((current = *linkp)!=NULL  &&  current->value < new_value){	
		linkp = &current->link;
	}
	// Ϊ�½ڵ�����ڴ棬������ֵ�浽�½ڵ��У��������ʧ�ܣ�����FALSE
	m_new =(Node*)malloc(sizeof(Node));
	if(NULL==m_new)
		return FALSE;
	m_new->value = new_value;
	//���½ڵ������������TRUE
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
