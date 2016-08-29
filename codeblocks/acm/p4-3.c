
#include <stdio.h>
#include <string.h>
#define MAXN 105

//判断是否是素数
//n=1或n太大请不要使用此函数
int isPrime(int n){
    int i = 2;
    for (; i*i <= n; i++){
        if(n % i == 0){
            return 0;
        }
    }
    return 1;
}
int main(){

    return 0;
}




