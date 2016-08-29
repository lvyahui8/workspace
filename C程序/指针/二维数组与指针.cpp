#include <stdafx.h>
/*缓冲容器，日历列表生成*/
void main()
{
	int a[3][4]={{2,3,1,4},{34,23,43,12},{34,56,53,12}};
	printf("a=%x\n\n",a);
	
	printf("a+1=%x\n",a+1);
	printf("a+2=%x\n",a+2);
	printf("a+3=%x\n\n",a+3);
	
	printf("a[0]=%x\n",a[0]);
	printf("a[0]+1=%x\n",a[0]+1);
	printf("a[0]+2=%x\n",a[0]+2);
	printf("a[0]+3=%x\n\n",a[0]+3);

	printf("a[1]=%x\n",a[1]);
	printf("a[1]+1=%x\n",a[1]+1);
	printf("a[1]+2=%x\n",a[1]+2);
	printf("a[1]+3=%x\n\n",a[1]+3);


	printf("a[2]=%x\n",a[2]);
	printf("a[2]+2=%x\n",a[2]+1);
	printf("a[2]+2=%x\n",a[2]+2);
	printf("a[2]+3=%x\n\n",a[2]+3);
	
}



