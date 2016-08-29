#include <stdio.h>
bool isOk = false;
int bsearch(int arr[],int start,int end,int key){
    int l = start;
    int r = end-1;
    while(l<=r){
        int m = (l + r)>>1;
        if(arr[m]<key){ // r
            l = m + 1;
        }
        else if(arr[m]>key){
            r = m - 1;
        }else{
            return m;
        }
    }
    return -l-1;
}
int tbsearch(int arr[],int n){
    int l = 0;
    int r = n-1;
     //如果是升序
    if(arr[l] < arr[r]){    //短点正好在0或n-1之间
        isOk = true;
        return n-1;
    }
    while(l<=r){
        int m = (l + r)>>1;
        if(l>=m) return l;
        if(arr[m]>arr[l] && arr[m] > arr[m-1]){ // 大于左边所有的数，在右边搜索 || arr[m] < arr[m+1] && arr[m] > arr[r]
            l = m;
        }
        else if(arr[m]<arr[r] && arr[m] < arr[m+1]){// 小于右边所有的数 在左边搜索|| arr[m] > arr[m-1] && arr[m] < arr[l]
            r = m;
        }
    }
    return -l-1;
}
int search(int arr[],int n,int key){
    //首先对循环有序数组用二分查找找分界点
    int res ;
    //找断点
    isOk = false;
    int max_index = tbsearch(arr,n);
    if(arr[max_index] == key){
        res = max_index;
    }
    else if(isOk){
        res = bsearch(arr,0,n,key);
    }
    else if(key < arr[0]){
        res = bsearch(arr,max_index+1,n,key);
    }
    else if(key > arr[n-1]){
        res = bsearch(arr,0,max_index,key);
    }

    return res;
}

int main(){

    int arr1[] = {6,7,8,9,1,2,3,4,5};//
    //int arr2[] = {9,8,7,6,5,15,14,12,11};
    int arr3[] = {1,2,3,4,5,6,7,8,9};
    //int arr4[] = {9,8,7,6,5,4,3,2,1};
    int arr5[] = {7,8,9,1,2,3,4,5,6};//
    printf("%d\n",tbsearch(arr1,9)); // 7
    //printf("%d\n",tbsearch(arr2,9)); // 7
    printf("%d\n",tbsearch(arr3,9)); // 7
    //printf("%d\n",tbsearch(arr4,9)); // 7
    printf("%d\n",tbsearch(arr5,9)); // 7
    int tmp ;
    while(scanf("%d",&tmp) == 1 && tmp){
        printf("%d %d %d\n",search(arr1,9,tmp),search(arr3,9,tmp),search(arr5,9,tmp));
    }
    return 0;
}
