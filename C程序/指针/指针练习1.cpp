#include <stdafx.h>

void main()
{
	/*int i;
	int *i_pointer;
	i_pointer=&i;
	i=8;
	printf("i=%d\n",*i_pointer);
	for(i=1;i<=10;i++)
	{
		printf("%x\n",&*i_pointer++);
	}
	*/

	char ch;
	char *ch_pointer;
	ch_pointer=&ch;
	do
	{
		scanf("%c",ch_pointer++);
	}
	while(*ch_pointer != '\n');
}