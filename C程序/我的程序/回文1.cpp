#include <stdafx.h>

int hw(int x)
{
	int z=0,temp;
	temp=x;//ѭ���иı��β�x��ֵ�������Ȱ�x��ֵ����temp�����Ÿ��������Ƚ�
	// ������
	while( x != 0 )
	{
		z=z*10+x%10;//ÿѭ��һ�Σ���z��ÿλ̧��һλ����λ��x mod 10��ֵ
		x=x/10;		//ÿѭ��һ�Σ���x�����λ����
	}
	//�ж��ǲ��ǻ�����
	if( z == temp )	
		return temp;
	else	
		return 0;
}

void main()
{
	int i,sum=0; 
	for(i=1;i<=10000;i++)
	{
		sum+=hw(i);
	}
	printf("1+...+9999(������)=%d\n",sum);
}

