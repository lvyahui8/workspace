/*__________________________________________________________________

该程序作用是在一个无头节点，无头指针的循环单链表中，删除某一指定节点的前驱节点

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
		{	free(p);break;	}	//输入为0，表示输入结束。释放这个废节点

		if(head==NULL)
			head=p;
		else
			tail->link=p;
		tail=p;
	}
	while(1);
	tail->link=head;			//表尾指向表头
	return head;
}
void Delete(Node *p)
{
	Node * loop=p,* prev=NULL;

	while(loop->link != p)		//找到p指向节点的前一个节点
		loop=loop->link;

	prev=loop;

	while(prev->link != loop)	//找到p指向节点的前一个节点的前一个节点
		prev=prev->link;

	free(loop);					//删除p的前驱节点
	prev->link=p;				//使p的前驱节点指向p
}

// 输出循环链，需要一个指向任意节点的指针和要在这个循环表里走的步数
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

	Delete(p);					//删除p指向节点的前驱节点

	print(p,9);					//9是指要在循环链表中走 9 步
}