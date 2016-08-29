/**
操作数组的工具
@author 吕亚辉
@version V1.0
*/
//	文档注释只能提取共有的或者被保护成员的文档信息
public class ArrayTool 
{
	private ArrayTool(){};//保证不能创建对象
	/**
	二分法获得指定元素的索引
	@param arr 接收一个整型数组
	@param key 要找的元素
	@return 元素存在返回角标，元素不存在返回（-插入位置-1）
	*/
	public static int HalfSearch(int [] arr,int key){
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
	@param arr 接收一个整型数组
	*/
	public static void selectSort(int [] arr){
		for(int i = 0;i < arr.length-1;i++){
			int p = i;
			for(int j=i+1;j<arr.length;j++){
				if(arr[p]>arr[j]){
					p = j
				}
			}
			if (p!=i) {
			    swap(arr,i,p);
			}	
		}
	}

	private static void swap(int []arr,int a,int b){
		int temp = arr[a];
		arr[a] = arr[b];
		arr[b] = temp;
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
	将一个整数组转换成字符串
	@param arr 接收一个整型数组
	@return 返回字符串
	*/
	public  static String arrayToString(int [] arr){
		String str = "";
		for(int i=0; i<arr.length;i++){
			if(i!=arr.length-1){
				str = str + arr[i] + ",";
			}
			else {
			    str = str + arr[i] + "}";
			}
		}
		return str;
	}
	/**
	在控制台下遍历输出整个数组
	@param arr 接收一个整型数组
	*/
	public static void printArray(int [] arr){
		for(int i=0;i<arr.length;i++){
			System.out.print("Array["+i+"]="+arr[i]+" ");
		}
		System.out.print('\n');
	}
}
