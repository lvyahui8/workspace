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

void main()
{
	int x;
	Node * head;

	puts("创建链表");
	head=create();
	puts("创建完成");

	printf("请输入要插入的值 x=");
	scanf("%d",&x);

	printf("插入之前\n");
	print(head);

	if(TRUE==insert(&head,x)) //  将 5 插入
	{
		printf("插入之后\n");
		print(head);
	}
	else
		printf("插入失败\n");

}