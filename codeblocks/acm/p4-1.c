#include <stdio.h>
#include <string.h>
#define MAXN 105

long long factorial(int n){
    long long m = 1;
    int i = 1;
    for (; i <= n; i++){
        m*=i;
    }
    return m;
}

long long C(int n,int m){
    return factorial(n) / (factorial(m)*factorial(n-m));
}
//组合数
int main(){

    return 0;
}



