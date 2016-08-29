#include<stdafx.h>
#include<string.h>
int main()
{
	void px(char xm[3][10],char xh[3][10]);
	char xm[3][10],xh[3][10];
	int i;
	for(i=0;i<3;i++)
	{
		printf("请输入姓名：");
		gets(xm[i]);
		printf("请输入学号：");
		gets(xh[i]);
		printf("\n");
	}
	px(xm,xh);
	for(i=0;i<3;i++)
	{
		puts(xm[i]);
		puts(xh[i]);
	}
	return 0;
}
  void px(char xm[3][10],char xh[3][10])
{
	int i,j;
	char xm1[10],xh1[10];
	for(i=0;i<3;i++)
	{
		for(j=0;j<3;j++)
		{
			if(strcmp(xm[j],xm[j+1])>0)
			{
				strcpy(xm1,xm[i]);
				strcpy(xm[i],xm[i+1]);
				strcpy(xm[i+1],xm1);
				strcpy(xh1,xh[i]);
				strcpy(xh[i],xh[i+1]);
				strcpy(xh[i+1],xh1);
			}
		}
	}
}