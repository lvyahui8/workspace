#include "stdafx.h" /*����ͷ�ļ�stafx.h*/
//#define a 12
//#define n 5
main()  /*����������main*/
{
	int a=12,n=5;
	printf("a+=a %d\n",a+=a );
	printf("a-=2 %d\n",a-=2 );
	printf("a*=2+3 %d\n",a*=2+3);
	printf("a/=a+a %d\n",a/=a+a );
	printf("a%%=(n%%=2) %d\n",a%=(n%=2));
	printf("a+=a-=a*=a %d\n",a+=a-=a*=a);
	return 0;
}
