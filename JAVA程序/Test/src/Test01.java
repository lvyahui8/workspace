
public class Test01 {

	public static void main(String[] args) {
		// TODO �Զ����ɵķ������
		int a = 3 , b = 4;
		System.out.println("a = "+a+" b = "+b);
		a ^= b ^= a ^= b;
		System.out.println("a = "+a+" b = "+b);
	}
}
