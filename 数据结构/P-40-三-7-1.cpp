/*__________________________________________________________________

�ó��������ǽ�����˳������ĵ�����ϲ���һ��˳������ĵ�����
������ʹ�ú͵õ��Ķ���û��ͷ��������
___________________________________________________________________*/
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

Node * Merge(Node * h1,Node * h2)
{
	Node *head=NULL,*p=h1,*q=h2,* r=NULL;
	//	head��ϳ������ͷָ�롣	r ʼ��ָ��ϳ���������һ���ڵ�
	while(p != NULL && q != NULL)
	{
		if(p->value < q->value)
		{
			if(p==h1) head=p;
			else r->link=p;		//�ѽڵ�׷�ӵ��ϳ�����β��
			r=p;				//ʹrָ��ϳ��������Ľڵ�
			p=p->link;			//ָ������1��һ��Ҫ�Ƚϵ�Ԫ��
		}
		else
		{
			if(p==h2) head=q;
			else r->link=q;
			r=q;
			q=q->link;
		}
	}

	if(p==NULL)
		r->link=q;		//�������1�ȱ����ꡣ������2ʣ��Ĳ��ֽ��ںϳ�����β��
	else
		r->link=p;		//�������2�ȱ����ꡣ������1ʣ��Ĳ��ֽ��ںϳ�����β��
	return head;
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

	Node * head1, * head2;

	//��������
	printf("�����һ�������ֵ:");
	head1=create();
	printf("����ڶ��������ֵ:");
	head2=create();

	//�ϲ�����
	head1=Merge(head1,head2);

	//����ϲ�����
	printf("�ϲ�:\n");
	print(head1);
	putchar(10);
}
