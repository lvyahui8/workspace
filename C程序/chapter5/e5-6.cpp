#include <stdafx.h>

void main()
{
	int i,grade;
	char c;
	scanf("%d",&grade);
	i=grade/10;
	switch(i)
	{
	case 10:
	case 9:
		c='A';
		break;
	case 8:
		c='B';
		break;
	case 7:
		c='C';
		break;
	case 6:
		c='D';
		break;
	case 5:
	case 4:
	case 3:
	case 2:
	case 1:
	case 0:
		c='E';
		break;
	default:
		printf("输入错误");
	}
	printf("你的等级为%c\n",c);
}