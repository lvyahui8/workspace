//#include <stdafx.h>
#include <stdio.h>

int main()
{
    int a,x,sum=0,temp;
	for(x=1;x<=10000;x++)//forѭ��������ýӻ����ţ���ѭ����д�ڻ��������档�����Ĭ��Ϊ��� ; ��ֹ��һ����Ϊѭ����
	{
		a=0;	// a�������浹�����ģ�ÿ��ѭ��Ҫ��λΪ0
		temp=x;	// x��ѭ�����������ֱ���� x ������������ʹfor�����ѭ����������temp��������
		while(temp!=0)
		{
			a=a*10+temp%10;
			temp/=10;
		}
		if(x==a)
		{
			sum=sum+a;
		}	
	}
	printf("sum=%d\n",sum);
	return 0;
}
