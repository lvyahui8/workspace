package work03.question02;
/*
 * ��ҵ����
��дһ����ͥ�࣬���������ԣ���ۡ����ۡ��绰���ֱ�ֵ�������������������鿴���۽��(˽��)������绰(����)���ۿ�����(����)
�ڲ�������ʵ�������󲢵�������3�������������ʲô����˵��ԭ��

��JAVA�У�����Ȩ��
	public > protected > default > private
	����protected����ͬ���ڵ�ͬ��public
 */
public class Question_2_Test {

	public static void main(String[] args) {
		Family family = new Family("��ˮ����","���д���","88888888");
//		family.getBankbook();//�������ܵ���
		family.callPhone();//����ͬһ���п��Է��ʣ���C++ ��������
		family.viewExterior();//���Ե���
	}

}
