// 计算器游戏
import javax.swing.*;

class Game02 
{
	public static void main(String[] args) 
	{
		//	生成两个随机数，以便进行运算
		//	Math.round()是将一个数四舍五入
		//	Math.random()是产生一个介于[0,1]的随机数
		int	num1 = (int)(Math.round(Math.random()*10));
		int num2 = (int)(Math.round(Math.random()*10));
		//	生成一个随机数，标识不同的运算符
		System.out.println("Hello World!");
		int sign = (int)(Math.round(Math.random()*3));
		//	定义一个变量存放运算结果，答案
		int answer;
		System.out.println("\n\n******");
		if (0 == sign) {
		    System.out.println(num1+"+"+num2);
			answer = num1 + num2;
		}
		else if (1 == sign) {
			System.out.println(num1+"-"+num2);
			answer = num1 - num2;
		}
		else if (2 == sign) {
		    System.out.println(num1+"*"+num2);
			answer = num1 * num2;
		}
		else if(3 == sign){
		    System.out.println(num1+"/"+num2);
			answer = num1 / num2;
		}
		else {
		    System.out.println(num1 +"%"+num2);
			answer = num1 % num2;
		}
		/*
		switch () {
		    case :
		        
		        break;
		    default:
		        
		        break;
		}
		*/
		System.out.println("********\n");
		//倒计时3秒
		for(int i=3;i>0;i--){
			System.out.println(i+"......");
			try{
				Thread.sleep(1000);   //必须进行异常处理，否则编译无法通过
			}catch (Exception e){
				 e.printStackTrace();   //print exception info
			}
		}
		
		System.out.println("Answer:"+answer);
	}
}
