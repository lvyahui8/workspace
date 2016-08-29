import javax.swing.*;

class Game07 
{
	public static void main(String[] args) 
	{
		//	该变量用于记录用户猜的数字
		int guess = -1;
		//	用于记录用户猜的次数
		int count = 0;
		//	在0-100之间产生随机数
		int num = (int)(Math.random()*100);
		//	循环猜数字
		do {
		    guess = Integer.parseInt(JOptionPane.showInputDialog("Guess a number between 0 amd 100！"));

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
