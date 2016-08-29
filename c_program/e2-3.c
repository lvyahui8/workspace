#include <stdio.h>
#include <math.h>

//3n+1问题
int main(int argc, char const *argv[])
{
	double sum = 0;
	int i = 0;
	double term;
	do
	{
		/* code */
		term = 1.0 / (i*2 + 1);
		if (i % 2 == 0)
		{
			/* code */
			sum += term;
		}
		else{
			sum -= term;
		}
		i++;
	} while (term > 1e-6);
	printf("%.6lf \n", sum);
	return 0;
}