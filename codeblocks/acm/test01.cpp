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
int n;

int go(int i, int j){
	if(d[i][j]!=NOPSB) return d[i][j];
	int v = b[i][j];
	if(i==n){
		v += 0;
	}
	else{
		int right = go(i+1,j),left = go(i+1,j+1);
		v += right > left ? right : left;
	}
	return d[i][j]=v;
}

int main(){
	int i = 0 , j = 0;
	scanf("%d",&n);
	for(;i<n;i++){
		for(j = 0;j<=i;j++){
			scanf("%d",&b[i][j]);
			d[i][j] = NOPSB;
		}
	}
	//printf("max length : %d\n", go(0,0));
	/*i = 0;
	for(;i<n;i++){
		for(j = 0;j<n;j++){
			printf("%d ",b[i][j]);
		}
		putchar('\n');
	}*/
	printf("max length : %d\n", go(0,0));
	return 0;
}