
public class Test01 {

	public static void main(String[] args) {
		// TODO 自动生成的方法存根
		int a = 3 , b = 4;
		System.out.println("a = "+a+" b = "+b);
		a ^= b ^= a ^= b;
		System.out.println("a = "+a+" b = "+b);
	}
}
