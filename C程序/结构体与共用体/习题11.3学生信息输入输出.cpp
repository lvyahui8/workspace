#include <stdafx.h>

typedef struct stu
{
	int num;
	char name[20];
	float score[3];
} STU;

void print(STU * p,int n)
{
	for(int i=0;i<n-1;i++)
	{
		printf("%d %s %f %f %f\n",
			(p+i)->num,(p+i)->name,
			(p+i)->score[0],(p+i)->score[1],(p+i)->score[2]);
	}
}

void main()
{
	STU st[5];
	for(int i=0;i<5;i++)
	{
		printf("input s[%d]:\n",i);
		scanf("%d %s %f %f %f",&st[i].num,st[i].name,
			&st[i].score[0],&st[i].score[1],
			&st[i].score[2] );
	}
	print(st,5);
}