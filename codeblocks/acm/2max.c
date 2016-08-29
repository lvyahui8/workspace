
#include <stdio.h>

int _2max(int arr[],int n){
    if(n < 2) return -1;
    int m,_2m,i;
    if(arr[0] < arr[1]){
        m = arr[1];_2m = arr[0];
    }else{
        m = arr[0];_2m = arr[1];
    }

    for(i=2;i<n;i++){
        if(arr[i] > _2m){
            _2m = arr[i];
            if(_2m > m){
                int tmp = _2m;
                _2m = m;
                m = tmp;
            }
        }
    }
    return _2m;
}

int main(){
    int a1[] = {1,2,3,4,5,6};
    int a2[] = {3,4,2,1,2,1};
    int a3[] = {15,7,9,9,10};
    printf("%d\n",_2max(a1,6));
    printf("%d\n",_2max(a2,6));
    printf("%d\n",_2max(a3,5));
    return 0;
}

// h时m分  m时h分 m > h

