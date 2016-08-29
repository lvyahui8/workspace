// 计算器游戏改进

import javax.swing.*;

class Game03 
{
	//	throws Exception	// 表示该方法可能存在异常，可以不对代码里的异常进行捕获
	public static void main(String[] args) throws Exception	
	{
		//	difficulty 用于记录玩家在运算时使用了多少个0.5秒
		int difficulty;
		difficulty = Integer.parseInt(JOptionPane.showInputDialog("你好吗？\n"
		+"1 = evil genius...\n"
		+"10 = evil,but not a genius"));
		// cont 控制下面的循环是否继续
		boolean cont = false;
		
		//	下面的do...while循环语句为本main方法中的主要实现计算器游戏的代码
		
		do {
			//	将cont重新置为false
		    cont = false;
			//	生成两个随机数，以便后面进行计算
			double num1 = (int)(Math.round(Math.random()*10));
			double num2;
			//	防止生成 0
			do {
			    //初始化 num2
				num2 = (int)(Math.round(Math.random()*10));
			}
			while (0.0 == num2);

			//随机生成运算符
			int sign = (int)(Math.round(Math.random()*3));

			//answer用来存放答案
			double answer = 0.0;
			System.out.println("\n\n*******");
			switch (sign) {
			    case 0:
			        System.out.println(num1+"+"+num2);
					answer = num1 + num2;
			        break;
				case 1:
					System.out.println(num1+"-"+num2);
					answer = num1 - num2;
					break;
				case 2:
					System.out.println(num1+"*"+num2);
					answer = num1 * num2;
					break;
				case 3:
					System.out.println(num1+"/"+num2);
					answer = num1 / num2;
					break;
			    default:
			        break;
			}
			System.out.println("********\n");

			//	使用for循环统计表达式的难度系数

			for (int i = difficulty; i>=0; i--) {
			    System.out.println(i + "...");
				Thread.sleep(500);
			}

			System.out.println("answer:"+answer);
			//	询问用户是否继续游戏
			String again;
			again = JOptionPane.showInputDialog("Play again");
			//	如果选择了yes，将cont设置为true
			if (again.equals("yes")) {
			    cont = true;
			}
		}
		while (cont);
	}
}
