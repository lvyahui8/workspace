#include <stdafx.h>

void main()
{
	/*
	*	��Ŀ����������������m��n����
	*	�����Լ������С��������
	*	�������������շ������
	*/

	int a,b,q,r,temp;
	scanf("%d %d",&a,&b);
	if(a<b)
	{
		temp=a;
		a=b;
		b=temp;
	}
	q=a/b;
	r=a%b;
	while(r != 0)
	{
		q=b/r;
		temp=r;
		r=b%r;
	}
	printf("%d\n",temp);
}