#include <stdio.h>
#include <stdlib.h>
#include <math.h>
#define MAXN 10000+5

int child[MAXN];
int like[MAXN];
int ok[MAXN];

int size;
void initSet(int n){
    int i;
    size = n;
    memset(child,0,sizeof(int)*n);
    memset(like,0,sizeof(int)*n);
    /*
    for(i=1;i<n;i++){
        child[i] = 0;
        like[i] = 0;
    }
    */
}
/*
int find(int x){
    if(x != parent[x]){
        parent[x] = find(parent[x]);
    }
    return parent[x];
}

void unionSet(int x,int y){
    int px = find(x),py = find(py);
    if(px != py){
        // 这里只讲x加到y集中
    }
}

*/
int main(){
    int k;
    freopen("36001.in","r",stdin);
    scanf("%d",&k);
    while(k--){
        int n,m;
        while(scanf("%d%d",&n,&m) == 2){
            initSet(n);
            int a,b,i,j,has = 0;
            if(m != 0){
                while(m--){
                    scanf("%d%d",&a,&b);
                    //printf("%d 认识 %d\n",a,b);
                    // 认识b的人加1
                    child[b]++ ;
                    // a认识的人加1
                    like[a]++;
                }
                for(i=1,j=0;i<=n;i++){
                    // 只认识自己
                    if ( n-1 == child[i] && 0 == like[i]){
                        //printf("%d\n",i);
                        ok[j++] = i;
                        has++;
                    }
                }
                if(has){
                    printf("%d\n",has);
                    for(j=0;j<has;j++){
                        printf("%d ",ok[j]);
                    }
                    printf("\n");
                }else{
                    printf("0\n\n");
                }
            }
            else{
                printf("0\n\n");
            }

        }
    }

    return 0;
}


