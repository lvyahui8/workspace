#include <stdio.h>

int HalfSearch(int  arr[],int x){
	int left=0,right=9-1,middle;
	while(left <= right){
		middle = (left+right) >> 1;
		if(x == arr[middle]){
			return middle;
		}
		else if(x > arr[middle]){
			left = middle+1;
		}
		else if(x < arr[middle]){
			right = middle-1;
		}
	}
	return -1;
}
int HalfSearchIndex(int  arr[],int x){
	int left=0,right=9-1,middle;
	while(left <= right){
		middle = (left+right) >> 1;
		if((x <arr[middle] && x > arr[middle-1]) || x == arr[middle]){
			return middle;
		}
		else if(x > arr[middle]){
			left = middle+1;
		}
		else if(x < arr[middle]){
			right = middle-1;
		}
	}
	return 9;
}

int HalfSearchIndex_2(int  arr[],int x){
	int left=0,right=9-1,middle;
	while(left <= right){
		middle = (left+right) >> 1;
		if(x == arr[middle]){
			return middle;
		}
		else if(x > arr[middle]){
			left = middle+1;
		}
		else if(x < arr[middle]){
			right = middle-1;
		}
	}
	return left;
}

void main(){
	int arr[]={1,2,3,4,6,7,8,9,10};
	printf("index = %d",HalfSearch(arr,6));
	printf("index = %d",HalfSearchIndex_2(arr,12));
}
