#include <stdafx.h>

struct stu{
	long num;
	float score;
	struct stu * next;
};

void main(){
	struct stu a,b,c;
	struct stu *head,*p;
	
	a.num=20120102;
	a.score=89.5;
	b.num=20120103;
	b.score=91.7;
	c.num=20120104;
	c.score=88.3;

	p=head=&a;
	a.next=&b;
	b.next=&c;
	c.next=NULL;

	do
	{
		printf("%ld %.2f\n",p->num,p->score);
		p=p->next;
	}
	while(p!=NULL);
}