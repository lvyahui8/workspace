#include <stdio.h>
#include <malloc.h>

#define M 6			//迷宫的实际行数
#define N 8			//迷宫的实际列数

#define MAXSIZE 10		//栈的空间大小

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

//置空栈算法
SeqStack * Init_SeqStack(){
	SeqStack * s;
	s = (SeqStack *)malloc(sizeof SeqStack);		//申请栈的空间
	s->top = -1;									//初始化栈顶指针
	return s;
}
//判栈空算法
bool Empty_SeqStack(SeqStack *s){
	if( -1 == s->top )
		return 1;
	else
		return 0;
}
//入栈算法
bool Push_SeqStack(SeqStack * s,Next x){
	if(MAXSIZE-1 == s->top) return 0;
	else{
		s->top ++;
		s->data[s->top]=x;
		return 1;
	}
}
//出栈算法
bool Pop_SeqStack(SeqStack *s,Next * x){
	if(Empty_SeqStack(s))
		return 0;						//栈空不能出栈
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
	Push_SeqStack(s,temp);				//入口进栈
	
	while(!Empty_SeqStack(s)){
		Pop_SeqStack(s,&temp);
		x = temp.x;y = temp.y;d = temp.d + 1;	//回到上一个位置进行下一个方向的试探
		while(d<8){						//当前还有方向可试
			i = x + move[d].x;			//新点坐标
			j = y + move[d].y;
			if(0 == maze[i][j]){		//判断是否可到达
				temp.x = x;temp.y = y;temp.d = d;	//记录当前坐标和方向
				Push_SeqStack(s,temp);				//坐标及方向入栈
				x = i;y = j;maze[x][y] = -1;		//到达新点
				if(x == p.x && y == p.y) return 1;
				else d=0;							//不是出口继续试探
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
	{	printf("有路可走\n");return 1;}
	else
	{	printf("无路可走\n");return 0;}
}
