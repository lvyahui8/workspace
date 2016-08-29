#include <stdio.h>
#include <malloc.h>

#define MAXSIZE 100
typedef struct{
	char data[MAXSIZE];		//数据存储区
	int front,rear;			//队头队尾指针
	int num;				//队中元素的个数
} CSeQueue;

//置空循环队算法
CSeQueue * Init_SeQueue(){
	CSeQueue * q;
	q=(CSeQueue *)malloc(sizeof CSeQueue);
	q->front = q->rear = MAXSIZE-1;
	q->num = 0;
	return q;
}

//循环队入队算法
bool In_SeQueue(CSeQueue * q,char x){
	if(q->num == MAXSIZE){
		printf("队满");
		return 0;			//队满不能入队
	}
	else{
		q->rear = (q->rear + 1)%MAXSIZE;
		q->data[q->rear] = x;
		q->num++;
		return 1;
	}
}
//循环队出队算法
bool Out_SeQueue(CSeQueue * q,char * x){
	if(0 == q->num){
		printf("队空");
		return 0;
	}
	else{
		q->front = (q->front + 1)%MAXSIZE;
		*x = q->data[q->front];		//读出队头元素
		q->num--;
		return 1;
	}
}
//判断循环队空算法
bool Empty_SeQueue(CSeQueue * q){
	if(0 == q->num)	return 1;
	else	return 0;
}

int main(){
	char ch;
	CSeQueue * myQueue = Init_SeQueue();
	if(NULL == myQueue){
		puts("创队失败");return 0;
	}
	while((ch=getchar()) != '#')
		In_SeQueue(myQueue,ch);
	while(Out_SeQueue(myQueue,&ch)){
		printf("%c ",ch);
	}
	putchar(10);
	return 1;
}