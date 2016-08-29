#include <stdio.h>
#include <string.h>
#define MAXN 100005
int ans[MAXN];
//生成元问题
int main(){
    int T , n;
    memset(ans,0,sizeof(ans));
    //建立生成元表
    int m ;
    for (m = 1;m < MAXN ; m++){
        int x = m , y = m;//y存放x加上x的各个数字之和 x是Y的生成元
        while (x > 0){
            y +=  x % 10;
            x /= 10;
        }
        //下面这句是代码的重点，生成元x比y要小，如果不等于0说明还没设置过
        if (0 == ans[y] || m < ans[y]){
            ans[y] = m;
        }
    }
    scanf("%d",&T);
    while (T--){
        scanf("%d",&n);
        printf("%d\n",ans[n]);
    }
    return 0;
}

