package work06.question01;

import java.util.LinkedList;
import java.util.List;



public class Test {
	
	private static final int MAN_COUNTS = 500;//人数
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		List<Integer>childs = new LinkedList<Integer>();
		for (int i = 1; i <= MAN_COUNTS; i++) {
			childs.add(i);
//			System.out.println(childs.get(i));
		}
		outPeople(childs,new Printer(){
			@Override
			public void println(Object obj) {
				System.out.println(obj);
			}
			@Override
			public void print(Object obj) {
				System.out.print(obj);
			}
		});
	}


	/**
	 * T人出局，并输出
	 * @param childs
	 */
	private static void outPeople(List<Integer> childs,Printer ptr) {
		int k = -1;
		
		while(childs.size()>2){
			for (int i = 0; i < childs.size(); ) {
				k = (k+1)%3;//报号
				if (2 == k) {
					if(null != ptr){
						ptr.print((childs.get(i) + " "));
					}
					childs.remove(childs.get(i));
				}
				else{
					i++;
				}
			}
			if(null != ptr){
				System.out.println("");
			}
		}
	}

}

