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
	//�ڴ��д����32��1
	int b=-2;
	//Դ��  1��29��0��10
	//ȡ����1��29��1��01  
	//��1��
	//����     (31��1��0
	printf("a=%d,%o,%x,%u\n",a,a,a,a);
	printf("b=%d,%o,%x,%u\n",b,b,b,b);


	
}
