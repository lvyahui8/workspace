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
		*ppNode=p;			//	不必去判断是否是头节点
		ppNode = &p->next;
	} while(true);
	*ppNode = NULL;
	return head;
}
LNode * InversionLinkList(LNode * head){
	if (NULL == head) {
		return NULL;
	}
	LNode	*current = head;	//	当前节点
	LNode	*prior = NULL;		//	前一个节点
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

//	该函数的功能是查找链表中到数第backNum个节点，查找成功将节点的值存放到data里面，查找不成功则不对data进行任何操作。
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
//	该函数方法也是查找链表中倒数第backNum个节点，不同的是，该函数查找成功时，返回该节点的地址。如果查找不成功，将返回第一个节点的地址。
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
		p1 = p1->next;			//	p1走一步
		p2 = p2->next->next;	//	p2走两步
	}
	//这样当循环结束时，p1在尾部，p2在中部
	return p1;
}
//	在已知某节点地址的情况下删除某节点。
bool DelNode(LNode * head,LNode * pNode){
	if (NULL == pNode || NULL == head) {
		return false;
	}

	if (pNode->next != NULL) {	//	如果要删除的节点不是最后一个节点，就使用狸猫换太子的方法。
		LNode * pNext = pNode->next;
		pNode->data = pNode->next->data;
		pNode->next = pNode->next->next;
		delete pNext;
	}
	else {
		LNode *p = head;		//	否则只能从头遍历。
		while (p->next == pNode) {
			p->next = NULL;
		}
		delete pNode;
	}
	return true;
}
//	该函数合并两个链表，并返回合并后第一个节点的地址。
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
			*ppNode = p2;		//	再次使用二级指针减少判断次数
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
//	该函数的功能是 交换一个链表中的任意两个节点
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
	printf("倒数第 %d 个是: "NODE_INPUT_FORM "\n",4,data);
	printf("倒数第 %d 个是: "NODE_INPUT_FORM "\n",4,FindBackNumElem(head,4)->data);
	LNode * pMidNode = GetMiddleNode(head);
	printf("中间节点是："NODE_INPUT_FORM "\n",pMidNode->data);
	puts("删除中间节点");
	DelNode(head,pMidNode);
	ShowLinkList(head);
*/
/*
//	合并两个有序的链表
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