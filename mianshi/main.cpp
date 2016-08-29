#include <iostream>
#include <cstring>
#include <cstdio>
#include <cstdlib>
#include <cmath>
#include <string>
#include <vector>
#include <list>
#include <map>
#include <queue>
#include <stack>
#include <bitset>
#include <algorithm>
#include <numeric>
#include <functional>
/*
* 考虑两种情况：1、需要每月连续浇水。2、不需要每月浇水
*/
using namespace std;

int fun(int ms[],int k){
    if(0 == k) return 0;
    for(int i=1;i<=12;i++){
        for(int j=0;j<12;j++){
            int sum = 0;

            if(j+i > 12) break;

            for(int a=0;a<i;a++){
                sum += ms[j+a];
            }
            if(sum >= k){
                return i;
            }
        }
    }
    return -1;
}

int main(){
    int k ;
    int ms[12];
    //freopen("01.in","r",stdin);
    while(cin >> k){
        for(int i=0;i<12;i++){
            cin >> ms[i];
        }
        printf("%d\n",fun(ms,k));
    }


    return 0;
}

/*
void ksort(int a[],int l,int r){
    if(r - l < 2) return;
    int start = l,end = r;
    while(l < r){
        while(++l < end && a[l] <= a[start]);
        while(--r > start && a[r] >= a[start]);
        if(l < r) swap(a[l],a[r]);
    }
    swap(a[start],a[r]);

    ksort(a,start,r);
    ksort(a,l,end);
}


int cp(const void *a,const void *b){
    return *(int *)a - *(int *)b;
}
int main(){
    int k ;
    int ms[12];
    freopen("01.in","r",stdin);
    while(cin >> k){
        for(int i=0;i<12;i++){
            cin >> ms[i];
        }
        if(0 == k) {
            printf("0\n");
            break;
        }
        //
        //int (* cmp )(const void *,const void *);
        //cmp = cp;
        //
        ksort(ms,0,12);
        int sum = 0;
        bool ok = false;
        for(int i=11;i>=0;i--){
            sum += ms[i];
            if(sum >= k){
                printf("%d\n",12-i);
                ok = true;
                break;
            }
        }
        if(!ok){
            printf("-1\n");
        }
    }


    return 0;
}
*/
/*
int arr[105];
int main(){
    int n;
    freopen("03.in","r",stdin);
    while(cin >> n){
        if(0 == n) break;
        int max = -0xfffffff;
        int p = 0;
        for(int i=0;i<n;i++){
            cin >> arr[i];
            if(arr[i] > max){
                max = arr[i];
                p = i;
            }
        }
        if(p != 0){
            int tmp = arr[0];
            arr[0] = arr[p];
            arr[p] = tmp;
        }

        for(int i=0;i<n;i++){
            cout << arr[i] << " ";
        }
        cout << endl;
    }

    return 0;
}
*/
/*

*/
/*

*/
/*

*/
/*
int main(void){
    double n,m;
    while(cin >> n >> m){
        // an = (an - 1)^(1/2);
        double res = 0;
        while(m--){
            res += n;
            n = sqrt(n);
        }
        printf("%.2lf\n",res);// << res << endl;
    }
    return 0;
}
*/
