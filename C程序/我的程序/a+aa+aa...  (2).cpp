#include <stdafx.h>
#define DUG

//  ��x=2,y=3,�򷵻�  222
//  ��x=3,y=4,�򷵻�  3333   
// ���������׹��� ��
int cl(int x,int y)
{
	int i,temp=x;  
	for(i=1;i<y;i++)
	{
		x=x*10+temp;
	}
	return x;
}

void main()
{
	int a,b,c,sum=0;
	scanf("%d %d",&a,&b);
	printf("sum=");
	for(c=1;c<=b;c++)
	{
		printf("%d+",cl(a,c));
		sum=sum+cl(a,c);
	}
	
	printf("\b=%d\n",sum);
}

