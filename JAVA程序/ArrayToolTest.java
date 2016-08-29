class ArrayToolTest 
{
	public static void main(String[] args) 
	{
		int [] arr = {2,3,6,7,8,9,0,1,4};
		System.out.println("数组中的最大值s所在位置:"
			+ArrayTool.getMaxIndex(arr));
		System.out.println("未排序前的数组:");
		ArrayTool.printArray(arr);
		//	排序
		ArrayTool.selectSort(arr);
		System.out.println("排序后的数组:");
		ArrayTool.printArray(arr);
		System.out.println("7在数组中的位置:"
			+ArrayTool.HalfSearch(arr,7));
		System.out.println("将数组转换成字符串:"
			+ArrayTool.arrayToString(arr));
	}
}
