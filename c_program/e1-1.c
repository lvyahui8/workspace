#include <stdio.h>
#include <math.h>

int main(int argc, char const *argv[])
{
	const double PI = acos(-1.0);
	double r , h , s;
	scanf("%lf %lf",&r,&h);
	s = 2*PI*r*r + 2*PI*r*h; 
	printf("Area = %.3lf\n",s);
	return 0;
}