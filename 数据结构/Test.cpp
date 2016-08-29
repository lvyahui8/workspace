/*
void InitStack(Stack & s);						//	��ʼ��ջ
void Push(Stack & s,const ElemType & elem);		//	ѹջ----��elemѹ��ջ
void Pop(Stack & s,ElemType & elem);			//	��ջ----��ջ��Ԫ�ص�����elem��
void GetTop(const Stack & s,ElemType & elem);	//	ȡջ��----ȡջ����ֵ�ŵ�elem��
void isEmpty(const Stack & s);					//	�ж�ջ�Ƿ�Ϊ��

//	�ڶ������в���Ԫ��X
//	����ֵ��
//	���ҳɹ�����Ԫ��x�ڵ��ָ�룬���Ҳ��ɹ����ؿ�(NULL)
BitNode * Search(BitNode * boot,const int x){
	Stack s;
	InitStack(s);
	Push(s,boot);
	BitNode * p;
	//		�ǵݹ��������������
	while ( ! isEmpty(s)) {
		while (GetTop(s,p) && p) {
			Push(s,p->lchild);
		}
		Pop(S,p);
		if (!isEmpty(s)) {
			Pop(s,p);
			if (p->data == x)	//	���ʽڵ㣬�жϽڵ��data���Ƿ����x
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
	If ( p == head){		//���ֻ��һ���ڵ�
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
		{	free(p);break;	}	//����Ϊ0����ʾ����������ͷ�����Ͻڵ�

		if(head==NULL)
			head=p;
		else
			tail->next=p;
		tail=p;
	}
	while(1);
	tail->next=NULL;		//��βָ��Ϊ��
	return head;
}

//��Ҫ�β�Ϊ����ͷָ��ĵ�ַ��Ҫ�����ֵ
void del_link(Node ** plink,int x){
    register Node * current;
	//Ѱ����ȷ�Ĳ���λ�ã������ǰ�˳���������ֱ��������ֵ���ڻ�����²���ֵ�Ľڵ�
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