#include <stdafx.h>

void main()
{
	//作用：字符串加密
	char c;
	while((c=getchar()) != '\n')  //逐个取出字符
	{   
		//判断字符是否是英文，是则进行加密，否则不执行
		if(c>='A' && c<='Z' || c>='a' && c<='z')  
		{
			//判断字符是否是w、x、y、z，是则转换成相应大小写的a、b、c、d，否则以其后第四个字母代之
			if(c>='W' && c<='Z' || c>='w' && c<='z')  
			{
				c=c-22;
			}
			else
			{
				c=c+4;
			}
		}
		printf("%c",c);  //逐个输出字符到屏幕
	}
	printf("\n");
}