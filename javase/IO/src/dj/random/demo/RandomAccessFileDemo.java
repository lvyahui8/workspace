package dj.random.demo;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.RandomAccessFile;

public class RandomAccessFileDemo {

	public static void main(String[] args) throws IOException {
		// TODO �Զ����ɵķ������
		/*
		 * RandomAccessFile
		 * �������п��Կ�����������IO��ϵ
		 * �ĸ��ؼ���    ���   �ļ�   ��ȡ   д��
		 * 1������Ķ�����ܶ�Ҳ��д
		 * 2���ö����ڲ�ά��һ��byte���飬��ͨ��ָ����Բ��������е�����
		 * 3������ͨ��getFilePointer������ȡָ���λ�ã�������ͨ��seek��������ָ��
		 * 
		 * 4��������ڲ���������������������˷�װ
		 * 5���ö����Դ���ֻ�����ļ�
		 */
		
//		writeFile();
//		readFile();
		randomWrite();
	}
	public static void randomWrite() throws IOException{
		// TODO �Զ����ɵķ������
		RandomAccessFile raf = new RandomAccessFile("raf.txt","rw");
		raf.seek(3*8);
		raf.write("����".getBytes());
		raf.writeInt(23);
		raf.close();
	}
	public static void readFile() throws IOException {
		// TODO �Զ����ɵķ������
		RandomAccessFile raf = new RandomAccessFile("raf.txt", "rw");
		
		byte [] buf = new byte[4];
		raf.read(buf);
		int age = raf.readInt();
		
		System.out.println(new String(buf) + age);
		raf.close();

	}
	/*
	 * ʹ��RandomAccessFile����д��һЩ��Ա��Ϣ
	 */
	public static void writeFile() throws IOException{
		RandomAccessFile raf = new RandomAccessFile("raf.txt", "rw");
		
		raf.write("����".getBytes());
//		raf.write(97);
		raf.writeInt(97);
		raf.close();
	}
}
