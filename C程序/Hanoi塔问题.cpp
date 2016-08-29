//移动64个盘子，移动的次数为2^64-1=1844 6744 0737 0955 1615次

#include <stdafx.h> 

//声明用户自定义的函数hanoi和move
void hanoi(int i,char one,char two,char three);
void move(char x,char y);

void main()
{
	//由用户输入盘子个数
	int n;
	scanf("%d",&n);
	//调用hanoi函数
	hanoi(n,'A','B','C');
}

void hanoi(int i,char one,char two,char three)
{
	//如果one座上只有一个盘子，直接将它移到three座
	if(i==1)
	{
		//调用move函数
		move(one,three);
	}
	//若不止一个盘子，分以下三步
	else
	{
		//第一步：递归调用hanoi函数，将one座上的i-1个盘子借助three座全部移到two座
		hanoi(i-1,one,three,two);
		//第二步：将one座上最大的第i个盘子直接移到three座
		move(one,three);
		//第三步：递归调用hanoi函数，将two座上的i-1个盘子借助one座全部移到three座
		hanoi(i-1,two,one,three);
	}
}

void move(char x,char y)
{
	//格式输出操作步骤：从x座移动一个盘子到y盘
	printf("%c->%c\n",x,y);
}
