/*

必须满足
v = n*va {n = (1,2,3...) && v <=vb}

||

n*va % vb = v; && n*va <= vb

vb % va = v; b向a里到多次咖啡剩余的刚好是v，价值为vb%va
||
v % va = 0;v恰好事va的整数倍           ,价值为va
||
v = n*va + vb%va;->(v - vb%va)%va==0是整数
||

va ,vb,vb%va

///
    long s = 1;
    for(int i=1;s <= vb;i++){
        s = i*va;
        if(s%vb==v){
            return true;
        }
    }
    return false;
    //

    //
        if(!(va>=1 && va <= vb && vb <=1000 && v >=1 && v <= vb)){
            printf("NO\n");
            continue;
        }
       //
        //double n = v / va;
        //double z;
        //小数部分为0，且整数部分大于1
        //if(!modf(n,&z) && z >= 1 && v <= vb){
*/
#include <stdio.h>
#include <math.h>
bool ok(int v,int va,int vb){
    return vb % va == v || v % va == 0 || (v - vb%va)%va==0;
}
int main(){

    int v,va,vb;
    while(scanf("%d%d%d",&v,&va,&vb) == 3 && v && va && vb){

        if(ok(v,va,vb)){
            printf("YES\n");
        }else{
            printf("NO\n");
        }
    }
    return 0;
}

