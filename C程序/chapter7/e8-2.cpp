#include <stdafx.h>

int max(int x,int y)
{
	//�ȼ� return x>y ? x : y;
	int z;
	z =x>y ? x : y;
	return z;
	
	//�βεĸı䲻������ʵ�εĸı䣻
	//����δ������ʱ���ββ��������ڴ浥Ԫ
	x++;
	y++;
}
void main()
{
	int a,b,c;
	scanf("%d %d",&a,&b);
	c=max(a,b); 
	printf("%d %d\n",a,b);
	printf("max = %d\n",c);
}
