package cn.itcast.map.demo;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Set;

import cn.itcast.generic.demo.Student;

public class HashMapDemo {

	public static void main(String[] args) {
		// TODO 自动生成的方法存根
		/*
		 * 将学生对象和学生的归属地通过键与值存储到map集合中
		 * 
		 */
		HashMap<Student,String> hm = new HashMap<Student,String>();
		hm.put(new Student("kk_1",21), "北京");
		hm.put(new Student("kk_2",22), "上海");
		hm.put(new Student("kk_3",23), "深圳");
		hm.put(new Student("kk_4",24), "香港");
		hm.put(new Student("kk_4",24), "新加坡");
		
//		Set<Student> keySet = hm.keySet();
		
		for (Iterator<Student>iterator = hm.keySet().iterator(); iterator.hasNext();) {
			Student student = (Student) iterator.next();
			String value = hm.get(student);
			System.out.println(student.getName()+"..."+student.getAge()+"..."+value);
			
		}
	}

}
