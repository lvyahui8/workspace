class ArrayToolTest 
{
	public static void main(String[] args) 
	{
		int [] arr = {2,3,6,7,8,9,0,1,4};
		System.out.println("�����е����ֵs����λ��:"
			+ArrayTool.getMaxIndex(arr));
		System.out.println("δ����ǰ������:");
		ArrayTool.printArray(arr);
		//	����
		ArrayTool.selectSort(arr);
		System.out.println("����������:");
		ArrayTool.printArray(arr);
		System.out.println("7�������е�λ��:"
			+ArrayTool.HalfSearch(arr,7));
		System.out.println("������ת�����ַ���:"
			+ArrayTool.arrayToString(arr));
	}
}
