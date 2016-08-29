import java.util.*;

public class ArrayFind 
{
	public static void main(String[] args) 
	{
		int arr[]={1,2,3,4,6,7,8,9,10};
		System.out.println("index = "+HalfSearch(arr,8));
		System.out.println("����� = "+HalfSearchIndex(arr,6));
		int index = Arrays.binarySearch(arr,5);
		// ���صڶ��������������е�����λ�ã����û���򷵻ؿ������������λ�ã���-λ��-1����
		// Ϊʲô��������Ϊ�������λ���ڵ�һ��ǰ�棬�Ͳ��ܷ���0��
		System.out.println("�������߲���λ�� = "+index);
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
