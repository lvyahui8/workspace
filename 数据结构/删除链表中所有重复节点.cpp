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
//	功能：	删除链表中所有值为x的节点
//	形参：	1、若不带头结点，便是链表头指针的地址，即&head
//			2、若带头结点，便是链表头节点的next域的地址，即&head->next
//	形参：	为链表头指针的地址和要删除的值
void del_link(Node ** plink,int x){
    register Node * current;
	while((current = *plink)!=NULL)
	{
        // 处理连续出现x的情况
		while(current && current->data == x){
            //  保留指向下一个节点的指针
			Node * temp = current;
			* plink = current = current->next;
            //  删除当前节点
			free(temp);
		}
        
        //向下遍历链表
		if (current)
		{
			plink = &current->next;
		}
	}
}
//	功能：	删除链表中重复多余的节点
//	形参：	1、若不带头结点，便是链表头指针的地址，即&head
//			2、若带头结点，便是链表头节点的next域的地址，即&head->next
void del_linkAll(Node ** plink){
	register Node * current;
	while((current = *plink) != NULL){
        //注意，这里取指向下一个元素的指针的地址，这样删除是会保留这一个节点
		del_link(&current->next,current->data);
		plink = &current->next;
	}
}

void print(Node * loop)
{
	while(loop)
	{
		printf(" %2d",loop->data);
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