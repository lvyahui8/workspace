#include<iostream>
using namespace std;
const int Max = 102;
const int inf = 0xfffffff;



int n, ans;
int map[Max][Max], dis[Max];   //  dis[i]��ʾ����i��������֮�����̾��롣



int min(int a, int b){
	return a < b ? a : b;
}



void prim(){   //  �Լ���primģ�塣
	int i, j, now, min_node, min_edge;
	for(i = 1; i <= n; i ++)
		dis[i] = inf;
	now = 1;
	ans = 0;
	for(i = 1; i < n; i ++){
		dis[now] = -1;    //   ��dis[]��ֵ��-1����ʾ�Ѿ������������С�
		min_edge = inf;
		for(j = 1; j <= n; j ++)    //   ����ÿ����������Ӧ��dis[]ֵ��
			if(now != j && dis[j] >= 0){
				dis[j] = min(dis[j], map[now][j]);
				if(dis[j] < min_edge){
					min_edge = dis[j];
					min_node = j;
				}
			}
			now = min_node;
			ans += min_edge;
	}
}



int main(){
	int i, j;
	while(scanf("%d", &n) != EOF){
		for(i = 1; i <= n; i ++)
			for(j = 1; j <= n; j ++)
				scanf("%d", &map[i][j]);
		prim();
		printf("%d\n", ans);
	}  
	return 0;
}

