#include <stdafx.h>
void pd1(int a,int b);
void zuoda();
void timu2();void timu3();
void timu4();void timu5();
int i,sum;
char ch;

void timu1()
{
	printf("41. C���Թ涨����һ��Դ�����У�main������λ��\n");
	printf("A. �������ʼ\nB. ������ϵͳ���õĿ⺯���ĺ���\nC. ��������\nD. ���������");
	zuoda();
}
void main()
{
	timu1();pd1('C',ch);
	timu2();pd1('B',ch);
	timu3();pd1('B',ch);
	timu4();pd1('D',ch);
	timu5();pd1('D',ch);	
	/*timu6();pd();
	timu7();pd();	
	timu8();pd();		
	timu9();pd();
	timu10();pd();
	*/
	printf("%d\n",sum);
}

void zuoda()
{
	printf("����ѡ��:");
	ch=getchar();
	getchar();
}

void pd1(char a,char b)
{
	if(a==b)
	{
		sum++;
	}
}


void timu2()
{
	printf("22�������¶�����䣬����ʱ����ֱ���������\n");
	printf("A��char a='a'%;   B��char a='a\\n'%;    C��char a='aa'%;    D��char a='\\x2d'%; ");
	zuoda();
}

void timu3()
{
	printf("42. �����ĸ�ѡ���У����ǺϷ���������ѡ����\n");
	printf("A. +1e+1    5e-9.4   03e2\nB. -.60     12e-4    -8e5");
	printf("C. 123e    1.2e-.4   +2e-1\nD. -e3      .8e-4   5.e-0");
	zuoda();
}

void timu4()
{
	printf("27.���������в���ȷ����\n");
	printf("A��Ԥ���������ж�������#�ſ�ʼ \nB���ڳ����з�����#�ſ�ʼ������ж���Ԥ���������� ");
	printf("C�����滻��ռ������ʱ�䣬ֻռ����ʱ��\nD�������¶�������ȷ�ģ� ��define PI 3.1415926; ");
	zuoda();
}

void timu5()
{
	printf("49. ������ȷ�ĺ�����ʽ��\n");
	printf("A. double fun(int x,int y) { z=x+y;return z;}\nB. fun(int x,y) { int z; return z;}");
	printf("C. fun(x,y) { int x,y; double z; z=x+y; return z;}\nD. double fun( int x,int y) {double z; z=x+y; return z; }");
	zuoda();
}


/*
	int an[10];
	char str[10];
	for(i=0;i<=100;i++)
	{
		printf("�㻹��Ҫ�޸�����Ҫ��������ţ�����0�س�\n������:");
		scanf("%d",&i);
		if(i!=0)
		{
			printf("�����:");
			scanf("%d",&an[i]);
		}
		else
		{
			break;
		}

	}
	*/