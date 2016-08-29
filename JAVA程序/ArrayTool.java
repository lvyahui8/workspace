/**
��������Ĺ���
@author ���ǻ�
@version V1.0
*/
//	�ĵ�ע��ֻ����ȡ���еĻ��߱�������Ա���ĵ���Ϣ
public class ArrayTool 
{
	private ArrayTool(){};//��֤���ܴ�������
	/**
	���ַ����ָ��Ԫ�ص�����
	@param arr ����һ����������
	@param key Ҫ�ҵ�Ԫ��
	@return Ԫ�ش��ڷ��ؽǱ꣬Ԫ�ز����ڷ��أ�-����λ��-1��
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
	���������ѡ������
	@param arr ����һ����������
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
	��һ��������ת�����ַ���
	@param arr ����һ����������
	@return �����ַ���
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
	�ڿ���̨�±��������������
	@param arr ����һ����������
	*/
	public static void printArray(int [] arr){
		for(int i=0;i<arr.length;i++){
			System.out.print("Array["+i+"]="+arr[i]+" ");
		}
		System.out.print('\n');
	}
}
