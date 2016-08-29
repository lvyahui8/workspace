#include <stdio.h>
#include <time.h>

//阶乘之和，以及程序效率问题
int main(int argc, char const *argv[])
{
	const int MOD = 1000000;
	int n , s = 0;
	scanf("%d",&n);
	int i , j;
	for (i = 1; i <= n; ++i)
	{
		int factorial = 1;
		for (j = 1; j <= i; ++j)
		{
			factorial = (factorial * j % MOD);
		}
		s = (s+factorial)%MOD;
	 	printf("%d\n", s);
	printf("Time used = %.2f\n", (double)clock() / CLOCKS_PER_SEC);
	return 0;
}