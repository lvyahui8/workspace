//	解密游戏
import javax.swing.*;
import java.io.*;

class Game04 
{
	public static void main(String[] args) throws Exception
	{
		//	input用来记录输入的选项值
		String  pasdPath = "password.ini";
		String input;
		input = JOptionPane.showInputDialog("1 to set password,\n2 to unlock the message");
		//	创建密码文件
		File file = new File(pasdPath);
		//	设置密码
		if (input.equals("1")) {
		    //	设置密码
			//	获取输入的新密码
			String p = JOptionPane.showInputDialog("Enter the password to set");
			//	创建一个文件输出流
			FileOutputStream outStream = new FileOutputStream(file);
			//	将格式化对象打印到一个文本输入流
			PrintWriter out = new PrintWriter(outStream);
			//	将重新设置的密码写入pasdPath
			out.println(p);
			//	刷新流，关闭流
			out.flush();
			out.close();
			outStream.close();
		}
		else {
		    //	破解密码
			//	首先需要获取正确的密码
			FileReader fr = new FileReader(file);
			BufferedReader buffer = new BufferedReader(fr);
			String password = buffer.readLine();
			//	获取用户输入的密码
			String userPass;
			userPass = JOptionPane.showInputDialog("Enter your guess..");
			//	判断玩家的输的密码是否正确
			if (password.equals(userPass)) {
			    JOptionPane.showMessageDialog(null,"哈哈，你太有才了");
			}
			else {
			    JOptionPane.showMessageDialog(null,"妾，没猜对哦，加油");
			}
		}
	}
}
