#include <stdafx.h>

void hw(int x);

void main()
{
	int j,sum=0;// j ѭ������ 
	
	for(j=1;j<=10000;j++)
	{
		i=0;//ÿѭ��һ�ζ�i��λΪ0
		hw(j);//��j �����浽 i ��
		if(i==j)//����ǻ����� �����ӵ��ܺ���
			sum+=j;
	}

	printf("1+...+9999(������)=%d\n",sum);

}

void hw(int n)
{
	
	static int i=0;
	if( n != 0 )	
	{		
		i=i*10+n%10;		
		hw(n/10);	
	}
}