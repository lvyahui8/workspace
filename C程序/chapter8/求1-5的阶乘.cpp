#include <stdafx.h>
int fac(int n);
void main()
{
	for(int i=1; i<=5;i++)
		printf("%d\n",fac(i));

}
int fac(int n)
{
	//��̬�ֲ������ᱣ�溯����һ�ε��ú��ֵ
	//��̬�ֲ�����ֻ������һ��
	static int f=1;
	f=f*n;
	return f;
}