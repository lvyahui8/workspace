#include <stdio.h>
#include <math.h>

//输出所有形如aabb的四位完全平方数
int main(int argc, char const *argv[])
{
	int i,j;
	for (i = 1; i <= 9; ++i)
	{
		for (j = 0; j <= 9; ++j)
		{
			/* code */
			int n = i * 1100 + j *11;
			int m = floor(sqrt(n)+0.5);//返回不超过X的最大整数
			if(m*m == n){
				printf("%d\n", n);
			}
		}
	}		
	return 0;
}