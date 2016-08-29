package dj.objectstream.demo;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

@SuppressWarnings("unused")
public class ObjectStreamDemo {

	public static void main(String[] args) throws IOException, ClassNotFoundException {
		// TODO �Զ����ɵķ������
//		writeDmeo();
		readDemo();
	}

	public static void readDemo() throws IOException, ClassNotFoundException {
		// TODO �Զ����ɵķ������
		ObjectInputStream ois = new ObjectInputStream(new FileInputStream("obj.txt"));
		Person p = (Person)ois.readObject();
		
		System.out.println(p.getName()+".."+p.getAge());
		
		ois.close();
	}

	public static void writeDmeo() throws  IOException {
		// TODO �Զ����ɵķ������
		
		
		ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream("obj.txt"));
		Person p = new Person("niha","12");
		oos.writeObject(p);
		
		oos.close();
	}

}
