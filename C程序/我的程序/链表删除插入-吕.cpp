/*
*	��ϰ��������Ĳ���
*	����������루�������������ɾ��������4������
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
    //  ���ﴴ������ͷ�ڵ������
	head=NULL;
	do
	{
		p=(Node*)malloc(LEN);
		scanf("%ld",&p->value);
		
		if(p->value ==0) break;
        //  ��һ�β���
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

	//Ѱ����ȷ��ɾ��λ�ã������ǰ�˳���������ֱ��������ڵĽڵ�
	while((current = *linkp)!=NULL  &&  current->value != del_value)
	{	
		linkp = &current->link;
	}

	if(NULL==current)
		return FALSE;
	else
	{
		//�Ѹýڵ�ɾ��������TRUE
		m_del=current->link;
		free(current);
		*linkp=m_del;
	}
	return TRUE;
}
//��Ҫ�β�Ϊ����ͷָ��ĵ�ַ��Ҫ�����ֵ
int insert(Node **linkp,int new_value){
    register Node * current;
	Node * m_new;

	//Ѱ����ȷ�Ĳ���λ�ã������ǰ�˳���������ֱ��������ֵ���ڻ�����²���ֵ�Ľڵ�
	while((current = *linkp)!=NULL  &&  current->value < new_value)
	{	
		linkp = &current->link;
	}
	//Ϊ�½ڵ�����ڴ棬������ֵ�浽�½ڵ��У��������ʧ�ܣ�����FALSE
	m_new =(Node*)malloc(LEN);
	if(NULL==m_new)
		return FALSE;
	m_new->value = new_value;
	//���½ڵ������������TRUE

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
	printf("����֮ǰ\n");
	print(head);
	if(TRUE==insert(&head,5)) //  �� 5 ����
	{
		printf("����֮��\n");
		print(head);
	}
	else
		printf("����ʧ��\n");
	
	if(TRUE==delet(&head,6)) //   �� 6 ɾ��
	{
		printf("ɾ��֮��\n");
		print(head);
	}
	else
		printf("ɾ��ʧ��\n");
}
