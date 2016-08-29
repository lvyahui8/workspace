package cn.itcast.wrapper.demo;
/*
 * "20 78 9 -7 88 36 29"
 * 
 */
import java.util.Arrays;
public class WrapperTest {
	private static final String SPACE_SEPARATOR = " ";
	public static void main(String[] args) {
		// TODO �Զ����ɵķ������
		String numStr = "20 78 9 -7 88   36 29";
		System.out.println(numStr);
		
		String result = sortStringNumber(numStr);
		
		System.out.println(result);
	}			

	private static String sortStringNumber(String numStr) {
		// TODO �Զ����ɵķ������
		//	1�����ַ�������ַ������顣
		String [] str_arr = stringToArray(numStr);
		//	2�����ַ�������ת����int����
		int [] num_arr = toIntArray(str_arr);
		//	3������
		sortArray(num_arr);
		//	4��������õ�����ת�����ַ�������
		return arrayToString(num_arr);
	}

	private static String arrayToString(int[] num_arr) {
		// TODO �Զ����ɵķ������
		StringBuffer result = new StringBuffer();
		for (int i = 0; i < num_arr.length; i++) {
			 result.append(num_arr[i]+SPACE_SEPARATOR);
			
		}
		result.deleteCharAt(result.length()-1);
		return result.toString();
	}

	private static void sortArray(int[] num_arr) {
		// TODO �Զ����ɵķ������
		Arrays.sort(num_arr);
	}

	private static int[] toIntArray(String[] str_arr) {
		// TODO �Զ����ɵķ������
		int [] arr = new int[str_arr.length];
		for (int i = 0; i < arr.length; i++) {
			arr[i] = Integer.parseInt(str_arr[i]);
		}
		return arr;
	}

	/**
	 * @param numStr
	 * @return
	 */
	private static String[] stringToArray(String numStr) {
		return numStr.split(SPACE_SEPARATOR+"+");		//  ������ʽ ��+��ʾ�����Ƕ���ո�
	}

}
