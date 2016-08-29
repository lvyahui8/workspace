#include <stdafx.h>
/*
int * search(int n,int (*p)[4])
{
	return *(p+n); // *(p+n)==score[n];
}
*/

int * search(int (*p)[4])
{
	int i=0;
	for(;i<4;i++)
	{
		if( *(*p+i) < 60 )
		{
			return *(p+1);
		}
	}
	return *p;
}

void main()
{
	int score[][4]={{1,2,3,4},{5,6,7,8},{9,10,11,12}};
	//score  score[0] score[1] score[3]
	/*int * p=search(2,score);
	int i;
	for(i=0;i<4;i++)
	{
		printf("%d ",*(p+i));
	}*/

	int i,j;
	int *p;
	for(i=0;i<3;i++)
	{
		p=search(score+i);
		if(p != *(score+i))
		{
			printf("student number=%d\n",i);
			for(j=0;j<4;j++)
			{
				printf("%d ", *(*(score+i)+j) );
			}
			putchar('\n');
		}
	}
}

