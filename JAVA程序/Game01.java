import javax.swing.*;

class Game01 
{
	public static void main(String[] args) 
	{
		String input = JOptionPane.showInputDialog("输入密码");
		// 可以将字符串转换成其他类型的值，但前提是字符串可以转换
		// 将输入的值转换成整型变量
		//int	inputInInForm = Integer.parseInt(input);
		//	~~~~~~~~~~~~~~~~~浮点类型变量
		//double inputInDoubleForm = Double.parseDouble(input);

		if(input.equals("AgrinDJ")){
			System.out.println("恭喜恭喜哈，你猜对了！");
		}
		else{
			System.out.println("没猜对哦，想清楚再来吧！");
		}
	}
}
