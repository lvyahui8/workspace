#include <stdafx.h>
#include <string.h>
void main()
{
	char str1[]="heLlOw";
	char str2[]="woRlD!";

	int i;
	//逐个比较字符ASCII码，比较出大小后结束比较，并不是比较字符串长短
	i=strcmp(str1,str2);	
	printf("%d\n",i);
	i=strlen(str1);
	//计字符串子符数，从第一个字符计起
	printf("%d\n",i);
	printf("%s\n",strlwr(str1));//将大写转换成小写
	printf("%s\n",strupr(str1));//将小写转换成大写
}