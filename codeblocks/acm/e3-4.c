#include <stdio.h>
#define MAXN 1010
//猜数字游戏
int main(){
    int n, a[MAXN], b[MAXN];
    int kase = 0;
    while ((1 == scanf("%d",&n)) && n){
        printf("Game %d:\n",++kase);
        {
            int i ;
            for (i = 0;i<n; i++ ){
                scanf("%d",&a[i]);
            }
        }
        for (; ; ){
            int A = 0 , B = 0;
            int i;
            for (i = 0; i<n;i++){//
                scanf("%d",&b[i]);
                if(a[i] == b[i]) A++;
            }
            if (b[0] == 0){//正常的猜测序列不会有0，所以只怕判断第一个数是否为0即可
                break;
            }
            int d;
            for (d = 1; d <= 9; d++){
                int c1 = 0,c2 = 0;//统计数字d在答案序列和猜测序列中各出现多少次
                int i;
                for (i = 0; i < n; i++){
                    if(a[i] == d) c1++;
                    if(b[i] == d) c2++;
                }
                if(c1 < c2) B += c1;
                else B += c2;
            }
            printf("    (%d,%d)\n",A,B-A);
        }
    }
    return 0;
}
