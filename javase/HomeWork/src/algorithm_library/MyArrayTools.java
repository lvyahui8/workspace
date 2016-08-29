package algorithm_library;

import work03.question01.Comparator;

public class MyArrayTools {
	
	private MyArrayTools(){};//保证不能创建对象
	/**
	二分法获得指定元素的索引
	@param arr 接收一个整型数组
	@param key 要找的元素
	@return 元素存在返回角标，元素不存在返回（-插入位置-1）
	*/
	public static int halfSearch(int [] arr,int key){
		int left=0,right=9-1,middle;
		while(left <= right){
			middle = (left+right) >> 1;
			if(key == arr[middle]){
				return middle;
			}
			else if(key > arr[middle]){
				left = middle+1;
			}
			else if(key < arr[middle]){
				right = middle-1;
			}
		}
		return -left-1;
	}
	/**
	对数组进行选择排序
	@param arr 接收一个数组
	@param comp 比较器（排序规则）
	*/
	public static void seleteSort(Object [] arr,Comparator comp)
	{
		int i,j,p;
		for(i=0;i<arr.length-1;i++){
			p = i;
			for(j=i+1;j<arr.length;j++){
				if(comp.compare(arr[p],arr[j])){
					p = j;
				}
			}
			
			if(p != i){
				swap(arr,p,i);
			}
		}
	}
	/**
	获取整型数组的最下值的角标
	@param arr 接收一个整型数组
	@return 该数组中最大的元素的角标
	*/
	public static int getMaxIndex(int [] arr) 
	{
		int	maxIndex = 0;
		for (int i=1;i<arr.length ; i++) {
		    if (arr[i]>arr[maxIndex]) {
		        maxIndex = i;
		    }
		}
		return	maxIndex;
	}
	/**
	获取整型数组的平均值
	@param arr 接收一个整型数组
	@return 该数组平均值
	*/
	public static double getAverageValue( int [] arr) {
		int sum = 0;
		for (int i = 0; i < arr.length; i++) {
			sum += arr[i];
		}
		return (double)sum/arr.length;
	}
	
	public static void swap(Object [] arr,int a,int b){
		Object temp;
		temp = arr[a];
		arr[a] = arr[b];
		arr[b] = temp;
	}
}
