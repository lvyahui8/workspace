#include <stdafx.h>

void main()
{
	/*题目：输入三个整数x,y,z，请把这三个数由小到大输出。 
	
	1.程序分析：我们想办法把最小的数放到x上，先将x与y进
	行比较，如果x>y则将x与y的值进行交换， 然后再用x与z进
	行比较，如果x>z则将x与z的值进行交换，这样能使x最小。 
	
	2.程序源代码：*/

	int x,y,z,t;
	scanf("%d %d %d",&x,&y,&z);
	if(x>y)
	{t=x;x=y;y=t;}
	if(x>z)
	{t=z;z=x;x=t;}
	if(y>z)
	{t=y;y=z;z=t;}
	printf("%d %d %d\n",x,y,z);
	main();
}