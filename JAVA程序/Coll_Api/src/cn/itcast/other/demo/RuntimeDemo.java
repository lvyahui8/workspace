package cn.itcast.other.demo;

import java.io.IOException;

public class RuntimeDemo {

	public static void main(String[] args) {
		// TODO �Զ����ɵķ������
		/*
		 * Runtime��û�ж���Ĺ��췽����˵�����಻�������û��Լ���������
		 * ʹ���˵������ģʽ
		 * ��˵�����϶���һ����̬���������Ψһʵ��
		 */
		
		Runtime r = Runtime.getRuntime();
		Process p = null;
		try {
			p  = r.exec("notepad");
			Thread.sleep(5000);
		} catch (IOException | InterruptedException e) {
			// TODO �Զ����ɵ� catch ��
			e.printStackTrace();
		}finally{
			p.destroy();
		}
	
	}

}
