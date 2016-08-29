//以下使用的是带头结点的链表
#include <stdio.h>
#include <malloc.h>

#define MAXSIZE 100
typedef struct node{
	char data;
	struct node * next;
} QNode;

typedef struct{		//将头尾指针封装在一起的链队
	QNode * front,* rear;
}LQueue;

//置空链队算法
LQueue * Init_LQueue(){
	LQueue * q;
	QNode * p;
	q = (LQueue *)malloc(sizeof LQueue);		//申请头尾指针节点
	p = (QNode *)malloc(sizeof QNode);			//申请链队头节点
	p->next = NULL;
	q->front = p;
	q->rear = p;
	return q;
}

//链队入队算法
void In_LQueue(LQueue * q,char x){
	QNode *p;
	p = (QNode *)malloc(sizeof QNode);
	p->data = x;
	p->next = NULL;
	q->rear->next = p;		//将它接在原队列最后元素的尾部
	q->rear = p;			//使rear重新指向新的队尾
}

//判对空
bool Empty_LQueue(LQueue *q){
	if(q->front == q->rear)	return 1;
	else	return 0;
}

//链队出队算法
bool Out_LQueue(LQueue *q,char *x){
	QNode *p;
	if(Empty_LQueue(q)){
		printf("对空");
		return 0;
	}
	else{
		p = q->front->next;			//将p指向原队列的第一个有效节点
		q->front->next = p->next;	//不能使用p->front = p,因为后面会释放p指向的内存区
		*x = p->data;
		free(p);
		if(NULL == q->front->next)
			q->rear = q->front;
		return 1;
	}
}

bool main(){
	char ch;
	LQueue * myQueue = Init_LQueue();
		if(NULL == myQueue){
		puts("创队失败");return 0;
	}
	while((ch=getchar()) != '#')
		In_LQueue(myQueue,ch);
	while(Out_LQueue(myQueue,&ch)){
		printf("%c ",ch);
	}
	putchar(10);
}