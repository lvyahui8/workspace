import javax.swing.*;

class Game07 
{
	public static void main(String[] args) 
	{
		//	�ñ������ڼ�¼�û��µ�����
		int guess = -1;
		//	���ڼ�¼�û��µĴ���
		int count = 0;
		//	��0-100֮����������
		int num = (int)(Math.random()*100);
		//	ѭ��������
		do {
		    guess = Integer.parseInt(JOptionPane.showInputDialog("Guess a number between 0 amd 100��"));

			if (guess > num) {
			    JOptionPane.showMessageDialog(null,"Too high");
			}
			else if(guess < num){
			    JOptionPane.showMessageDialog(null,"Too low");
			}
			count ++;
		}
		while (num != guess);

		JOptionPane.showMessageDialog(null,"You guessed the number - "+num+" - in "+count+" guess(es)!!!");
	}
}
