#include <stdafx.h>

#define H 3
#define L 10
void main()
{
	char str[H][L];
	char ch;
	int i;
	int large_e=0,small_e=0,math=0,space=0,other=0;
	// 输入
	for(i=0;i<H;i++)
		gets(str[i]);
	// 判断
	for(i=0;i< H*L ;i++)
	{
		ch=*(*str+i);
		if(ch>='A' && ch<='Z')
			large_e++;
		else if(ch>='a' && ch<='z')
			small_e++;
		else if(ch>='0' && ch<='9')
			math++;
		else if(' '==ch)
			space++;
		else if(ch!='\0')
			other++;
		// 遍历完一行 ，输出结果 然后清零
		if((i+1) % L == 0)
		{
			printf("large_e=%d,small_e=%d,math=%d,space=%d,other=%d\n",
				large_e,small_e,math,space,other);
			large_e=0;small_e=0;
			math=0;space=0;other=0;
		}
	}
}