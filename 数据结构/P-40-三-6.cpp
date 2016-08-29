#include <stdio.h>
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
		
		if(p->value ==0) 
		{	free(p);break;	}	//����Ϊ0����ʾ����������ͷ�����Ͻڵ�

		if(head==NULL)
			head=p;
		else
			tail->link=p;
		tail=p;
	}
	while(1);
	tail->link=NULL;		//��βָ��Ϊ��
	return head;
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

void main()
{
	int x;
	Node * head;

	puts("��������");
	head=create();
	puts("�������");

	printf("������Ҫ�����ֵ x=");
	scanf("%d",&x);

	printf("����֮ǰ\n");
	print(head);

	if(TRUE==insert(&head,x)) //  �� 5 ����
	{
		printf("����֮��\n");
		print(head);
	}
	else
		printf("����ʧ��\n");

}