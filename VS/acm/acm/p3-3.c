#include <stdio.h>
#include <string.h>

#define MAXN 20

int a[MAXN][MAXN];

//蛇形填数问题 P39页
int main(int argc, char const *argv[])
{
	int n, x, y, tot = 0;
	scanf("%d",&n);
	memset(a, 0, sizeof(a));
	tot = a[x=0][y=n-1] = 1;
	printf("%d\n",tot );
	while(tot < n*n){
		while(x+1<n && !a[x+1][y]){a[++x][y]=++tot;}
		while(y-1>0 && !a[x][y-1]){a[x][--y]=++tot;}
		while(x-1>0 && !a[x-1][y]){a[--x][y]=++tot;}
		while(y+1<n && !a[x][y+1]){a[x][++y]=++tot;} 
	}
	int i,j;
	for (i = 0; i < n; ++i)
	{
		/* code */
		for (j = 0; j < n; ++j)
		{
			/* code */
			printf("%3d", a[i][j]);
		}
		printf("\n");
	}

	return 0;
}