#include <stdio.h>
#include <string.h>
#define MAXN 128
#define MAXM MAXN
int a[MAXN][MAXM];
int b[MAXN][MAXM];
char * str1 = "ABCBDAB";
char * str2 = "BDCABA";

int LCS(const char *s1,int m, const char *s2,int n)
{
    int i, j;
    a[0][0] = 0;
    for( i=1; i <= m; ++i ) {
            a[i][0] = 0;
    }
    memset(b,0,sizeof(b));
    for( i=1; i <= n; ++i ) {
        a[0][i] = 0;
    }
    for( i=1; i <= m; ++i ){
        for( j=1; j <= n; ++j ){
            if(s1[i-1]==s2[j-1]){          //如果想等，则从对角线加1得来
                a[i][j] = a[i-1][j-1]+1;
                b[i][j] = 1;
            }
            else if(a[i-1][j]>a[i][j-1]){    //否则判段它上面、右边的值，将大的数给他
                a[i][j]= a[i-1][j];
                b[i][j] = 2;
            }
            else{
                a[i][j] = a[i][j-1];
                b[i][j] = 3;
            }

        }
    }
    return a[m][n];
}
char str[MAXN];
int p=0;
void cSubQ(int i,int j){
    if(i<1 || j<1) return;
    if(1==b[i][j]){
        cSubQ(i-1,j-1);
        str[p++]=str1[i-1];
    }
    else if(2 == b[i][j])
    {
        cSubQ(i-1,j);
    }
    else{
        cSubQ(i,j-1);
    }
}
int main()
{
    int m = strlen(str1), n = strlen(str2);
    LCS(str1,m,str2,n);
    cSubQ(m,n);
    str[p] = '\0';
    printf("%s\n",str);
    return 0;
}
