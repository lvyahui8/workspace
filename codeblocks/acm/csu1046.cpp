#include <stdio.h>

int main(){

    int k;
    scanf("%d",&k);
    while(k--){
        double m,h;
        scanf("%lf%lf",&m,&h);
        long double res = (long double)m / (h*h);
        if(res < 18.5){
            puts("Underweight");
        }
        else if(res >= 23){
            puts("Overweight");
        }else{
            puts("Normal");
        }
    }
    return 0;
}
