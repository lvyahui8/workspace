import javax.swing.*;

class Game01 
{
	public static void main(String[] args) 
	{
		String input = JOptionPane.showInputDialog("��������");
		// ���Խ��ַ���ת�����������͵�ֵ����ǰ�����ַ�������ת��
		// �������ֵת�������ͱ���
		//int	inputInInForm = Integer.parseInt(input);
		//	~~~~~~~~~~~~~~~~~�������ͱ���
		//double inputInDoubleForm = Double.parseDouble(input);

		if(input.equals("AgrinDJ")){
			System.out.println("��ϲ��ϲ������¶��ˣ�");
		}
		else{
			System.out.println("û�¶�Ŷ������������ɣ�");
		}
	}
}
