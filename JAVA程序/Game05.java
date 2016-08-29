//	游戏档案库
import javax.swing.*;

public class Game05 
{
	public static void main(String[] args) 
	{
		boolean cont = false;
		do {
		    cont = false;
			//	定义字符串数组存储游戏名称
			String names[] = {
					"Define : \"Games\"",
					"The Dungeon Defender",
					"Regional Math - a - thon",
					"National Math - a - tgon"
			};
			//	获取用户输入的名称在数组中的索引
			int element = Integer.parseInt(JOptionPane.showInputDialog("Which element?"));
			String output = "The name of the game is:\n";
			output += names[element];
			//	输出选择的游戏
			JOptionPane.showMessageDialog(null,output);
			//	是否继续
			String repeat = JOptionPane.showInputDialog("Again?");
			if (repeat.equals("yes")) {
			    cont = true;
			}
		}
		while (cont);
	}
}
