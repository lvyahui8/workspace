#include <stdio.h>
#include <string.h>
#define MAXN 105

//环形串s的表示法p是否表示法q的字典序小
int less(const char * s, int p,int q){
    int n = strlen(s);
    int i = 0;
    for (; i < n; i++){
        if(s[(p + i)%n] != s[(q + i)%n]){
            return s[(p + i)%n] < s[(q + i)%n];
        }
    }
    return 0;//相等
}

//环形序列的最小字典序列
int main(){
    int T;
    char s[MAXN];
    scanf("%d",&T);
    while (T--){
        scanf("%s",s);
        int ans = 0;
        int n = strlen(s);
        int i = 1;
        //类似于在一个数组里查找最小值，ans标记最小值
        for (; i < n; i++){
            if (less(s,i,ans)){
                ans = i;
            }
        }
        for (i = 0; i<n; i++){
            putchar(s[(i+ans)%n]);
        }
        putchar('\n');
    }
    return 0;
}


