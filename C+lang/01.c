#include <stdio.h>
#include <stdlib.h>
#include <math.h>

double sl(double n,int m){
    if(m<=0){
        return 0;
    }else{
        return n + sl(sqrt(n),--m);
    }
}

int main(){
    int n,m;
    while(scanf("%d%d",&n,&m) == 2){
        printf("%.2lf\n",sl(n,m));
    }
    return 0;
}
