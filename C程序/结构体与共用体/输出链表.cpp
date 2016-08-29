#include <stdafx.h>
#include <stdlib.h>
#define LEN sizeof(struct stu)
struct stu
{
	long num;
	float score;
	struct stu * next;
};
int n=0;
/*
struct stu * create(void )
{
	struct stu * head,* p,* tail;
	head=NULL;
	p=(struct stu*)malloc(LEN);
	
	scanf("%ld %f",&p->num,&p->score);

	while(p->num !=0)
	{
		if(head==NULL)
			head=p;
		else
			tail->next=p;
		tail=p;
		p=(struct stu*)malloc(LEN);	
		scanf("%ld %f",&p->num,&p->score);
	}
	tail->next=NULL;
	return head;
}
*/
struct stu * create(void )
{
	struct stu * head,* p,* tail;
	head=NULL;
	do
	{
		p=(struct stu*)malloc(LEN);
		scanf("%ld",&p->num);
		if(p->num ==0) break;
		scanf("%f",&p->score);	
		if(head==NULL)
			head=p;
		else
			tail->next=p;
		tail=p;
	}
	while(1);
	tail->next=NULL;
	return head;
}
void print(struct stu * p)
{
	while(p != NULL)
	{
		printf("node[num=%ld,score=%.2f]\n",p->num,p->score);
		p=p->next;
	}
}
void main()
{
	struct stu * head;
	head=create();
	print(head);
}
