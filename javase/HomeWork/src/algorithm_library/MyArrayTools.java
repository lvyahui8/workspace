package algorithm_library;

import work03.question01.Comparator;

public class MyArrayTools {
	
	private MyArrayTools(){};//��֤���ܴ�������
	/**
	���ַ����ָ��Ԫ�ص�����
	@param arr ����һ����������
	@param key Ҫ�ҵ�Ԫ��
	@return Ԫ�ش��ڷ��ؽǱ꣬Ԫ�ز����ڷ��أ�-����λ��-1��
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
	���������ѡ������
	@param arr ����һ������
	@param comp �Ƚ������������
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
	��ȡ�������������ֵ�ĽǱ�
	@param arr ����һ����������
	@return ������������Ԫ�صĽǱ�
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
	��ȡ���������ƽ��ֵ
	@param arr ����һ����������
	@return ������ƽ��ֵ
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
