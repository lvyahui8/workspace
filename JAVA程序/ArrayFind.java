import java.util.*;

public class ArrayFind 
{
	public static void main(String[] args) 
	{
		int arr[]={1,2,3,4,6,7,8,9,10};
		System.out.println("index = "+HalfSearch(arr,8));
		System.out.println("插入点 = "+HalfSearchIndex(arr,6));
		int index = Arrays.binarySearch(arr,5);
		// 返回第二个参数在数组中的索引位置，如果没有则返回可以让它插入的位置：（-位置-1），
		// 为什么这样，因为如果插入位置在第一个前面，就不能返回0。
		System.out.println("索引或者插入位置 = "+index);
	}

	public static int GetIndex(int [] arr,int x){
		for(int i=0;i<arr.length;i++){
			if(arr[i] == x)
				return i;
		}
		return -1;
	}

	public static int HalfSearch(int [] arr,int x){
		int left=0,right=arr.length-1,middle;
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

	public static int HalfSearchIndex(int [] arr,int x){
		int left=0,right=arr.length-1,middle;
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
		return arr.length;
	}
}
