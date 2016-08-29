import java.util.Comparator;
import java.util.Iterator;
import java.util.Scanner;
import java.util.Set;
import java.util.TreeSet;


public class B {
	public static int [] m = new int[400];
	public static void main(String[] args) {
		Set<Integer> s = new TreeSet<Integer>(new Comparator<Integer>() {
			@Override
			public int compare(Integer o1, Integer o2) {
				return o2.intValue() - o1.intValue();
			}
		});
		Scanner sc = new Scanner(System.in);
		
		int kase ;
		kase = sc.nextInt();
		
		while(kase-- != 0){
			int n = sc.nextInt();
			for(int i=1;i<=n;i++){
				m[i] = sc.nextInt();
			}
			
			
			for(int i=1;i<=n;i++){
				int sum = 0;
				int c = sc.nextInt();
				while(c-- != 0){
					sum += m[sc.nextInt()];
				}
				s.add(sum);
			}
			
			Iterator it = s.iterator();
			if(it.hasNext()){
				System.out.println(it.next());
			}
			
		}
	}
}
