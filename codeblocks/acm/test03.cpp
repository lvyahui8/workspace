#include <stdio.h>
#define MAXN 512
typedef struct Rect{
	int width;
	int height;
}Rect;

Rect rects[MAXN];	//矩形数组
int G[MAXN][MAXN];	//边表数组
int max[MAXN];		//标记数组，存放从该点出发，能走的最长路径的长度
int dp(int i, int n){//从顶点i出发，走出一条最长路径，共n个顶点。返回路径长度，或者说边的个数
	if (max[i]>0)
	{
		return max[i];
	}
	max[i] = 1;
	//让i往除i之外其他的顶点走，选择最长的路走
	for (int j = 0; j < n;j++) {
		if(i == j) {continue;}
		if (G[i][j])//从i到j有一条边
		{
			int j_max = dp(j,n);//走到j
			if (j_max>=max[i]) {
				max[i] = j_max + 1;
			}
		}
	}
	return max[i];
}

int main(){
	int n;
	scanf("%d",&n);
	for(int i = 0; i < n;i++){
		scanf("%d%d",&rects[i].width,&rects[i].height);
	}
	
	for( i = 0;i < n;i++){
		for(int j = 0;j < n;j++){
			if(j==i){continue;}
			if((rects[i].width<rects[j].width && rects[i].height <rects[j].height )
				||(rects[i].height < rects[j].width && rects[i].width < rects[j].height)){
				G[i][j] = 1;//矩形rects[i]可以放到rects[j]中，ｉ到ｊ有一条边
			}
		}
	}
	
	int max = 0;
	//从每个点出发，选出最大路经 
	for ( i = 0; i < n; i++) {
		int j_max = dp(i,n);
		if(j_max > max){
			max = j_max;
		}
	}
	printf("%d\n",max);
	return 0;
}
