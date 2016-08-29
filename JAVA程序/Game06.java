//	游戏档案库改进
import javax.swing.*;	//	需要使用 JOptionPane
import java.util.*;		//	需要使用 ArrayList
public class Game06 
{
	public static void main(String[] args) 
	{
		//	定义动态增加的游戏名称数组
		ArrayList games = new ArrayList();
		boolean cont = false;
		do {
		    cont = false;
			//	获取用户操作的选项值
			int	choice = Integer.parseInt(JOptionPane.showInputDialog("Enter\n1 to add new game\n2 to access games"));
			if (1 == choice) {
				//	获取新增游戏的名称
			    String name;
				name = JOptionPane.showInputDialog("Game name?");
				games.add(name);
			}
			else {
				//	获取用户输入的名称在数组中的索引
				int element = Integer.parseInt(JOptionPane.showInputDialog("Which element?"));
				String output = "The name of the game is:\n";
				output += ((String)games.get(element));
				//	输出选择的游戏
				JOptionPane.showMessageDialog(null,output);
			}
			
			//	是否继续
			String repeat = JOptionPane.showInputDialog("Again?");
			if (repeat.equals("yes")) {
			    cont = true;
			}
		}
		while (cont);
	}
}