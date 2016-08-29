/*
目标：
判断是否为回文数，使用函数的递归调用

计划：
输入一个或一串数字

 设置一个数组，把输入的数字存储在里头，用函数的递归把它们反转并重新存储

 用字符对应的ASC码来做差，a[1]-a[n],a[2]-a[n-1]....

 当所有差值之和0时，证明他是回文语句
 
否则不是回文语句

*/

#include "stdafx.h"
#include "string.h"				//计算字符转长度strlen(c)的命令

void reverse();void judge(int n);int xunhuan(int n);

char temp[20];
char c[20];
void main()
{	
	printf("此程序的强大之处在于它不仅可以判断回文数，甚至连回文字母，回文标点符号都能胜任！\n\n\n");
	printf("例如￥￥##   例如wanggnaw    例如119911   都可以的，此程序超强大！\n");
	printf("请在以下输入一串字符，让我们看看他是不是回文语句\n");
	reverse();

	
}

void reverse()			//反转函数，可以把输入的函数反转过来
{
	
	int p=0;
	int n;
	int i;
	
		
	scanf("%s",c);
	n=strlen(c);
	printf("反转之前：\n%s\n",c);

	
	
	for(i=n-1;i>=0;i--)
	{
		temp[p]=c[i];
		p++;
	}
	temp[p]='\0';

	for(i=0;i<n;i++)
		c[i]=temp[i];
	
	printf("反转之后：\n");
	printf("%s\n",c);

	judge(strlen(c));				//我把回文数的判断函数镶嵌在反转函数中便于直接利用scanf里头给数组c的字符串，故没有把它放到主函数main（）里头去

	
}


void judge(int n)					//判断是否为回文数
{
	int sum=0;

	sum=xunhuan(strlen(c));

	if(sum==0)									//如果所有的字符串对应相等，则差值应该为0
		printf("\n\n结果为：\n此为回文语句\n");
	else
		printf("\n\n结果为：\n此为随机语句\n");
}


int xunhuan(int n)							//在此处运用了函数的递归来完成原本用for语句完成的循环
{
	int b;
	int sum_1=0;
	int a;
	int f=0;
	
	a=temp[f]-c[n-1];
	f++;
	sum_1=sum_1+a;					//利用字符对应的ASC码来做差，a[1]-a[n],a[2]-a[n-1]....并把差值求和给sum
	
	if(b>=(n/2))
		return xunhuan(strlen(c)-1);			
	else if(b<(n/2))					
		return sum_1;
}


/*
这是函数递归int xunhuan(int n)的原模板：
	for(b=n-1;b>=(n/2);b--)
	{
		a=temp[f]-c[b];
		f++;
		sum=sum+a;
	}
*/