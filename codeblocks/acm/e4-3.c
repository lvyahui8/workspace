#include <stdio.h>

#define MAXN 25
int n, k , m , a[MAXN];

//在当前位置p逆时针走t步，b为步长（-d表示顺时针）
int go(int p,int d,int t)
{
    while (t--){
        do{
            //走到下一个非0数字
            p = (p + d - 1 + n)%n + 1;
        } while (a[p] == 0);
    }
    return p;
}

int main(){
    while (scanf("%d%d%d",&n,&k,&m) == 3 && n){
        int i = 1;
        for (; i <= n; i++){
            a[i] = i;
        }
        int left = n;//还剩下的是人数
        int p1 = n, p2 = 1;
        while (left){
            p1 = go(p1,1,k);
            p2 = go(p2,-1,m);
            printf("%3d",p1);left--;
            if (p1!=p2){
                printf("%3d",p2);left--;
            }
            a[p1] = a[p2] = 0;
            if(left){
                printf(",");
            }
        }
        printf("\n");
    }
    return 0;
}
