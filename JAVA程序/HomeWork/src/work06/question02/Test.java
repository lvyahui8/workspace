package work06.question02;

import java.util.Comparator;
import java.util.Iterator;
import java.util.Set;


public class Test {

	public static void main(String[] args) {
		
		Stamp sta3 = new Stamp(3,5);
		Stamp sta5 = new Stamp(5,4);
		
		Set<Integer> postages 
		= 
		CensusTools.computePostage(sta3, sta5, new Comparator<Integer>() {
			@Override
			public int compare(Integer o1, Integer o2) {
				return o1.intValue() < o2.intValue() ? -1 : (o1.equals(o2) ? 0 : 1);
			}
		});
		 
		for (Iterator<Integer>iterator = postages.iterator(); iterator.hasNext();) {
			Integer integer = iterator.next();
			System.out.println(integer);
		}
		
	}


}
