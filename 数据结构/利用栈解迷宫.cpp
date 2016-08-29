#include <stdio.h>
#include <malloc.h>

#define M 6			//�Թ���ʵ������
#define N 8			//�Թ���ʵ������

#define MAXSIZE 10		//ջ�Ŀռ��С

typedef struct{
	short x,y;
}item;

typedef struct{
	short x,y,d;
}Next;

typedef struct {
	Next data[MAXSIZE];
	short top;
} SeqStack;

//�ÿ�ջ�㷨
SeqStack * Init_SeqStack(){
	SeqStack * s;
	s = (SeqStack *)malloc(sizeof SeqStack);		//����ջ�Ŀռ�
	s->top = -1;									//��ʼ��ջ��ָ��
	return s;
}
//��ջ���㷨
bool Empty_SeqStack(SeqStack *s){
	if( -1 == s->top )
		return 1;
	else
		return 0;
}
//��ջ�㷨
bool Push_SeqStack(SeqStack * s,Next x){
	if(MAXSIZE-1 == s->top) return 0;
	else{
		s->top ++;
		s->data[s->top]=x;
		return 1;
	}
}
//��ջ�㷨
bool Pop_SeqStack(SeqStack *s,Next * x){
	if(Empty_SeqStack(s))
		return 0;						//ջ�ղ��ܳ�ջ
	else{
		*x = s->data[s->top];
		s->top--;
		return 1;
	}
}

bool path(short maze[][N+2],item p){
	item move[8]={
		{0,1},{1,1},{1,0},{1,-1},
		{0,-1},{-1,-1},{-1,0},{-1,1}};
	SeqStack *s;
	Next temp;
	short x,y,d,i,j;
	s = Init_SeqStack();
	temp.x = 1;temp.y = 1;temp.d = -1;
	Push_SeqStack(s,temp);				//��ڽ�ջ
	
	while(!Empty_SeqStack(s)){
		Pop_SeqStack(s,&temp);
		x = temp.x;y = temp.y;d = temp.d + 1;	//�ص���һ��λ�ý�����һ���������̽
		while(d<8){						//��ǰ���з������
			i = x + move[d].x;			//�µ�����
			j = y + move[d].y;
			if(0 == maze[i][j]){		//�ж��Ƿ�ɵ���
				temp.x = x;temp.y = y;temp.d = d;	//��¼��ǰ����ͷ���
				Push_SeqStack(s,temp);				//���꼰������ջ
				x = i;y = j;maze[x][y] = -1;		//�����µ�
				if(x == p.x && y == p.y) return 1;
				else d=0;							//���ǳ��ڼ�����̽
			}
			else d++;
		}
	}
	return 0;
}

bool main(){
	short maze[M+2][N+2]={
		{1,1,1,1,1,1,1,1,1,1},
		{1,0,1,1,1,0,1,1,1,1},
		{1,1,0,1,0,1,1,1,1,1},
		{1,0,1,0,0,0,0,0,1,1},
		{1,0,1,1,1,0,1,1,1,1},
		{1,1,0,0,1,1,0,0,0,1},
		{1,0,1,1,0,0,1,1,0,1},
		{1,1,1,1,1,1,1,1,1,1}
	};
	item exitus={5,7};
	if(path(maze,exitus))
	{	printf("��·����\n");return 1;}
	else
	{	printf("��·����\n");return 0;}
}
