#include <stdafx.h>
#include<stdlib.h>
#include <windows.h>


void lr()  //¼�뺯��
{
	char xm[10][20];
	int xh[10];
	float cc[10],sx[10],yy[10];
	int i=0;
	for( i=0 ; i<10 ; i++)
	{
		printf("�밴���������%d��ѧ������Ϣ������ ѧ�� c���Գɼ� ��ѧ�ɼ� Ӣ��ɼ�:\n",i+1);
		scanf("%s %d %f %f %f",xm[i],&xh[i],&cc[i],&sx[i],&yy[i]);

		//system("pause");
		//system("cls");
	}
	
}
void main()
{
	lr();
}