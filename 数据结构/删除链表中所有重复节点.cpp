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
//	���ܣ�	ɾ������������ֵΪx�Ľڵ�
//	�βΣ�	1��������ͷ��㣬��������ͷָ��ĵ�ַ����&head
//			2������ͷ��㣬��������ͷ�ڵ��next��ĵ�ַ����&head->next
//	�βΣ�	Ϊ����ͷָ��ĵ�ַ��Ҫɾ����ֵ
void del_link(Node ** plink,int x){
    register Node * current;
	while((current = *plink)!=NULL)
	{
        // ������������x�����
		while(current && current->data == x){
            //  ����ָ����һ���ڵ��ָ��
			Node * temp = current;
			* plink = current = current->next;
            //  ɾ����ǰ�ڵ�
			free(temp);
		}
        
        //���±�������
		if (current)
		{
			plink = &current->next;
		}
	}
}
//	���ܣ�	ɾ���������ظ�����Ľڵ�
//	�βΣ�	1��������ͷ��㣬��������ͷָ��ĵ�ַ����&head
//			2������ͷ��㣬��������ͷ�ڵ��next��ĵ�ַ����&head->next
void del_linkAll(Node ** plink){
	register Node * current;
	while((current = *plink) != NULL){
        //ע�⣬����ȡָ����һ��Ԫ�ص�ָ��ĵ�ַ������ɾ���ǻᱣ����һ���ڵ�
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