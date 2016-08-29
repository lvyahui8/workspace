package cn.itcast.other.demo;

import java.util.Random;

public class MathDemo {

	public static void main(String[] args) {
		// TODO 自动生成的方法存根
		/*
		 * Math类：数学工具类，不能被继承，所有方法都是静态的直接操作数据的
		 * 常用方法
		 * cell(double);返回大于参数的最小整数
		 * floor(double);返回小于参数的最大整数
		 * round(double);放回参数的四舍五入值
		 * pow(a,b); a的b次幂。
		 */
		
		double d1 = Math.ceil(12.33);
		double d2 = Math.floor(12.33);
		double d3 = Math.round(12.33);
		
		System.out.println(d1);
		System.out.println(d2);
		System.out.println(d3);
		
		// random方法产生随机数
		
		for(int i = 0; i<10;i++){
			double d = (int)(Math.random()*10)+1;
			System.out.println(d);
		}
		
		//	Random类的对象
		
		Random r = new Random();
		for(int i=0;i<10;i++){
			double d = (int)(r.nextDouble()*10)+1;
			System.out.println(d);
		}

	}

}
