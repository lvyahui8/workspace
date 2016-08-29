#include <stdio.h>
#include <stdlib.h>
#include <math.h>


int main(){
    int n,m;
    int arr[] = {153,370,371,407};
    while(scanf("%d%d",&m,&n) == 2){
       /*
        int has = 0;
        int i = m;
        for(;i<=n;i++){
            int a=i/100,b = i/10%10,c = i% 10;
            if(a*a*a + b*b*b + c*c*c == i){
                has = 1;
                printf("%d ",i);
            }
        }
        if(has){
            printf("\n");
        }else{
            printf("no\n");
        }
        */
        int has = 0;
        if(m <= 153 && 153 <= n){
            has = 1;
            printf("153 ");
        }
        if(m <= 370 && 370 <= n){
            has = 1;
            printf("370 ");
        }
        if(m <= 371 && 371 <= n){
            has = 1;
            printf("371 ");
        }
        if(m <= 407 && 407 <= n){
            has = 1;
            printf("407 ");
        }
        if(has){
            printf("\n");
        }else{
            printf("no\n");
        }

    }
    return 0;
}


