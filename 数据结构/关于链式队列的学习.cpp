//����ʹ�õ��Ǵ�ͷ��������
#include <stdio.h>
#include <malloc.h>

#define MAXSIZE 100
typedef struct node{
	char data;
	struct node * next;
} QNode;

typedef struct{		//��ͷβָ���װ��һ�������
	QNode * front,* rear;
}LQueue;

//�ÿ������㷨
LQueue * Init_LQueue(){
	LQueue * q;
	QNode * p;
	q = (LQueue *)malloc(sizeof LQueue);		//����ͷβָ��ڵ�
	p = (QNode *)malloc(sizeof QNode);			//��������ͷ�ڵ�
	p->next = NULL;
	q->front = p;
	q->rear = p;
	return q;
}

//��������㷨
void In_LQueue(LQueue * q,char x){
	QNode *p;
	p = (QNode *)malloc(sizeof QNode);
	p->data = x;
	p->next = NULL;
	q->rear->next = p;		//��������ԭ�������Ԫ�ص�β��
	q->rear = p;			//ʹrear����ָ���µĶ�β
}

//�жԿ�
bool Empty_LQueue(LQueue *q){
	if(q->front == q->rear)	return 1;
	else	return 0;
}

//���ӳ����㷨
bool Out_LQueue(LQueue *q,char *x){
	QNode *p;
	if(Empty_LQueue(q)){
		printf("�Կ�");
		return 0;
	}
	else{
		p = q->front->next;			//��pָ��ԭ���еĵ�һ����Ч�ڵ�
		q->front->next = p->next;	//����ʹ��p->front = p,��Ϊ������ͷ�pָ����ڴ���
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
		puts("����ʧ��");return 0;
	}
	while((ch=getchar()) != '#')
		In_LQueue(myQueue,ch);
	while(Out_LQueue(myQueue,&ch)){
		printf("%c ",ch);
	}
	putchar(10);
}