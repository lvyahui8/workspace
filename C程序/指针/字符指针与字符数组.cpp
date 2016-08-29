#include "stdafx.h"

void main()
{
	/*char * a="I love China!";
	int i;
	printf("The sixth charactr is %c\n",a[5]);//a[5]==*(a+5)

	for(i=0;a[i]!='\0';i++)
		printf("%c",a[i]);
	putchar('\n');*/

	//char * format="a=%d,b=%d\n";
	char  format[]="a=%d,b=%d\n";
	int a=1,b=2;
	printf(format,a,b);


}