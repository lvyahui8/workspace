#include <stdafx.h>


void main()
{
	int z,temp;
	int i,sum=0; 

	for(i=1;i<=10000;i++)
	{
		z=0;	//ÿ��ѭ����ı�z��ֵ������Ҫ���µ���Ϊ0
		temp=i; //�����в��ܸı�i��ֵ�������Ȱ�i��ֵ����temp����temp���в���
		// ������
		while( temp != 0 )
		{
			z=z*10+temp%10;	//ÿѭ��һ�Σ���zÿλ̧��һλ����λ��temp mod 10��ֵ
			temp=temp/10;	//ÿѭ��һ�Σ���temp�����λ����
		}
		//�ж��ǲ��ǻ�����
		if(i==z)
		{
			sum=sum+z;
		}
	}
	printf("1+...+9999(������)=%d\n",sum);
}
