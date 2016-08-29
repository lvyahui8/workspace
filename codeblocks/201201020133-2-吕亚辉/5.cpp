#include <stdio.h>
#include <malloc.h>

typedef struct ele{
	double w;		//重量
	double b;		//价值
	double d;		//均值
}Ele;

void swap(Ele * a,Ele * b)
{
    Ele * temp;
    temp=a;
    a=b;
    b=temp;
}

void qsort(int l,int n,Ele * a[]){
    if(n<l+2) return;
    int p,e,r;
    p = l;                              //节点选在数组的第一个元素
    e = r = n;
    while(l<r){
        while(++l < e && a[l]->d>=a[p]->d);  //找出在[l,e]之中第一个比节点小的数
        while(--r > p && a[r]->d<=a[p]->d);  // 找出在[p,r]之中第一个比节点大的数（这个数一般更靠近r）
        //交换找出的这两个数，将小的放在节点前面，
        //大的放在节点后面。如果r已经小于l了，就必要交换了，结下来直接将节点放在r与l中间就行了
        if(l<r) {swap(a[l],a[r]);}
    }
    swap(a[p],a[r]);                //将节点放到正确的位置上去
    //下面对节点左侧和右侧再重复上面的过程
    qsort(p,r,a);                       //左侧
    qsort(l,e,a);                       //右侧
}

double knapsack(Ele ** eles,int n,double maxW){
	qsort(0,n,eles);
	int cW = 0;	//总重
	int cB = 0;	//总值
	for(int i=0;i<n && cW<maxW;i++){
		if((eles[i]->w+cW)<maxW){	//全放进来空间足够
			cW += eles[i]->w;
			cB += eles[i]->b;
		}
		else{
			int tmp = maxW - cW;	//计算还能放多少
			cW += tmp;
			cB += tmp * eles[i]->d;	//计算放进来的价值
		}
	}
	return cB;
}

int main(){
	freopen("5.in","r",stdin);
	int n;
	double maxW;
	scanf("%d",&n);
	scanf("%lf",&maxW);
	Ele ** eles=(Ele **)malloc(sizeof(Ele*)*n);
	for(int i=0;i<n;i++){
		eles[i] =  (Ele *)malloc(sizeof(Ele));
		scanf("%lf%lf",&eles[i]->w,&eles[i]->b);
		eles[i]->d = eles[i]->b/eles[i]->w;
	}
	printf("%lf\n",knapsack(eles,n,maxW));
	return 0;
}