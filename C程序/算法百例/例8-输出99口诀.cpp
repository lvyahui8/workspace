#include <stdafx.h>

void main()
{
	/*
	��Ŀ�����9*9�ھ��� 
	1.����������������п��ǣ���9��9�У�i��
	���У�j�����С� 
	2.����Դ���룺
	*/
	for(int i=1;i<=9;i++)
	{
		for(int j=1;j<=i;j++)
		{
			printf("%d*%d=%d  ",j,i,j*i);
		}
		printf("\n");
	}
}