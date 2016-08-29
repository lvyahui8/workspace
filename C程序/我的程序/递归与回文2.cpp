/*
需求：判断一个整数是否是回文数

思路：
1.主函数里由输入数据-处理数据-输出数据三部分组成。
2.利用函数的递归调用在数值中插入断点，比较断点左右两边的数的大小。

步骤：
1.在主函数里用格式输入函数输入数据，存在变量 i 里。
2.调用自定义函数  isHW 函数，判断是不是回文数，是返回真，否返回假。
3.将左边的数存在west里，右边的数存在east里，判断是否相等，相等的话则是回文数，不是再看断点两边的值，如果左边小于右边了
  那就不是回文数。否则的话递归调用，把断点 再左移一位。
  
  例如  14541：
	第一次1454 . 1   两者不相等，左边大于右边，把断点左移
	第二次145  . 41  154 和 14不等，但是145整除10 与 14相等,所以是回文数，返回真
		34564：
	第一次3456 . 4   两者不相等，左边大于右边，把断点左移
	第二次345  . 64  345和 46不相等，左边大于右边，把断点左移
	第三次34   . 564 34 和 465 不相等，右边大于左边，肯定不是回文数，返回假

4.判断isHW的返回值是真是假，真则格式输出 It is a palindrome，假则格式输出 It is not a palindrome。
*/


#include <stdafx.h>

int isHW(int west)
{
	int static east = 0;
	east = east*10+west%10;
	west /= 10;
	if(east == 0) //个位是0 不是回文数 
		return 0;
	if(west == east || west/10 == east)//在某个时刻 左边和右边相等 是回文数 返回1 
	{
		east = 0;
		return 1;
	}
	if(west < east)//在某个时刻 左边小于右边 不是回文数 返回0 
	{
		east = 0;
		return 0;
	}
	return isHW(west);
}

void main()
{
	int i;
	scanf("%d",&i);
	if(isHW(i))
		printf("%d is a palindrome.\n", i);
	else
		printf("%d is not a palindrome.\n",i);
	
}
