#include <stdio.h>
#include <string.h>
#define MAXN 128
#define MAXM MAXN
int m[MAXN][MAXM];
int s[MAXN][MAXM];
int p[MAXN]={30,35,15,5,10,20,25};
int n;
void maxChain(){
    int i,j,k;
    for(i=1;i<=n;i++){
        m[i][i] = 0;
    }
    for(i=2;i<=n;i++)
    {
        for(j=1;j<=n-i+1;j++){
            int b = i+j-1;
            m[j][b] = m[j+1][b]+p[j-1]*p[j]*p[b];
            s[j][b]=j;
            for(k=j+1;k<b;k++){
                int t = m[j][k]+m[k+1][b]+p[j-1]*p[k]*p[j];
                if(t<m[j][b]){
                    m[j][b] = t;
                    s[j][b] = k;
                }
            }
        }
    }
}
void traceBack(int i,int j){
    if(i==j){
        return ;
    }
    traceBack(i,s[i][j]);
    traceBack(s[i][j]+1,j);
    printf("Multiply A%d,%d And A%d,%d\n",i,s[i][j],s[i][j]+1,j);
}
int main()
{
    n = 6;
    maxChain();
    printf("%d\n",m[1][n]);
    traceBack(1,n);
    return 0;
}
