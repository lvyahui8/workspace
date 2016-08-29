#include "LinkList.h"
#include <stdio.h>
LNode * CreateLinkList(){
	LNode	*head=NULL;
	LNode	**ppNode = &head;
	LNode	*p =NULL;
	do {
		p =	new	LNode;
		if (NULL==p) {
			break;
		}
		scanf(NODE_INPUT_FORM,&p->data);
		if (0 == p->data) {
			delete p;
			break;
		}
		*ppNode=p;			//	����ȥ�ж��Ƿ���ͷ�ڵ�
		ppNode = &p->next;
	} while(true);
	*ppNode = NULL;
	return head;
}
LNode * InversionLinkList(LNode * head){
	if (NULL == head) {
		return NULL;
	}
	LNode	*current = head;	//	��ǰ�ڵ�
	LNode	*prior = NULL;		//	ǰһ���ڵ�
	while (current) {
		head = current->next;
		current->next =prior;
		prior = current;
		current = head;
	}
	return prior;
}

void ShowLinkList(LNode * head){
	LNode	*p=head;
	while (p!=NULL) {
		printf(NODE_INPUT_FORM "  ",p->data);
		p = p->next;
	}
	putchar(10);
}

//	�ú����Ĺ����ǲ��������е�����backNum���ڵ㣬���ҳɹ����ڵ��ֵ��ŵ�data���棬���Ҳ��ɹ��򲻶�data�����κβ�����
void FindBackNumElem(LNode * head,const int & backNum,DATA &data){
	static int number = 0;
	if(NULL == head){
		return;
	}
	FindBackNumElem(head->next,backNum,data);
	number++;
	if (backNum == number) {
		data = head->data;
	}
}
//	�ú�������Ҳ�ǲ��������е�����backNum���ڵ㣬��ͬ���ǣ��ú������ҳɹ�ʱ�����ظýڵ�ĵ�ַ��������Ҳ��ɹ��������ص�һ���ڵ�ĵ�ַ��
LNode * FindBackNumElem(LNode * head,const int & backNum){
	
	if (NULL == head)
	{
		return NULL;
	}
	LNode * p1 ,*p2;
	p1=p2= head;
	for (int i=0;i<backNum && p1;i++) {
		p1 = p1->next;
	}
	while (p1) {
		p1 = p1->next;
		p2 = p2->next;
	}
	return p2;
}

LNode * GetMiddleNode(LNode *head){
	if (NULL == head){
		return NULL;
	}
	LNode * p1,*p2;
	p1 = p2 =head;
	while (p2 && p2->next) {
		p1 = p1->next;			//	p1��һ��
		p2 = p2->next->next;	//	p2������
	}
	//������ѭ������ʱ��p1��β����p2���в�
	return p1;
}
//	����֪ĳ�ڵ��ַ�������ɾ��ĳ�ڵ㡣
bool DelNode(LNode * head,LNode * pNode){
	if (NULL == pNode || NULL == head) {
		return false;
	}

	if (pNode->next != NULL) {	//	���Ҫɾ���Ľڵ㲻�����һ���ڵ㣬��ʹ����è��̫�ӵķ�����
		LNode * pNext = pNode->next;
		pNode->data = pNode->next->data;
		pNode->next = pNode->next->next;
		delete pNext;
	}
	else {
		LNode *p = head;		//	����ֻ�ܴ�ͷ������
		while (p->next == pNode) {
			p->next = NULL;
		}
		delete pNode;
	}
	return true;
}
//	�ú����ϲ��������������غϲ����һ���ڵ�ĵ�ַ��
LNode * MergeLinkList(LNode * head1,LNode *head2){
	if (NULL == head1) {
		return head2;
	}
	if (NULL == head2) {
		return head1;
	}
	LNode *p1=head1,*p2=head2;
	LNode *head=NULL;
	LNode ** ppNode=&head;
	while (p1&&p2) {
		if (p1->data > p2->data) {
			*ppNode = p2;		//	�ٴ�ʹ�ö���ָ������жϴ���
			ppNode = &p2->next;
			p2 = p2->next;
		}
		else {
			*ppNode = p1;
			ppNode = &p1->next;
			p1 = p1->next;
		}
	}
	
	if (NULL == p1) {
		*ppNode = p2;
	}
	else{
		*ppNode =p1;
	}

	return head;
}
//	�ú����Ĺ����� ����һ�������е����������ڵ�
void SwapNode(LNode *head,LNode * p,LNode * q){
	if (NULL == head || NULL ==p || NULL == q || p==q) {
		return;
	}
	LNode ** ppInP, **ppInQ;
	ppInP = NULL;
	ppInQ = NULL;
	LNode ** ppNode = &head;
	
	while (*ppNode && (!ppInP || !ppInQ)) {
		if (*ppNode == p) {
			ppInP = ppNode;
		}
		else if(*ppNode == q){
			ppInQ = ppNode;
		}
		ppNode = &((*ppNode)->next);
	}
	if (ppInP && ppInQ) {
		* ppInP = q;
		* ppInQ = p;
		LNode * temp;
		temp = p->next;
		p->next = q->next;
		q->next = temp;
	}
}
void main(){
	LNode	*head;
	head = CreateLinkList();
	ShowLinkList(head);
/*
	head = InversionLinkList(head);
	ShowLinkList(head);
	DATA	data;
	FindBackNumElem(head,4,data);
	printf("������ %d ����: "NODE_INPUT_FORM "\n",4,data);
	printf("������ %d ����: "NODE_INPUT_FORM "\n",4,FindBackNumElem(head,4)->data);
	LNode * pMidNode = GetMiddleNode(head);
	printf("�м�ڵ��ǣ�"NODE_INPUT_FORM "\n",pMidNode->data);
	puts("ɾ���м�ڵ�");
	DelNode(head,pMidNode);
	ShowLinkList(head);
*/
/*
//	�ϲ��������������
	LNode * head1;
	head1 = CreateLinkList();
	ShowLinkList(head1);
	LNode *h;
	h = MergeLinkList(head,head1);
	ShowLinkList(h);
*/

//	LNode *p =FindBackNumElem(head,3);
//	LNode *q =FindBackNumElem(head,6);
//	SwapNode(head,p,q);
//	ShowLinkList(head);
}