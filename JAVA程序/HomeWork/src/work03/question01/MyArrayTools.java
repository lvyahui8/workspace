package work03.question01;

public class MyArrayTools {
	private MyArrayTools(){};//保证不能创建对象
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
	获取数组的最大值的角标
	@param arr 接收一个数组
	@param comp 比较器
	@return 该数组中最大的元素的角标
	*/
	public static int getMaxIndex(Object [] arr,Comparator comp) 
	{
		int	maxIndex = 0;
		for (int i=1;i<arr.length ; i++) {
		    if (comp.compare(arr[i], arr[maxIndex])) {
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
	public static double getAverageValue( Integer [] arr) {
		Integer sum = 0;
		for (int i = 0; i < arr.length; i++) {
			sum = sum + arr[i];
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
