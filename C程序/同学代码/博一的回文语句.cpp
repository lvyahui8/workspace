/*
Ŀ�꣺
�ж��Ƿ�Ϊ��������ʹ�ú����ĵݹ����

�ƻ���
����һ����һ������

 ����һ�����飬����������ִ洢����ͷ���ú����ĵݹ�����Ƿ�ת�����´洢

 ���ַ���Ӧ��ASC�������a[1]-a[n],a[2]-a[n-1]....

 �����в�ֵ֮��0ʱ��֤�����ǻ������
 
�����ǻ������

*/

#include "stdafx.h"
#include "string.h"				//�����ַ�ת����strlen(c)������

void reverse();void judge(int n);int xunhuan(int n);

char temp[20];
char c[20];
void main()
{	
	printf("�˳����ǿ��֮�����������������жϻ�������������������ĸ�����ı����Ŷ���ʤ�Σ�\n\n\n");
	printf("���磤��##   ����wanggnaw    ����119911   �����Եģ��˳���ǿ��\n");
	printf("������������һ���ַ��������ǿ������ǲ��ǻ������\n");
	reverse();

	
}

void reverse()			//��ת���������԰�����ĺ�����ת����
{
	
	int p=0;
	int n;
	int i;
	
		
	scanf("%s",c);
	n=strlen(c);
	printf("��ת֮ǰ��\n%s\n",c);

	
	
	for(i=n-1;i>=0;i--)
	{
		temp[p]=c[i];
		p++;
	}
	temp[p]='\0';

	for(i=0;i<n;i++)
		c[i]=temp[i];
	
	printf("��ת֮��\n");
	printf("%s\n",c);

	judge(strlen(c));				//�Ұѻ��������жϺ�����Ƕ�ڷ�ת�����б���ֱ������scanf��ͷ������c���ַ�������û�а����ŵ�������main������ͷȥ

	
}


void judge(int n)					//�ж��Ƿ�Ϊ������
{
	int sum=0;

	sum=xunhuan(strlen(c));

	if(sum==0)									//������е��ַ�����Ӧ��ȣ����ֵӦ��Ϊ0
		printf("\n\n���Ϊ��\n��Ϊ�������\n");
	else
		printf("\n\n���Ϊ��\n��Ϊ������\n");
}


int xunhuan(int n)							//�ڴ˴������˺����ĵݹ������ԭ����for�����ɵ�ѭ��
{
	int b;
	int sum_1=0;
	int a;
	int f=0;
	
	a=temp[f]-c[n-1];
	f++;
	sum_1=sum_1+a;					//�����ַ���Ӧ��ASC�������a[1]-a[n],a[2]-a[n-1]....���Ѳ�ֵ��͸�sum
	
	if(b>=(n/2))
		return xunhuan(strlen(c)-1);			
	else if(b<(n/2))					
		return sum_1;
}


/*
���Ǻ����ݹ�int xunhuan(int n)��ԭģ�壺
	for(b=n-1;b>=(n/2);b--)
	{
		a=temp[f]-c[b];
		f++;
		sum=sum+a;
	}
*/