import java.math.BigInteger;
import java.util.Scanner;



public class _Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int kase;
		kase = sc.nextInt();
		
		while(kase-- != 0){
			int k = sc.nextInt();
			int l,r;
			l = sc.nextInt();
			r = sc.nextInt();
			System.out.println(q(k,l,r).mod(new BigInteger("1000000007")));
		}
	}

	private static BigInteger q(int k, int l, int r) {
		BigInteger c = new BigInteger("0");
		for(int i=l;i<=r;i++){
			c = c.add(f(i,k));
//System.out.println(c);
		}
		
		return c;
	}

	private static BigInteger f(int n, int k) {
		// TODO Auto-generated method stub
		BigInteger c = new BigInteger("0");
		int ci = n / k;
		for(int i=1;i<=ci;i++){
			 // 首项 i*k ;公差为i；计算第(n-i*k)项
			int gc = i;
//System.out.print(1+(n-i*k)*gc+" ");
			long ani = 1 + (n-i*k)*gc;
//System.out.println(ani);
			c = c.add(new BigInteger(ani+""));
		}
		c = c.add(new BigInteger("1"));
System.out.println(n+":"+c);
		return c;
	}
	
}
