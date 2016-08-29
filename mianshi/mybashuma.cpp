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
利用奇偶性推断所给出的初始状态有无解.

将八数码的一个结点表示成一个数组a[9]，空格用0表示，设暂时函数p(x)定义为：x数所在位置前面的数比x小的数的个数，

当中0空格不算在之内，那设目标状态为b[9]，那r=sigma(p(x)) sigma()表示取全部的x:1-8并求和，

那对于初始状态a[9]，t=sigma(p(x))，假设r和t同为奇数或者同为偶数，那么该状态有解，否则无解。
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
    // 如果无解，退出
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
        // 分别拖动空格区域的周围的四个数放到空位上
		if(in(dir[i][0],dir[i][1])){
            // 将数字放到空格上
			swap(&arr[x][y],&arr[dir[i][0]][dir[i][1]]);
			if(as()){
				find = true;
				step = s;
			}else{
                if(!noSolution()){
                    // 可能有解，继续走下一步
                    map(dir[i][0],dir[i][1],s + 1);
                }
                // 将数字从空格区放回原来的位置
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

