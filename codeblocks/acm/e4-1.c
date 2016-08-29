#include <stdio.h>
#include <string.h>
#include <stdlib.h>
#define WORD 26
//素数判断改进版，前一个版本存在溢出造成死循环的情况
int cmp(const void * a,const void * b){
    return *(int *)a - *(int *)b;
}

int enableAs(const char *str1,const char *str2){
    int cnt1[WORD],cnt2[WORD];
    memset(cnt1,0,sizeof(cnt1));
    memset(cnt2,0,sizeof(cnt2));
    char * p1 = str1, * p2 = str2;
    for (; *p1 != '\0'; p1++){
        cnt1[*p1-'A']++;
    }
    for (; *p2 != '\0'; p2++){
        cnt2[*p2-'A']++;
    }
    qsort(cnt1,WORD,sizeof(int),cmp);
    qsort(cnt2,WORD,sizeof(int),cmp);
    int i = 0;
    for (;i < WORD; i++){
        if (cnt1[i] != cnt2[i]){
            return 0;
        }
    }
    return 1;
}

int main(){
    char * str1 , * str2;
    scanf("%s",str1);
    scanf("%s",str2);
    int isEanble = enableAs(str1,str2);
    if(isEanble){
        printf("YES\n");
    }
    else{
        printf("NO\n");
    }
    return 0;
}

/*
JWPUDJSTVP
VICTORIOUS
*/


