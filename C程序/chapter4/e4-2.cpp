#include <stdafx.h>

main()
{
	/*char c = getchar();
	printf("%c\n",c);
	return 0;
	printf("wz1234567890123456789\n");
	int a=123;
	int d=12345;
	printf("a=%4d\n",a);
	printf("d=%4d\n",d);
	long c=123456;
	printf("c=%4ld\n",c);*/
	printf("1234567890123456789\n");
	/*int a=-1;
	long b=-1;
	printf("%15o\n",a);
	printf("%13lo\n",b);
	return 0;*/
	unsigned a=4294967295; //a=2^32-1
	//内存中存的是32个1
	int b=-2;
	//源码  1（29个0）10
	//取反得1（29个1）01  
	//加1得
	//补码     (31个1）0
	printf("a=%d,%o,%x,%u\n",a,a,a,a);
	printf("b=%d,%o,%x,%u\n",b,b,b,b);


	
}
