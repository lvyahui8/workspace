package cn.itcast.String.Demo;

public class StringArraySort {

	public static void main(String[] args) {
		// TODO 自动生成的方法存根
		String[] arr = { "sds", "fdg", "wer", "cvbv", "jkl" };
		printArray(arr);
		sortStringArray(arr);
		printArray(arr);
	}

	private static void sortStringArray(String[] arr) {
		// TODO 自动生成的方法存根
		for (int i = 0; i < arr.length - 1; i++) {
			int p = i;
			for (int j = i + 1; j < arr.length; j++) {
				if (arr[p].compareTo(arr[j])>0) {
					p = j;
				}
			}
			
			if (p != i) {
				String temp = arr[i];
				arr[i] = arr[p];
				arr[p] = temp;
			}
		}
	}

	private static void printArray(String[] arr) {
		// TODO 自动生成的方法存根
		System.out.print("[");
		for (int i = 0; i < arr.length; i++) {
			if (i != arr.length-1) {
				System.out.print(arr[i] + ",");
			} else {
				System.out.println(arr[i] + "]");
			}
		}
	}

}
