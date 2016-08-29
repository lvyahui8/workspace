#include<stdio.h>
#include<math.h>
#define N 100000000
bool prime[N];
int main(){
    int i, j, t;
    double a, tmp;
    double b=0;
    for(i=2; i<N; i++){
        if(i%2){
            prime[i]=true;
        }else{
            prime[i]=false;
        }
    }
    for(i=3; i<=sqrt(N); i++){
        if(prime[i]){
            for(j=i+i; j<N; j=j+i){
                prime[j]=false;
            }
        }
    }
    prime[2] = true;
    scanf("%d",&t);
    while(t--){
        scanf("%lf",&a);
        tmp = sqrt(a);
        if(!modf(tmp,&b)){
            if(prime[(int)tmp]){
                printf("YES\n");
            }else{
                printf("NO\n");
            }
        }else{
            printf("NO\n");
        }
    }
    /*
    for(i=2; i<N; i++)
    if( prime[i] )printf("%d ",i);
    */
    return 0;
}
