package cn.itcast.other.demo;

import java.io.IOException;

public class RuntimeDemo {

	public static void main(String[] args) {
		// TODO 自动生成的方法存根
		/*
		 * Runtime：没有对外的构造方法，说明该类不可以由用户自己创建对象
		 * 使用了单列设计模式
		 * 这说明它肯定有一个静态方法，获得唯一实例
		 */
		
		Runtime r = Runtime.getRuntime();
		Process p = null;
		try {
			p  = r.exec("notepad");
			Thread.sleep(5000);
		} catch (Exception e) {
			// TODO 自动生成的 catch 块
			e.printStackTrace();
		}finally{
			p.destroy();
		}
	
	}

}
