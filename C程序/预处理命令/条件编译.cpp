#include <stdafx.h>

#define DEBUG

void main()
{
	int x=97,y=98,z=99;
//Ҳ�������������Դ��룬����׼������ʱ��ֻҪֻҪȡ��DEBUG�ĺ궨�壬�Ϳ���ȡ������printf("")���
#ifdef DEBUG
	printf("%d %d %d\n",x,y,z);
#else
	printf("%c %c %c\n",x,y,z);
#endif

}