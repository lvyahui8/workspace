

#include <stdafx.h>
#define M 2
#define DEBUG

struct personnel
{
	char name[20];
	int number;
};

void sort(struct personnel per[],int m)
{

}
void main()
{
	struct personnel per[M];
	int i; 
	for(i=0;i<M;i++)
	{
		//gets(per[i].name);
		scanf("%s",per[i].name);
		scanf("%d",&per[i].number);
	}
#ifdef DEBUG
	for(i=0;i<M;i++)
	{
		printf("personnel'name:%s personnel'number:%d\n",per[i].name,per[i].number);
	}
#endif
}

