
public class newFunDemo {

	public static void main(String[] args) {
		// TODO 自动生成的方法存根
		method();
		method(1,2,3,4,5,6,7,8);
	}
	public static int method(/*可以有哦其他参数，*/int... arr/*，不能再有参数*/){//...代表很多，其实就是数组。自动将元素封装成数组，简化书写，有局限性，在它后面不能有参数
		System.out.println(arr);
		for (int i = 0; i < arr.length; i++) {
			System.out.print(arr[i]+" ");
		}
		return 0;
	}
	
//	public static int method(int[] arr){
//		System.out.println(arr);
//		for (int i = 0; i < arr.length; i++) {
//			System.out.print(arr[i]+" ");
//		}
//		return 0;
//	}
	
}
