#include <stdafx.h>
//计算总平均分数
float average(float * p,int n)
{
	float * start;
	float sum=0.0;
	for(start=p;p<=start+n-1;p++)
	{
		sum+=*p;
	}
	return sum/n;
}

void search(float (*p)[4],int n)
{			//  (*p)==p[] 
	int i;
	for(i=0;i<4;i++)
		printf("%f ",*(*(p+n)+i));
	printf("\n");

}

void scan(float (*p)[4],int n)
{
	int i,j,flag;
	for(i=0;i<n;i++)
	{
		flag =0;
		for(j=0;j<4;j++)
		{
			if(*(*(p+i)+j) < 60.0)
			{
				flag=1;
				break;
			}
		}
		if(1==flag)
		{
			printf("%d:",i);
			for(j=0;j<4;j++)
				printf("%f ",*(*(p+i)+j));
			printf("\n");
		}
	}

}

void main()
{
	// 3名学生，4门课程
	float score[3][4]={{68,67,6,69},{66,68,49,70},{80,78,77,79}};

	printf("average=%f\n",average(*score,12)); //*score==score[0]
	
	search(score,2);

	scan(score,3);
}

