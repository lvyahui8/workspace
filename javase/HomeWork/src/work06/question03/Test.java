package work06.question03;

import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;


public class Test {

	public static void main(String[] args) {
		Set<Student> studs = new HashSet<Student>();
		
		studs.add(new Student("2011", "LvYahui_1", "��", "Age1"));
		studs.add(new Student("2011", "LvYahui_2", "��", "Age2"));
		studs.add(new Student("2011", "LvYahui_1", "��", "Age1"));
		studs.add(new Student("2011", "LvYahui_3", "��", "Age3"));
		studs.add(new Student("2011", "LvYahui_4", "��", "Age1"));
		
		for (Iterator<Student>iterator = studs.iterator(); iterator.hasNext();) {
			Student student = (Student) iterator.next();
			System.out.println(student);
		}
	}

}
