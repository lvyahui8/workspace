package work06.question02;

import java.util.Comparator;
import java.util.Set;
import java.util.TreeSet;

public class CensusTools {
	public static Set<Integer> computePostage(Stamp sta1, Stamp sta2,
			Comparator<Integer> compr) {
		Set<Integer> postages = new TreeSet<Integer>(compr);
		int sta1Value = sta1.getValue();
		int sta2Value = sta2.getValue();
		int sta1Count = sta1.getCount();
		int sta2Count = sta2.getCount();
		for(int i = 1;i<=sta1.getCount() + sta2.getCount();i++){//i表示这一次总共要多少张
			int m = i, n = 0;//m表示拿几张面值为sta1Vale的邮票，n表示拿几张面值为sta2Vale的邮票。首先sta1全出
			for(;n<=i;m--,n++){
	
				if (m >= sta1Count) {//如果sta1全拿出来，但还不够
					postages.add(sta1Value * sta1Count + sta2Value * (m-sta1Count) + sta2Value *n);//sta1全出。sta2帮着补上，再将自己该出的也出了（或者说剩下的sta2出）
					continue;
				}
				if (n >= sta2Count) {
					postages.add(sta2Value * sta2Count + sta1Value * (n - sta2Count) + sta1Value  * m);
					continue;
				}
				postages.add(sta1Value*m+sta2Value*n);

			}
		}
		
		return postages;
	}
}
