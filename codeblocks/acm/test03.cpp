#include <stdio.h>
#define MAXN 512
typedef struct Rect{
	int width;
	int height;
}Rect;

Rect rects[MAXN];	//��������
int G[MAXN][MAXN];	//�߱�����
int max[MAXN];		//������飬��ŴӸõ���������ߵ��·���ĳ���
int dp(int i, int n){//�Ӷ���i�������߳�һ���·������n�����㡣����·�����ȣ�����˵�ߵĸ���
	if (max[i]>0)
	{
		return max[i];
	}
	max[i] = 1;
	//��i����i֮�������Ķ����ߣ�ѡ�����·��
	for (int j = 0; j < n;j++) {
		if(i == j) {continue;}
		if (G[i][j])//��i��j��һ����
		{
			int j_max = dp(j,n);//�ߵ�j
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
				G[i][j] = 1;//����rects[i]���Էŵ�rects[j]�У��鵽����һ����
			}
		}
	}
	
	int max = 0;
	//��ÿ���������ѡ�����·�� 
	for ( i = 0; i < n; i++) {
		int j_max = dp(i,n);
		if(j_max > max){
			max = j_max;
		}
	}
	printf("%d\n",max);
	return 0;
}
