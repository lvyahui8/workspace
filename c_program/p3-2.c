#include <stdio.h>
#include <string.h>

#define MAXN 1024

int a[MAXN];

//开关灯问题 P39页
int main(int argc, char const *argv[])
{
	int n, k , first = 1;
	int i,j;
	memset(a,0,sizeof(a));//第一个人
	scanf("%d %d",&n,&k);
	for (i = 1; i <= k; ++i)
	{
		for (j = 1; j <= n; ++j)
		{
			/* code */
			if (j % i == 0)
			{
				/* code */
				a[j] = !a[j];
			}
		}
	}

	for (i = 1; i <= n; ++i)
	{
		if (a[i])
		{
			/* code */
			if (first)
			{
				/* code */
				first = 0;
			}
			else{
				printf(" ");
			}
			printf("%d", i);
		}
	}
	printf("\n");
	return 0;
}