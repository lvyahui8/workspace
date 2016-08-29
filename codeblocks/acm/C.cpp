#include <stdio.h>

int main(){

    int T ;
    scanf("%d",&T);

    while(T--){
        int n ;
        scanf("%d",&n);
        int q=0,h,piq=1,maxj=1;
        for(int i=1;i<=n;i++){
            scanf("%d",&h);
            if(h!=q+1){//ÌøÁË
                int t = i -piq;
                if(t>maxj){
                    maxj = t;
                }
                piq = i;
            }
            q = h;
        }

        printf("%d\n",maxj);
    }


    return 0;
}
