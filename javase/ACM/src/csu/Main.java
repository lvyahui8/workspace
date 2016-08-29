package csu;

import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int k;
		k = sc.nextInt();
		while(k-- > 0){
			Set<Long> set = new HashSet<Long>();
			for(int x = 0;x<2;x++){
				int n = sc.nextInt();
				for(int i=0;i<n;i++){
					long a, b;
					a = sc.nextLong();b = sc.nextLong();
					set.add(a);set.add(b);
					for(long j=a+1;j<b;j++){
						set.add(j);
					}
				}
			}
			
			System.out.println(set.size());
		}
	}
}
