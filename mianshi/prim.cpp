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
		//�������е㵽S�ľ�����ǵ�0�ľ���
		low[i] = e[0][i];
	}
	for(i=1;i<n;i++){
		int minv = INF;
		int p = 0;
		//�ҳ��뼯��s��������С�ı�
		for(j=0;j<n;j++){
			if(!inSet[j] && low[j] < minv){
				minv = low[j],p = j;
			}
		}
		if(minv == INF) return -1;//����ͨͼ
		//������j�ӵ�S����
		inSet[p] = true;
		//�����·���ӵ������
		res += low[p];
		//����low����
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
