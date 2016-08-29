#include <stdio.h>

int main(){

    int k;
    scanf("%d",&k);
    while(k--){
        long long n,d;
        scanf("%lld%lld",&n,&d);
        long long prev = -10e10;
        int c = 0;
        for(int i=0;i<n;i++){
            long long ai;
            scanf("%lld",&ai);
            if((ai-prev) < d){
                continue;
            }
            prev = ai;
            c ++;
        }
        printf("%d\n",c);
    }
    return 0;
}
