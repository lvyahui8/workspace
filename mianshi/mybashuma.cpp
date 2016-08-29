#include <stdio.h>
#include <malloc.h>
#include <stdlib.h>
int dist[3][3];
int arr[3][3];

int in(int x,int y){
	return x < 3 && x >=0 && y < 3 && y >=0;
}

void swap(int * a,int * b){
	int tmp = * a;
	* a = * b;
	* b = tmp;
}

int as(){
	for(int i=0;i<9;i++){
		int x = i / 3,y = i % 3;
		if(arr[x][y] != dist[x][y]){
			return 0;
		}
	}
	return 1;
}

/*
������ż���ƶ��������ĳ�ʼ״̬���޽�.

���������һ������ʾ��һ������a[9]���ո���0��ʾ������ʱ����p(x)����Ϊ��x������λ��ǰ�������xС�����ĸ�����

����0�ո�����֮�ڣ�����Ŀ��״̬Ϊb[9]����r=sigma(p(x)) sigma()��ʾȡȫ����x:1-8����ͣ�

�Ƕ��ڳ�ʼ״̬a[9]��t=sigma(p(x))������r��tͬΪ��������ͬΪż������ô��״̬�н⣬�����޽⡣
*/
int sigma(int mp[3][3],int n){
    int s = 0;
    int * a = NULL;
    a = (int *) malloc((sizeof(int))*n);
    for(int i = 0; i < n;i++){
        a[i] = mp[i/3][i%3];
    }
    for(int i = 0;i< n;i++){
        if(a[i] != 0){
            for(int j = 0; j < i ; j++ ){
                if(a[j] != 0 && a[j] < a[i]){
                    s ++ ;
                }
            }
        }
    }
    free(a);
    return s;
}
int noSolution(){
    int r = sigma(arr,9);
    int t = sigma(dist,9);
    if(r % 2 == t % 2){
        return 1;
    }else{
        return 0;
    }
}

int find = false;
int step = 0;
void map(int x,int y,int s){
    // ����޽⣬�˳�
    if(noSolution()){
        return;
    }
	int dir[4][2] = {
			x, y - 1,
			x, y + 1,
			x + 1, y,
			x - 1, y
	};

	for(int i=0;i<4 && !find;i++){
        // �ֱ��϶��ո��������Χ���ĸ����ŵ���λ��
		if(in(dir[i][0],dir[i][1])){
            // �����ַŵ��ո���
			swap(&arr[x][y],&arr[dir[i][0]][dir[i][1]]);
			if(as()){
				find = true;
				step = s;
			}else{
                if(!noSolution()){
                    // �����н⣬��������һ��
                    map(dir[i][0],dir[i][1],s + 1);
                }
                // �����ִӿո����Ż�ԭ����λ��
				swap(&arr[x][y],&arr[dir[i][0]][dir[i][1]]);
			}
		}
	}
}

int main(){
	int x,y;
	freopen("basuma.in","r",stdin);
	for(int i=0;i<3;i++){
		for(int j=0;j<3;j++){
			scanf("%d",&arr[i][j]);
			if(!arr[i][j]){
				x = i;y = j;
			}
		}
	}
	for(int i=0;i<3;i++){
		for(int j=0;j<3;j++){
			scanf("%d",&dist[i][j]);
		}
	}
	if(!noSolution()){
        if(!as()){
            map(x,y,step);
        }
        printf("%d\n",step);
	}else printf("noSolution !\n");

	getchar();
	system("pause");
	return 0;
}

