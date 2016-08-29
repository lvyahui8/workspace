#include <stdio.h>

#define MAXN 105
int a[MAXN];

int main(){
    int n,tmp,m,i,c;
    while(scanf("%d",&n)==1 && n){
        for(i=0;i<MAXN;i++){
            a[i] = 0;
        }
        m = -1;
        for(i=0;i<n;i++){
            scanf("%d",&tmp);
            a[tmp]++;
            if(tmp>m) m = tmp;
        }
        c = 0;
        for(i = 1;i<=m;i++){
            int j;
            for(j=1;j<=a[i];j++){
                c++;
                if(c==n){
                    printf("%d",i);
                }
                else{
                    printf("%d ",i);
                }
            }
        }
        printf("\n");
    }
    return 0 ;
}