//	��Ϸ������Ľ�
import javax.swing.*;	//	��Ҫʹ�� JOptionPane
import java.util.*;		//	��Ҫʹ�� ArrayList
public class Game06 
{
	public static void main(String[] args) 
	{
		//	���嶯̬���ӵ���Ϸ��������
		ArrayList games = new ArrayList();
		boolean cont = false;
		do {
		    cont = false;
			//	��ȡ�û�������ѡ��ֵ
			int	choice = Integer.parseInt(JOptionPane.showInputDialog("Enter\n1 to add new game\n2 to access games"));
			if (1 == choice) {
				//	��ȡ������Ϸ������
			    String name;
				name = JOptionPane.showInputDialog("Game name?");
				games.add(name);
			}
			else {
				//	��ȡ�û�����������������е�����
				int element = Integer.parseInt(JOptionPane.showInputDialog("Which element?"));
				String output = "The name of the game is:\n";
				output += ((String)games.get(element));
				//	���ѡ�����Ϸ
				JOptionPane.showMessageDialog(null,output);
			}
			
			//	�Ƿ����
			String repeat = JOptionPane.showInputDialog("Again?");
			if (repeat.equals("yes")) {
			    cont = true;
			}
		}
		while (cont);
	}
}