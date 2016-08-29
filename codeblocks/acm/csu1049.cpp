#include <stdio.h>
#include <set>

using namespace std;

#define MAXN 10005

long a[MAXN];
long b[MAXN];
long c[MAXN];
long d[MAXN];



int main(){
    int k;
    scanf("%d",&k);
    while(k--){
        set<long> s;
        int n;
        scanf("%d",&n);
        for(int i=0;i<n;i++){
            scanf("%d%d",&a[i],&b[i]);
        }
        int m;
        long ct = 0;
        scanf("%d",&m);
        for(int i =0;i<m;i++){
            scanf("%d%d",&c[i],&d[i]);
            if(c[i] < a[i] && a[i]<d[i] && d[i] <b[i]){
                a[i] = c[i];
                ct += b[i] - a[i];
            }
            else if()
        }

    }
    return 0;
}
