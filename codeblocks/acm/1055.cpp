/*

��������
v = n*va {n = (1,2,3...) && v <=vb}

||

n*va % vb = v; && n*va <= vb

vb % va = v; b��a�ﵽ��ο���ʣ��ĸպ���v����ֵΪvb%va
||
v % va = 0;vǡ����va��������           ,��ֵΪva
||
v = n*va + vb%va;->(v - vb%va)%va==0������
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
        //С������Ϊ0�����������ִ���1
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

