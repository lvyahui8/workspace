#include <stdio.h>

#define MAXN 1000+1

int p[MAXN][MAXN];
int k[MAXN][MAXN];
int max(int &a,int &b){
    return a > b ? a : b;
}
int main(){

    int T;
    scanf("%d",&T);
    for(int w = 0;w<MAXN;w++){k[0][w] = k[w][0] = 0;}
    while(T--){
        int n,m;
        scanf("%d%d",&n,&m);
        for(int i=1;i<=n;i++){
            for(int j=1;j<=m;j++){
                scanf("%d",&p[i][j]);
                k[i][j] = max(k[i-1][j],k[i][j-1])+p[i][j];
            }
        }
        printf("%d\n",k[n][m]);
    }

    return 0;
}
