#include <stdio.h>
#include <math.h>
//将三位数反转
int main(int argc, char const *argv[])
{
	int n , m;
	scanf("%d",&n);
	//printf("%d%d%d\n",n%10,n/10%10,n/100);
	m = (n%10)*100+(n/10%10)*10+n/100;
	printf("%d\n", m);
	return 0;
}