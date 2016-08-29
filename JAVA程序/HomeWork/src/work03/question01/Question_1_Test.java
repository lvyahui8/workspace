package work03.question01;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

/*

作业一：
定义一个表示学生信息的类Student，要求如下：
（1）类Student的成员变量：
sNO　表示学号；sName表示姓名；sSex表示性别；sAge表示年龄；sJava：表示Java课程成绩。
（2）类Student带参数的构造方法： 
在构造方法中通过形参完成对成员变量的赋值操作。
（3）类Student的方法成员：
getNo（）：获得学号； 
getName（）：获得姓名； 
getSex（）：获得性别；
getAge（）获得年龄；
getJava（）：获得Java 课程成绩
根据类Student的定义，创建五个该类的对象，输出每个学生的信息，计算并输出这五个学生Java语
言成绩的平均值，以及计算并输出他们Java语言成绩的最大值和最小值。

*/
public class Question_1_Test {

	public static void main(String[] args) {
		List<Student> list = new ArrayList<Student>();
		
		Random r = new Random();
		for (int i = 0; i < 5; i++) {
			list.add(new Student("00" + i, 
					"" + (char) (i + 92 + r.nextInt(26)) + (char) (i + 92 + r.nextInt(26)), 
					r.nextInt(2) == 1 ? "女" : "男", 
					"" + (r.nextInt(5) + 17), 
					"" + (r.nextInt(50) + 50)));
		}
		Integer [] arrJava = new Integer[list.size()];
		
		for (int i=0;i<list.size();i++) {
			Student student = list.get(i);
			System.out.println(student);
			arrJava[i] = Integer.parseInt(student.getsJava());
		}
		
		double averageValue  =  MyArrayTools.getAverageValue(arrJava);
		
		MyArrayTools.seleteSort(arrJava,new Comparator() {
			@Override
			public boolean compare(Object obj1, Object obj2) {
				int i1 = (Integer)obj1;
				int i2 = (Integer)obj2;
				
				return i1 > i2;
			}
		});
		System.out.println("平均值："+averageValue);
		System.out.println("最大值："+arrJava[arrJava.length-1]);
		System.out.println("最小值："+arrJava[0]);
	}

}
