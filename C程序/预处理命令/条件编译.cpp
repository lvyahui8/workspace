#include <stdafx.h>

#define DEBUG

void main()
{
	int x=97,y=98,z=99;
//也可用来包含调试代码，程序准备发布时，只要只要取消DEBUG的宏定义，就可以取消所有printf("")语句
#ifdef DEBUG
	printf("%d %d %d\n",x,y,z);
#else
	printf("%c %c %c\n",x,y,z);
#endif

}