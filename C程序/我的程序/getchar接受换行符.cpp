#include<stdlib.h>
#include<stdafx.h>


int main()
{
	/*你认为你可以输入几个char型的字符呢？可能很多人认为
	是9个，那错了，是5个，因为scanf函数输入char型的时候，
	把空格也算进去了，当按enter键的时候会提示输入下一个字
	符，所以每次输入一个字符算一个，然后进入下一个字符的
	enter也算一个，此处就是5个char字符，4个enter。*/

	char ch;
	int i=0;
	while(i<=8)
	{
		i++;
		scanf("%c",&ch);
		//getchar();
	}
	return 0;
 }