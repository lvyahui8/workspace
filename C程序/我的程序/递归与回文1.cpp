/*
需求：判断一个整数是否是回文数

思路：
1.主函数里由输入数据-处理数据-输出数据三部分组成。
2.利用函数的递归调用将数值倒序，再与原来的值作比较。

步骤：
1.在主函数里用格式输入函数输入数据，存在变量 i 里。
2.调用自定义函数  isHW 函数，将数位逆序排列并返回给主函数。
3.判断isHW 的返回值与 i 是否相等。
4.是则格式输出 It is a palindrome，否则格式输出 It is not a palindrome。
*/

#include <stdafx.h>

int isHW(int n)
{
	static int m=0;//静态局部变量只会定义一次，静态局部变量会保存函数上一次调用后的值，所以在调用之后要复位为0；
	if( n != 0 )	
	{		
		m=m*10+n%10;		
		isHW(n/10);	
	}
	else
	{
		//最后一次递归之后m里面存的已经是倒序数了，把值传给n之后，自己复位为0；
		n=m;
		m=0;
		return n;
	}
}

void main()
{
	int i;
	scanf("%d",&i);
	if(i==isHW(i))
		printf("It is a palindrome.\n");
	else
		printf("It is not a palindrome.\n");
}