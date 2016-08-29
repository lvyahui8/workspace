/*__________________________________________________________________

�ó�����������һ����ͷ�ڵ㣬��ͷָ���ѭ���������У�ɾ��ĳһָ���ڵ��ǰ���ڵ�

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
	tail->link=head;			//��βָ���ͷ
	return head;
}
void Delete(Node *p)
{
	Node * loop=p,* prev=NULL;

	while(loop->link != p)		//�ҵ�pָ��ڵ��ǰһ���ڵ�
		loop=loop->link;

	prev=loop;

	while(prev->link != loop)	//�ҵ�pָ��ڵ��ǰһ���ڵ��ǰһ���ڵ�
		prev=prev->link;

	free(loop);					//ɾ��p��ǰ���ڵ�
	prev->link=p;				//ʹp��ǰ���ڵ�ָ��p
}

// ���ѭ��������Ҫһ��ָ������ڵ��ָ���Ҫ�����ѭ�������ߵĲ���
void print(Node * loop,int n)
{
	for(int i=1;i<=n;i++)
	{
		printf("Node[%x]==%d\n",loop,loop->value);
		loop=loop->link;
	}
}
void main()
{
	Node * ec,* p;
	ec=create();
	p=ec->link;

	Delete(p);					//ɾ��pָ��ڵ��ǰ���ڵ�

	print(p,9);					//9��ָҪ��ѭ���������� 9 ��
}