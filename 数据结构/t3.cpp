#include <stdio.h>
#include <malloc.h>

typedef struct snode
{
	int data;
	struct snode *next;
} StackNode,*LinkStack;

//�ж�ջ���㷨
int Empty_LinkStack(LinkStack top)
{
	if(NULL == top)
		return 1;
	else
		return 0;
}
//��ջ�㷨
LinkStack Push_LinkStack(LinkStack top,int x)
{
	StackNode * p = (StackNode *)malloc(sizeof StackNode);
	p->data = x;
	//ʹtopָ����ջ��
	p->next = top;
	top = p;
	return top;		
}

//��ջ�㷨
LinkStack Pop_LinkStack(LinkStack top,int *x)
{
	StackNode * p;
	if(NULL == top)
		return NULL;
	else
	{
		*x = top->data;
		p = top;
		//ʹtopָ����ջ��
		top = top->next;
		free(p);
		return top;
	}
}

void main()
{
	StackNode * myS = NULL;
	int myX = -1;
	puts("��ջ��ֱ������Ϊ0Ϊֹ��:");
	while(myX != 0)
	{
		scanf("%d",&myX);
		myS = Push_LinkStack(myS,myX);		//��֤mySָ��ʼ��ָ��ջ��
	}

	puts("��ջ:");
	while(myS=Pop_LinkStack(myS,&myX))		//��ȡ��ջ��ʱ����ʹmySΪ�գ���ʱջ��ȡ�����ˣ�����
		printf("%d\n",myX);					//��û��������ͻ�����whileѭ��������Ҫ����������һ�Ρ�
	printf("%d\n",myX);
}
