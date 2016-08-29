#include <stdio.h>
#include <time.h>

//韩信点兵算法 P34页
int main(int argc, char const *argv[])
{
	int x;
	int a, b, c;
	int ok;
	int kase = 0;
	FILE * fin ;
	fin = fopen("data.in","rb");
	while(fscanf(fin,"%d %d %d",&a,&b,&c) == 3){
		kase++;
		ok = 0;
		for (x = 10; x < 100 ; x++)
		{
			/* code */
			if (x % 3 == a && x % 5 == b && x % 7 == c)
			{
				/* code */
				ok = 1;
				break;
			}
		}
		if (ok)
		{
			printf("Case %d: %d\n", kase,x);
		}
		else{
			printf("Case %d: No answer\n", kase);
		}
	}
	
	return 0;
}