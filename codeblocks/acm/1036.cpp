#include <stdio.h>
#define MAXN 100000+5
int n;
long long w[MAXN];
int main(){
    while(scanf("%d",&n)==1 && n){
        for(int i=1;i<=n;i++){
            scanf("%lld",&w[i]);
        }
        int q;
        scanf("%d",&q);

        for(int i=0;i<q;i++){
            int a,b;
            long long sum = 0;
            scanf("%d%d",&a,&b);
            for(int j=a;j<=n;j+=b){
                sum += w[j];
            }
            printf("%lld\n",sum);
        }
    }
    return 0;
}
