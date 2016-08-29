#include <stdio.h>
#include <malloc.h>

typedef struct snode
{
	int data;
	struct snode *next;
} StackNode,*LinkStack;

//判断栈空算法
int Empty_LinkStack(LinkStack top)
{
	if(NULL == top)
		return 1;
	else
		return 0;
}
//入栈算法
LinkStack Push_LinkStack(LinkStack top,int x)
{
	StackNode * p = (StackNode *)malloc(sizeof StackNode);
	p->data = x;
	//使top指向新栈顶
	p->next = top;
	top = p;
	return top;		
}

//出栈算法
LinkStack Pop_LinkStack(LinkStack top,int *x)
{
	StackNode * p;
	if(NULL == top)
		return NULL;
	else
	{
		*x = top->data;
		p = top;
		//使top指向新栈顶
		top = top->next;
		free(p);
		return top;
	}
}

void main()
{
	StackNode * myS = NULL;
	int myX = -1;
	puts("入栈（直到输入为0为止）:");
	while(myX != 0)
	{
		scanf("%d",&myX);
		myS = Push_LinkStack(myS,myX);		//保证myS指针始终指向栈顶
	}

	puts("出栈:");
	while(myS=Pop_LinkStack(myS,&myX))		//当取到栈底时回先使myS为空，这时栈底取出来了，但是
		printf("%d\n",myX);					//还没有输出，就会跳出while循环，所以要在最后再输出一次。
	printf("%d\n",myX);
}
