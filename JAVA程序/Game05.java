//	��Ϸ������
import javax.swing.*;

public class Game05 
{
	public static void main(String[] args) 
	{
		boolean cont = false;
		do {
		    cont = false;
			//	�����ַ�������洢��Ϸ����
			String names[] = {
					"Define : \"Games\"",
					"The Dungeon Defender",
					"Regional Math - a - thon",
					"National Math - a - tgon"
			};
			//	��ȡ�û�����������������е�����
			int element = Integer.parseInt(JOptionPane.showInputDialog("Which element?"));
			String output = "The name of the game is:\n";
			output += names[element];
			//	���ѡ�����Ϸ
			JOptionPane.showMessageDialog(null,output);
			//	�Ƿ����
			String repeat = JOptionPane.showInputDialog("Again?");
			if (repeat.equals("yes")) {
			    cont = true;
			}
		}
		while (cont);
	}
}
