#include<stdio.h>
int main(){
    int n,i,ti,tx,qi,qx,sum=0,tmin=1000,tmax=0,qmin=1000,qmax=0,a[1000],b[1000];
    while(scanf("%d",&n)!=EOF){
        for(i=0;i<1000;i++){
            a[i]=0;
            b[i]=0;
        }
        for(i=0;i<n;i++)
            scanf("%d",&a[i]);
        for(i=0;i<n;i++)
            scanf("%d",&b[i]);
            for(i=0;i<n;i++){
               if(a[i]<tmin){
                    tmin=a[i];
                    ti=i;
               }
               if(a[i]>tmax){
                tmax=a[i];
                tx=i;
               }
               if(b[i]<qmin){
                    tmin=b[i];
                    qi=i;
               }
               if(b[i]>qmax){
                    tmax=b[i];
                    qx=i;
               }

            for(i=0;i<n;i++){
                if(tmax>qmax){
                    a[tx]=0;
                    b[qx]=0;
                    sum=sum+200;
                    break;
            }else if(tmin>qmin){
                a[ti]=0;
                b[qi]=0;
                sum=sum+200;
                break;
            }
            else {
                a[ti]=0;
                b[qx]=0;
                sum=sum-200;
            }
            printf("%d\n",sum);
    return 0;
}
