#include <stdafx.h>
// typedef�������������ͻ�����
// �� #include I int  ������
typedef int I;  // �� int ���� I
typedef float F;

typedef struct data // ��data ���� DATA
{
	I month;
	I day;
	I year;
} DATA;
typedef int ARR[10];  // ARR��������������10��Ԫ�ص�һά��������
typedef char * STR;//STR
typedef int (*P)(int ,float);//P

void main()
{
	I i,j;
	F a,b;
	DATA bir;//struct data nir
	ARR arr;// int arr[10];

	for(i=0;i<=9;i++)
	{
		arr[i]=i;
	}
	STR po;
	P p;
}