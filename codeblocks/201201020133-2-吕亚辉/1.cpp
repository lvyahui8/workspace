#include <stdio.h>

void swap(int &a,int &b)
{
    int temp;
    temp=a;
    a=b;
    b=temp;
}
//l数组的第一个元素索引，n数组元素个数，a数组首地址
void qsort(int l,int n,int * a){
    if(n<l+2) return;
    int p,e,r;
    p = l;                              //节点选在数组的第一个元素
    e = r = n;
    while(l<r){
        while(++l < e && a[l]<=a[p]);  //找出在[l,e]之中第一个比节点大的数
        while(--r > p && a[r]>=a[p]);  // 找出在[p,r]之中第一个比节点小的数（这个数一般更靠近r）
        //交换找出的这两个数，将小的放在节点前面，
        //大的放在节点后面。如果r已经小于l了，就必要交换了，结下来直接将节点放在r与l中间就行了
        if(l<r) swap(a[l],a[r]);
    }
    swap(a[p],a[r]);                    //将节点放到正确的位置上去
    //下面对节点左侧和右侧再重复上面的过程
    qsort(p,r,a);                       //左侧
    qsort(l,e,a);                       //右侧
}
void print(int *a,int n){
    int i = 0;
    for(;i<n;i++){
        printf("%d ",a[i]);
    }
    printf("\n");
}
int main()
{
    int a[]={2,6,3,4,1,5,9,7,8};
    print(a,9);
    qsort(0,9,a);
    print(a,9);
    return 0;
}
