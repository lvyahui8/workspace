package cn.itcast.other.demo;

import java.util.Random;

public class MathDemo {

	public static void main(String[] args) {
		// TODO �Զ����ɵķ������
		/*
		 * Math�ࣺ��ѧ�����࣬���ܱ��̳У����з������Ǿ�̬��ֱ�Ӳ������ݵ�
		 * ���÷���
		 * cell(double);���ش��ڲ�������С����
		 * floor(double);����С�ڲ������������
		 * round(double);�Żز�������������ֵ
		 * pow(a,b); a��b���ݡ�
		 */
		
		double d1 = Math.ceil(12.33);
		double d2 = Math.floor(12.33);
		double d3 = Math.round(12.33);
		
		System.out.println(d1);
		System.out.println(d2);
		System.out.println(d3);
		
		// random�������������
		
		for(int i = 0; i<10;i++){
			double d = (int)(Math.random()*10)+1;
			System.out.println(d);
		}
		
		//	Random��Ķ���
		
		Random r = new Random();
		for(int i=0;i<10;i++){
			double d = (int)(r.nextDouble()*10)+1;
			System.out.println(d);
		}

	}

}
