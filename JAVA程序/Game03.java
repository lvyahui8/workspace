// ��������Ϸ�Ľ�

import javax.swing.*;

class Game03 
{
	//	throws Exception	// ��ʾ�÷������ܴ����쳣�����Բ��Դ�������쳣���в���
	public static void main(String[] args) throws Exception	
	{
		//	difficulty ���ڼ�¼���������ʱʹ���˶��ٸ�0.5��
		int difficulty;
		difficulty = Integer.parseInt(JOptionPane.showInputDialog("�����\n"
		+"1 = evil genius...\n"
		+"10 = evil,but not a genius"));
		// cont ���������ѭ���Ƿ����
		boolean cont = false;
		
		//	�����do...whileѭ�����Ϊ��main�����е���Ҫʵ�ּ�������Ϸ�Ĵ���
		
		do {
			//	��cont������Ϊfalse
		    cont = false;
			//	����������������Ա������м���
			double num1 = (int)(Math.round(Math.random()*10));
			double num2;
			//	��ֹ���� 0
			do {
			    //��ʼ�� num2
				num2 = (int)(Math.round(Math.random()*10));
			}
			while (0.0 == num2);

			//������������
			int sign = (int)(Math.round(Math.random()*3));

			//answer������Ŵ�
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

			//	ʹ��forѭ��ͳ�Ʊ��ʽ���Ѷ�ϵ��

			for (int i = difficulty; i>=0; i--) {
			    System.out.println(i + "...");
				Thread.sleep(500);
			}

			System.out.println("answer:"+answer);
			//	ѯ���û��Ƿ������Ϸ
			String again;
			again = JOptionPane.showInputDialog("Play again");
			//	���ѡ����yes����cont����Ϊtrue
			if (again.equals("yes")) {
			    cont = true;
			}
		}
		while (cont);
	}
}
