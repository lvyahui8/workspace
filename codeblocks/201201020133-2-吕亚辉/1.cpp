#include <stdio.h>

void swap(int &a,int &b)
{
    int temp;
    temp=a;
    a=b;
    b=temp;
}
//l����ĵ�һ��Ԫ��������n����Ԫ�ظ�����a�����׵�ַ
void qsort(int l,int n,int * a){
    if(n<l+2) return;
    int p,e,r;
    p = l;                              //�ڵ�ѡ������ĵ�һ��Ԫ��
    e = r = n;
    while(l<r){
        while(++l < e && a[l]<=a[p]);  //�ҳ���[l,e]֮�е�һ���Ƚڵ�����
        while(--r > p && a[r]>=a[p]);  // �ҳ���[p,r]֮�е�һ���Ƚڵ�С�����������һ�������r��
        //�����ҳ���������������С�ķ��ڽڵ�ǰ�棬
        //��ķ��ڽڵ���档���r�Ѿ�С��l�ˣ��ͱ�Ҫ�����ˣ�������ֱ�ӽ��ڵ����r��l�м������
        if(l<r) swap(a[l],a[r]);
    }
    swap(a[p],a[r]);                    //���ڵ�ŵ���ȷ��λ����ȥ
    //����Խڵ������Ҳ����ظ�����Ĺ���
    qsort(p,r,a);                       //���
    qsort(l,e,a);                       //�Ҳ�
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
