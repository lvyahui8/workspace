//	������Ϸ
import javax.swing.*;
import java.io.*;

class Game04 
{
	public static void main(String[] args) throws Exception
	{
		//	input������¼�����ѡ��ֵ
		String  pasdPath = "password.ini";
		String input;
		input = JOptionPane.showInputDialog("1 to set password,\n2 to unlock the message");
		//	���������ļ�
		File file = new File(pasdPath);
		//	��������
		if (input.equals("1")) {
		    //	��������
			//	��ȡ�����������
			String p = JOptionPane.showInputDialog("Enter the password to set");
			//	����һ���ļ������
			FileOutputStream outStream = new FileOutputStream(file);
			//	����ʽ�������ӡ��һ���ı�������
			PrintWriter out = new PrintWriter(outStream);
			//	���������õ�����д��pasdPath
			out.println(p);
			//	ˢ�������ر���
			out.flush();
			out.close();
			outStream.close();
		}
		else {
		    //	�ƽ�����
			//	������Ҫ��ȡ��ȷ������
			FileReader fr = new FileReader(file);
			BufferedReader buffer = new BufferedReader(fr);
			String password = buffer.readLine();
			//	��ȡ�û����������
			String userPass;
			userPass = JOptionPane.showInputDialog("Enter your guess..");
			//	�ж���ҵ���������Ƿ���ȷ
			if (password.equals(userPass)) {
			    JOptionPane.showMessageDialog(null,"��������̫�в���");
			}
			else {
			    JOptionPane.showMessageDialog(null,"檣�û�¶�Ŷ������");
			}
		}
	}
}
