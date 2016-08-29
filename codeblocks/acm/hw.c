#include <stdio.h>

int hw(int i){
    int tmp  = 0;
    while(i>0)
    {
        tmp = tmp * 10 + i%10;
        i /= 10;
    }
    return tmp;
}

int resove(int i,int * pw){
    if(i<=0) {
        return 0;
    }
    int tmp = resove(i/10,pw);
    *pw += 1;

    return  (i%10) * (int)pow(10,(*pw)) + tmp;
}

int isHW(int i){
    int a = -1;
    //printf("%d\n",resove(i,&a));
    return resove(i,&a) == i;
}

int main(){
    printf("%d\n",hw(12345));
    printf("%d\n",isHW(12345));
    //char str[]="dengjie";
    char * str="dengjie";
    str = NULL;
    return 0;
}
