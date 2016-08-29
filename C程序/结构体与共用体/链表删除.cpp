#include <stdafx.h>
#include <stdlib.h>
#define LEN sizeof(struct stu)

struct stu
{
	long num;
	float score;
	struct stu * next;
};

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

struct stu *del(struct stu * head,long num)
{
	struct stu *p1,*p2;// p2指向要删除的结点
	if(head==NULL)
		return head;
	else
	{
		p2=head;
		p1=NULL;
		while(p2 != NULL && p2->num != num)
		{
			p1=p2;
			p2=p2->next;
		}
		if(p2!=NULL)
			if(p2->num ==num)
			{
				if(p2==head)
					head=p2->next;
				else
					p1->next=p2->next;
				free(p2);
			}
	}
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
	printf("删除之前\n");
	print(head);
	head=del(head,2);
	printf("删除之后\n");
	print(head);
}
