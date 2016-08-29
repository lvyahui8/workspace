/*
需求：在一个有限数组里找出第K小的数
思路：
1.
2.输入要K值
3.输出，根据个数将倒序排好的数列输出
*/
#include <stdio.h>
#define LENGTH 100000
//需要两个整型变量地址
void swap(int * x,int * y){
	int temp;
	temp=*x;
	*x=*y;
	*y=temp;
}

int partition(int array[],int left,int right){
	int pivot=array[left];
	int middle;
	int l=left;
	int r=right;
	while(l<r)
	{
		while(array[l]<=pivot && l<=right)
			l++;
		while(array[r]>pivot && r>=left)
			r--;
		if(l<r)
		{
			swap(&array[l],&array[r]);
		}
	}
	middle=r;
	swap(&array[left],&array[middle]);
	return middle; // 返回节点
}

int search(int array[],int left,int right,int k){
	int middle;
	if(left==right)
		return left;
	middle=partition(array,left,right);
	if(middle-left+1>=k)
		return search(array,left,middle,k);
	else
		return search(array,middle+1,right,k-(middle-left+1));
}

void main(){
	//int array[LENGTH]={0,1,3,2,7,4,9,8,6,5};
	int array[LENGTH];
	int k=5;
	int a,i;
	for(i=0;i<LENGTH;i++)
		array[i]=i+1;
	//a=search(array,0,LENGTH-1,3000);
	//printf("%d\n",array[a]);
	////a=search(array,0,LENGTH-1,6100);
	//printf("%d\n",array[a]);
	a=search(array,0,LENGTH-1,61000);
	printf("%d\n",array[a]);
}
