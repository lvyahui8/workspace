
#include <stdio.h>
#include <string.h>
#define MAXN 105

//素数判断改进版，前一个版本存在溢出造成死循环的情况
int isPrime(int n){
    if (n <= 1){
        return 0;
    }

    int m = floor(sqrt(n) + 0.5);

    int i = 2;
    for (; i <= m; i++){
        if (n % i == 0){
            return 0;
        }
    }
    return 1;
}
int main(){

    return 0;
}





