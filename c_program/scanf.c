#include <stdio.h>

int main(int argc, char const *argv[])
{
	int x,n = 0, min , max ,s = 0;
	while (scanf("%d",&x) == 1){
		s += x;
		if (x < min)
		{
			/* code */
			min = x;
		}
		if (x > max)
		{
			/* code */
			max = x;
		}
		n++;
	}
	printf("%d %d %.3f\n", min,max,(double)s/n);
	return 0;
}