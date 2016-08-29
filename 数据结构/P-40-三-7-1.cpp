/*__________________________________________________________________

该程序作用是将两个顺序递增的单链表合并成一个顺序递增的单链表
本程序使用和得到的都是没有头结点的链表
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
	tail->link=NULL;		//表尾指向为空
	return head;
}

Node * Merge(Node * h1,Node * h2)
{
	Node *head=NULL,*p=h1,*q=h2,* r=NULL;
	//	head向合成链表的头指针。	r 始终指向合成链表的最后一个节点
	while(p != NULL && q != NULL)
	{
		if(p->value < q->value)
		{
			if(p==h1) head=p;
			else r->link=p;		//把节点追加到合成链表尾部
			r=p;				//使r指向合成链表最后的节点
			p=p->link;			//指向链表1下一个要比较的元素
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
		r->link=q;		//如果链表1先遍历完。把链表2剩余的部分接在合成链表尾部
	else
		r->link=p;		//如果链表2先遍历完。把链表1剩余的部分接在合成链表尾部
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

	//创建链表
	printf("输入第一个链表的值:");
	head1=create();
	printf("输入第二个链表的值:");
	head2=create();

	//合并链表
	head1=Merge(head1,head2);

	//输出合并链表
	printf("合并:\n");
	print(head1);
	putchar(10);
}
