package work08.question02;

import java.util.ArrayList;
import java.util.List;

public class Test {

	public static void main(String[] args) {
		//
		String [] strings = { "bb", "aa", "cc", "dd", "ee", "bb", "ee", "dd"};
		List<String> list = new ArrayList<String>();
		
		for (int i = 0; i < strings.length; i++) {
			String string = strings[i];
			if(!list.contains(string)){
				list.add(string);
			}
		}
		System.out.println(list);
	}

}
