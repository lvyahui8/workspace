import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;


public class A {
	public static void main(String[] args) {
		Set<Integer> s = new HashSet<Integer>();
		Scanner sc = new Scanner(System.in);
		
		int kase;
		kase = sc.nextInt();
		while(kase-- != 0){
			int num = sc.nextInt();
			s.clear();
			while(num-- != 0){
				s.add(sc.nextInt());
			}
			System.out.println(s.size());
		}
	}
}
