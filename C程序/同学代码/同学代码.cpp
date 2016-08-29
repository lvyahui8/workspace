#include <stdafx.h>
#include<stdlib.h>
#include <windows.h>


void lr()  //录入函数
{
	char xm[10][20];
	int xh[10];
	float cc[10],sx[10],yy[10];
	int i=0;
	for( i=0 ; i<10 ; i++)
	{
		printf("请按次序输入第%d个学生的信息：姓名 学号 c语言成绩 数学成绩 英语成绩:\n",i+1);
		scanf("%s %d %f %f %f",xm[i],&xh[i],&cc[i],&sx[i],&yy[i]);

		//system("pause");
		//system("cls");
	}
	
}
void main()
{
	lr();
}