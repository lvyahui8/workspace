#include <stdafx.h>
#include <stdlib.h>
#include <math.h>
//����������
void zuoda1();void zuoda2();
//ÿ����Ŀ����Ϊһ������
void timu1();void timu2();void timu3();
void timu4();void timu5();void timu6();
void timu7();void timu8();void timu9();
void timu10();

// ���ͱ��������� ������
// �ַ��ͱ��������� ѡ�����
int i;
char ch;

void main()
{
	ch='x'; while('C'!=ch) {timu1();system("cls");}//   while(ִ������){ѭ����}
	ch='x'; while('B'!=ch) {timu2();system("cls");}
	ch='x'; while('B'!=ch) {timu3();system("cls");}
	ch='x'; while('D'!=ch) {timu4();system("cls");}
	ch='x'; while('D'!=ch) {timu5();system("cls");}
	i=0; while(3!=i) {timu6();system("cls");}
	i=0; while(7!=i) {timu7();system("cls");}
	i=0; while(3!=i) {timu8();system("cls");}
	i=0; while(3025!=i) {timu9();system("cls");}
	i=0; while(1!=i) {timu10();system("cls");}
	
	system("pause");
}
void zuoda1()
{
	// ����ѡ�����
	printf("����ѡ��:");
	ch=getchar();
	getchar();
	printf("\n\n");
}
void zuoda2()
{
	//����������
	printf("д�����:");
	scanf("%d",&i);
	getchar();
	printf("\n\n");
}
// ���� ����Ŀ  ÿ����Ŀ�������������
void timu1()
{
	printf("1. C���Թ涨����һ��Դ�����У�main������λ��\n");
	printf("A. �������ʼ\nB. ������ϵͳ���õĿ⺯���ĺ���\nC. ��������\nD. ���������\n");
	zuoda1();
}

void timu2()
{
	printf("2�������¶�����䣬����ʱ����ֱ���������\n");
	printf("A��char a='a'%;   B��char a='a\\n'%;    C��char a='aa'%;    D��char a='\\x2d'%; \n");
	zuoda1();
}

void timu3()
{
	printf("3. �����ĸ�ѡ���У����ǺϷ���������ѡ����\n");
	printf("A. +1e+1    5e-9.4   03e2\nB. -.60     12e-4    -8e5");
	printf("C. 123e    1.2e-.4   +2e-1\nD. -e3      .8e-4   5.e-0\n");
	zuoda1();
}

void timu4()
{
	printf("4.���������в���ȷ����\n");
	printf("A��Ԥ���������ж�������#�ſ�ʼ \nB���ڳ����з�����#�ſ�ʼ������ж���Ԥ����������\n");
	printf("C�����滻��ռ������ʱ�䣬ֻռ����ʱ��\nD�������¶�������ȷ�ģ� ��define PI 3.1415926;\n");
	zuoda1();
}

void timu5()
{
	printf("5. ������ȷ�ĺ�����ʽ��\n");
	printf("A. double fun(int x,int y) { z=x+y;return z;}\nB. fun(int x,y) { int z; return z;}\n");
	printf("C. fun(x,y) { int x,y; double z; z=x+y; return z;}\nD. double fun( int x,int y) {double z; z=x+y; return z; }\n");
	zuoda1();
}

void timu6()
{
	printf("6.�Ķ����г���Σ�������������Ϊ\n");
	printf("#include <stdio.h>\n#define M(X,Y) (X)*(Y)");
	printf("main()\n{\tint a=5,b=6,c=8,k;\n\tk=N(M(a,b),c);\n\tprintf(\"%%d\\n\",k);\n}\n");
	zuoda2();
}

void timu7()
{
	printf("7.���³������������\n");
	printf("#define MAX(x,y) (x)>(y) ?(x):(y)\n");
	printf("main()\n{\tint a=5,b=2,c=3,d=3,t;\n\tt=MAX(a+b,c+d)*10;\n\tprintf(\"%d\\n\",t);\n}\n");
	zuoda2();
}

void timu8()
{
	printf("8.���³������������\n");
	printf("main()\n{\tint c=2,k=2;\n\tswitch (k)\n{\tdefault: c+=k\n");
	printf("\tcase 2: ++c;break;\n\tcase 3: c++;break;\n}\n\tprintf(\"%%d\\n\",c);\n}\n");
	zuoda2();
}


void timu9()
{
	printf("9.���³������������\n");
	printf("int a=5;\nvoid fun(int b)\n{\n\tint a=10;\n\ta+=b;printf(\"%%d\",a);\n}\n");
	printf("void main()\n{\n\tint c=20;\n\tfun(c);a+=c;\n\tprintf(\"%%d\\n\",a);\n}\n");
	zuoda2();
}

void timu10()
{
	printf("10.���³������������\n");
	printf("void main()\n{\n\tint x=1, y=2, z=3;\n\tif(x>y)\n\tif(y<z) printf(\"%%d\",++z);\n}\n");
	printf("else printf(\"%%d\", ++y);\n\tprintf(\"%%d\\n\", x++);\n}\n");
	zuoda2();
}


