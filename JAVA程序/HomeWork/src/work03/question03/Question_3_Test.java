package work03.question03;
/*
 * ��ҵ����
	����һ�����г��ࣨBicycle���������ǣ���Ʒ�ơ���ɫ�������ǣ�������ͣ����
	����һ���綯���г��ࣨMoto���̳����г��࣬�����Լ��ķ�������ʻ��������
	Moto��ʵ�������󣬷ֱ������������ʻ��ͣ����������ģ���ﳵ���̣���

 */
public class Question_3_Test {

	public static void main(String[] args) {
		Moto moto = new Moto(1234,"��ɫ");
		moto.start();
		moto.travel();
		moto.stop();
	}

}
