/*
void InitStack(Stack & s);						//	初始化栈
void Push(Stack & s,const ElemType & elem);		//	压栈----将elem压入栈
void Pop(Stack & s,ElemType & elem);			//	弹栈----将栈顶元素弹出到elem里
void GetTop(const Stack & s,ElemType & elem);	//	取栈顶----取栈顶的值放到elem里
void isEmpty(const Stack & s);					//	判断栈是否为空

//	在二叉树中查找元素X
//	返回值：
//	查找成功返回元素x节点的指针，查找不成功返回空(NULL)
BitNode * Search(BitNode * boot,const int x){
	Stack s;
	InitStack(s);
	Push(s,boot);
	BitNode * p;
	//		非递归中序遍历二叉树
	while ( ! isEmpty(s)) {
		while (GetTop(s,p) && p) {
			Push(s,p->lchild);
		}
		Pop(S,p);
		if (!isEmpty(s)) {
			Pop(s,p);
			if (p->data == x)	//	访问节点，判断节点的data域是否等于x
			{
				return p;
			}
			Push(s,p->rchild);
		}
	}
	return NULL;
}


BitNode * Search(BitNode * boot,const int x){
	BitNode * p = boot;
	while (p)
	{
		if (p->data==x)
		{
			return p;
		}
		else if (p->data>x)
		{
			p = p->lchild;
		}
		else{
			p = p->rchild;
		}
	}
	return NULL;
}




void del_link(Node *head,int x)
{ 
	If(NULL == head)
		Return;
	Node *p=head,*s;
	while(p->next)
	{
		s = p->next;
		while(s && s->data == x)
		{
			Node * temp = s;
			p->next=s->next;
			s = s->next;
			free(temp);
		}
		p=p->next;
	}
	If ( p == head){		//如果只有一个节点
		If(head->data == x){
			free(head);
		}
	}
}


{
	
}
*/
#include <stdio.h>
#include <malloc.h>
typedef struct Node{
	int data;
	struct Node * next;
}Node;

Node * create(){
	Node * head,* p,* tail;
	head=NULL;
	do
	{
		p=(Node*)malloc(sizeof Node);
		scanf("%d",&p->data);
		
		if(p->data ==0) 
		{	free(p);break;	}	//输入为0，表示输入结束。释放这个废节点

		if(head==NULL)
			head=p;
		else
			tail->next=p;
		tail=p;
	}
	while(1);
	tail->next=NULL;		//表尾指向为空
	return head;
}

//需要形参为链表头指针的地址和要插入的值
void del_link(Node ** plink,int x){
    register Node * current;
	//寻找真确的插入位置，方法是按顺序访问链表，直到到达其值大于或等于新插入值的节点
	while((current = *plink)!=NULL)
	{
		while(current && current->data == x){
			Node * temp = current;
			* plink = current = current->next;
			free(temp);
		}
		if (current)
		{
			plink = &current->next;
		}
	}
}

void del_linkAll(Node ** plink){
	register Node * current;
	while((current = *plink) != NULL){
		del_link(&current->next,current->data);
		plink = &current->next;
	}
}

void print(Node * loop)
{
	while(loop)
	{
		printf(" %d",loop->data);
		loop=loop->next;
	}
	putchar(10);
}
void main(){
	Node * head;
	head = create();
	print(head);
	// del_link(&head,5);
	del_linkAll(&head);
	print(head);
}