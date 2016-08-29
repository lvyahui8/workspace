#include <stdio.h>
#include <memory.h>

#define MAXN 10000
#define NOPSB -1

int b[MAXN][MAXN];
int d[MAXN][MAXN];
int a[5][5]={
	{1,0,0,0,0},
	{3,2,0,0,0},
	{4,10,1,0,0},
	{4,3,2,20,0},
	{0,0,0,0,0}
};

int main(){
	int n;
	int i = 0 , j = 0;
	scanf("%d",&n);
	for(;i<n;i++){
		for(j = 0;j<=i;j++){
			scanf("%d",&b[i][j]);
			d[i][j] = NOPSB;
		}
	}
	int left = 0, right = 0;
	for(i = n-1;i >= 0;i--){
		for(j = 0;j<=i;j++){
			//printf("%d\n",b[i][j]);
			if(d[i][j]!=-1){continue;}//已经计算的，不用再计算
			if(i==n-1){
				left = 0, right = 0;
			}
			else{
				left = d[i+1][j],right = d[i+1][j+1];
			}
			d[i][j] = b[i][j] + (left > right ? left : right);
		}
		//printf("\n");
	}
	printf("max length : %d\n",d[0][0]);
	return 0;
}