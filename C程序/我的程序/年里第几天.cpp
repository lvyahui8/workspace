/*
需求：输入某年某月某日，判断这一天是这一年的第几天

思路：
1.主函数里由输入数据-处理数据-输出数据三部分组成。
2.自定义一个函数，该函数肯定需要3个形参，还有整型返回值
3.在自定义函数里利用switch函数的穿透性计算天数
4.还考虑到闰年的情况

步骤：
1.在主函数里用格式输入年月日
2.判断月日是否符合要求，是则调用函数fatalism计算出天数，否则重新输入
3.在fatalism函数里先将该月之前所有月的天数加起来
4.再判断该年是否是闰年，且是不是2月以后，是则加上1天，否则不加。
*/

// 1   2  3  4  5  6  7  8  9  10  11  12
// 31  28 31 30 31 30 31 31 30 31  30  31

#include <stdafx.h>

int fatalism(int year,int month,int day)
{
	int sum=0,leap;
	switch(month)
	{
	case 12:sum+=30;// 要将month前的月份的天数全部加上
	case 11:sum+=31;
	case 10:sum+=30;
	case 9:sum+=31;
	case 8:sum+=31;
	case 7:sum+=30;
	case 6:sum+=31;
	case 5:sum+=30;
	case 4:sum+=31;
	case 3:sum+=28;
	case 2:sum+=31;
	default : break;
	}
	sum=sum+day;//再加上某天的天数
	if(year%400==0 || year%100!=0)//判断是不是闰年
		leap=1;
	else
		leap=0;
	if(leap==1 && month>2) //如果是闰年且月份大于2，总天数应该加上一天
		sum++;
	return sum;
}
void main()
{
	int i_year,i_month,i_day;
	puts("Please enter the date.For example 2012.3.7");
p:	scanf("%d.%d.%d%*c",&i_year,&i_month,&i_day);
	if(i_month<=12 && i_day<=31)
		printf("%d.%d.%d_number of days:%dth\n",i_year,i_month,i_day,fatalism(i_year,i_month,i_day));
	else
	{
		puts("Input error,Please input again.");
		goto p;
	}
}