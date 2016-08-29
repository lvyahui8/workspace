#include <stdio.h>
#include <math.h>

//3n+1问题
int main(int argc, char const *argv[])
{
	int n2,count = 0;
	scanf("%d",&n2);
	long long n = n2;//避免下面乘法计算溢出
	while(n > 1){
		if(n % 2 == 1){
			n = n*3 + 1;
		}
		else{
			n/=2;	
		}
		count++;
	}
	printf("%d \n", count);
	return 0;
}