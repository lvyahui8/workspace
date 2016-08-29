import java.util.*;

public class ArraySort 
{
	public static void main(String[] args) 
	{
		int [] arr = {2,3,4,1,6,8,5,9,7};
		PrintArray(arr);
		//SeleteSort(arr);
		BubbleSort(arr);
		PrintArray(arr);
		//Arrays.sort(arr);// java µÄ·½·¨
	}
	
	public static void PrintArray(int [] arr){
		int	i=0;
		for(i=0;i<arr.length;i++){
			System.out.println("arr["+i+"]="+arr[i]);
		}
	}

	public static void SeleteSort(int [] arr)
	{
		int i,j,p;
		for(i=0;i<arr.length-1;i++){
			p = i;
			for(j=i+1;j<arr.length;j++){
				if(arr[p]>arr[j]){
					p = j;
				}
			}

			if(p != i){
				Swap(arr,p,i);
			}
		}
	}
	public static void BubbleSort(int [] arr){
		int i,j;
		for(i=0;i<arr.length-1;i++){
			for(j=0;j<arr.length-1-i;j++){
				if(arr[j]>arr[j+1]){
					Swap(arr,j,j+1);
				}
			}
		}
	}

	public static void Swap(int [] arr,int a,int b){
		int temp;
		temp = arr[a];
		arr[a] = arr[b];
		arr[b] = temp;
	}
}
