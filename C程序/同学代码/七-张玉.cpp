#include<stdafx.h>
#define R 10
#define C 5 
float score[R][C];
float s_aver[R],c_aver[C];
/*
*	尽量不要使用全局变量，你这样写完全没有理解为什么要自定义函数，这样写和全部写在主函数里面没有任何区别
*	为什么要写函数，为什么要模块化编程？举个简单的例子，printf();它也是自定义函数，只是因为他写的太优秀，微软才把他放到c 函数库里面
*	想想如果没有这个函数，那么你每次写程序，当你想要输出一些东西时，都需要把printf();庞大的内容写一次，那是不是很麻烦
*	有了printf();函数之后呢？你是不是只需要把你要printf("格式控制+字符串说明",参数列表); 就可以简单的输出数据
*	
*	那么怎么写好一个函数，一个好的函数，应该有很好的移植性，就是拿到任何一个程序里面，就可以使用，并能实现指定的功能
*	
*	#include <stdafx.h>
*
*	double power(double x,int n)
*	{
*		// {花括号里面是函数体}
*		if(n==0) return 0;
*		double j=x;
*		for(int i=1;i<n;i++)
*		{
*			x=x*j;
*		}
*		return x;
*	}

*	像这样一个函数就是一个很好的函数，如果你的程序里要求X^y这样的问题，只要简单的调用，不用再把复杂的函数体代码再写一次，所以它
*	也被放到了函数库里	
*	写函数，可以根据你的需要设定函数有多少个参数，有没有返回值。
*	比如说这个题目中，你完全可以不用声明声明全局变量，只要把数组做形参就行，就可以在自定义函数使用其他函数里的数组
*
*	这次作业我只帮你改到没有错误，怎么真正的写出函数的意义，你自己去写，你可以去看一下函数那一章节的视屏，看下我的作业，自己动手
*	多写一些自定义函数，尽量不要使用全局变量。遇到问题来找我；
*/

int n,m;
void main()
{
	int i,j;
	float max; //用来存最大值
	//下面6行只是函数声明，而不是函数调用，所以没有让你输入，所以所有的数都是0
	float highest();
	float s_var(void);
	void s_input(void);
    void c_aver2(void);
    void s_aver2(void);
    void c_input(void);
	s_input(); // 输入
	c_aver2(); //计算学生平均值
	s_aver2(); //计算科目平均值
	printf("\nNO.  c1      c2      c3      c4      c5     aver\n");//五门课程和每个同学的平均分

    for(i=0;i<R;i++)
	{
		printf("\nNO.%2d\n",i+1);//每个同学的分数
		for(j=0;j<C;j++)
			printf("%8.2f",score[i][j]);
		printf("%8.2f",s_aver[i]);
	}

	printf("\naver:\n");//每门课程的平均分
	for(j=0;j<C;j++)
		printf("%8.2f",c_aver[j]);

	max=highest();
    printf("\nhighest:%7.2f       NO.%2d      NO.%2d\n",max,n,m);
	printf("variance:%7.2f\n",s_var());//方差
}
void s_input(void)
{	
	// 输入数组值
	int i,j;
	for(i=0;i<R;i++)
	{
		printf("input score of student%2d:\n",i+1);
		for(j=0;j<C;j++)
			scanf("%f",&score[i][j]);
	}
}

void s_aver2(void)
{
	//每名学生的平均成绩
	int i,j;
	float s;
	for (i=0;i<R;i++)
	{
		s=0;  // 你忘了给s 复位为0
		for(j=0;j<C;j++)
			s+=score[i][j];
		s_aver[i]=s/5.0;
	}
}
void c_aver2(void)
{
	//每门科目的平均成绩
	int i,j;
	float s;
	for(j=0;j<C;j++)
	{
		s=0;
		for(i=0;i<R;i++)
			s+=score[i][j];
		c_aver[j]=s/(float)R;
	}
}
float highest()
{
	// 寻找最大值，并记录对应的行和列
	float high;
	int i,j;
	high=score[0][0];
	for(i=0;i<R;i++)
	{
		for(j=0;j<C;j++)
		{
			if(score[i][j]>high)
			{
				high=score[i][j];
				n=i+1;
	            m=j+1;
			}
		}
	}
	return(high);
}
float s_var(void)
{
	int i;
	float sumx,sumy;
	sumx=0.0;
	sumy=0.0;
	for(i=0;i<R;i++)
	{
		sumx+=(s_aver[i]*s_aver[i]);
	    sumy+=s_aver[i];
	}

	return(sumx/R)-(sumy/R)*(sumy/R); //  公式错了
}