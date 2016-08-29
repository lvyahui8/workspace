#include <cstdio>
#include <cstring>
#define MAXN 1024
#define INF 0xeFFFFFFF
int e[MAXN][MAXN];
int low[MAXN];
bool inSet[MAXN];
int n;
int prim(){
	int res=0,i,j,k;
	inSet[0] = true;
	memset(inSet,0,sizeof(inSet));
	for(i=0;i<n;i++){
		//现在所有点到S的距离就是到0的距离
		low[i] = e[0][i];
	}
	for(i=1;i<n;i++){
		int minv = INF;
		int p = 0;
		//找出与集合s相连的最小的边
		for(j=0;j<n;j++){
			if(!inSet[j] && low[j] < minv){
				minv = low[j],p = j;
			}
		}
		if(minv == INF) return -1;//非连通图
		//将顶点j加到S里面
		inSet[p] = true;
		//将最短路径加到结果里
		res += low[p];
		//更新low数组
		for(k=0;k<n;k++){
			if(!inSet && low[p] > e[p][k]){
				low[p] = e[p][k];
			}
		}
	}

	return res;
}

int main(void){
	int i;
	scanf("%d",&n);
	for(i=0;i<n-1;i++){
		int x,y,w;
		scanf("%d%d%d",&x,&y,&w);
		e[x][y] = e[y][x] = w;
	}
	int res = prim();
	printf("%d\n",res);
	return 0;
}
