package work03.question01;

public class MyArrayTools {
	private MyArrayTools(){};//��֤���ܴ�������
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
	��ȡ��������ֵ�ĽǱ�
	@param arr ����һ������
	@param comp �Ƚ���
	@return ������������Ԫ�صĽǱ�
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
	��ȡ���������ƽ��ֵ
	@param arr ����һ����������
	@return ������ƽ��ֵ
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
