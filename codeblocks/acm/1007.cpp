#include <stdio.h>


int main(){
    int n;
    double sum,avg;
    while(scanf("%d",&n) == 1 && n){
        sum = 0;
        for(int i=0;i<n;i++){
            int x;
            scanf("%d",&x);
            sum += x;
        }
        avg = sum / n;
        printf("%.2lf\n",avg);
    }

    return 0;
}
