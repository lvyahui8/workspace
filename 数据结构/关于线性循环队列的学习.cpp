#include <stdio.h>
#include <malloc.h>

#define MAXSIZE 100
typedef struct{
	char data[MAXSIZE];		//���ݴ洢��
	int front,rear;			//��ͷ��βָ��
	int num;				//����Ԫ�صĸ���
} CSeQueue;

//�ÿ�ѭ�����㷨
CSeQueue * Init_SeQueue(){
	CSeQueue * q;
	q=(CSeQueue *)malloc(sizeof CSeQueue);
	q->front = q->rear = MAXSIZE-1;
	q->num = 0;
	return q;
}

//ѭ��������㷨
bool In_SeQueue(CSeQueue * q,char x){
	if(q->num == MAXSIZE){
		printf("����");
		return 0;			//�����������
	}
	else{
		q->rear = (q->rear + 1)%MAXSIZE;
		q->data[q->rear] = x;
		q->num++;
		return 1;
	}
}
//ѭ���ӳ����㷨
bool Out_SeQueue(CSeQueue * q,char * x){
	if(0 == q->num){
		printf("�ӿ�");
		return 0;
	}
	else{
		q->front = (q->front + 1)%MAXSIZE;
		*x = q->data[q->front];		//������ͷԪ��
		q->num--;
		return 1;
	}
}
//�ж�ѭ���ӿ��㷨
bool Empty_SeQueue(CSeQueue * q){
	if(0 == q->num)	return 1;
	else	return 0;
}

int main(){
	char ch;
	CSeQueue * myQueue = Init_SeQueue();
	if(NULL == myQueue){
		puts("����ʧ��");return 0;
	}
	while((ch=getchar()) != '#')
		In_SeQueue(myQueue,ch);
	while(Out_SeQueue(myQueue,&ch)){
		printf("%c ",ch);
	}
	putchar(10);
	return 1;
}