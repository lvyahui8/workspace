#include <iostream>
#include <stdio.h>

using namespace std;

int binarySearch(int a[],int b,int c){
    int left = 0;
    int right = c-1;
    while(left<=right){
        int middle = (left+right)/2;
        if(a[middle]==b) return middle+1;
        if((a[middle]>b) && (a[left]<=b)){
            right = middle - 1;
        }else if((a[middle]<b) && (a[right]<b)){
            right = middle - 1;
        }else{
            left = middle+1;
        }
    }
    return -1;
}

int main()
{
    int a[10] = {6,7,8,9,1,2,3,4,5};
    int arr1[] = {6,7,8,9,1,2,3,4,5};//
    //int arr2[] = {9,8,7,6,5,15,14,12,11};
    int arr3[] = {1,2,3,4,5,6,7,8,9};
    //int arr4[] = {9,8,7,6,5,4,3,2,1};
    int arr5[] = {7,8,9,1,2,3,4,5,6};//
    int b, c;
    while(scanf("%d",&b)==1){
        c = binarySearch(a,b,10);
        cout << c << " "<<binarySearch(arr1,b,10)<<" "<<binarySearch(arr3,b,10)<<" "<<binarySearch(arr5,b,10)<<endl;
    }
    return 0;
}
