/**
 * ��500��С��������һ������Ȧ��������һ��С���ѿ�ʼһ�α��1-500����1��С����
 * ��ʼѭ��1-3����������3��С���Ѿ��˳�����ӡһ���˳�С���ѵı�ţ�����ʵ�֣���
 */
package work02;

/**
 * @author Agrin
 */
public class TheSecondQuestion {

	/**
	 * 
	 */
	private static final int MAN_COUNTS = 500;//����
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		//false ��ʾδ����      true��ʾ�ѳ���    ����Ǳ���Ǳ��
		boolean [] isOut = new boolean[TheSecondQuestion.MAN_COUNTS+1];
		
		outPeople(isOut,TheSecondQuestion.MAN_COUNTS -1 );
		
		alivePeople(isOut);
	}
	/**
	 * �ҳ�δ���ֵ����
	 * @param isOut
	 */
	private static void alivePeople(boolean[] isOut) {
		for (int i = 1; i < isOut.length; i++) {
			boolean b = isOut[i];
			if(!b){
				System.out.println(i+"������");
			}
		}
	}
	/**
	 * T�˳��֣������
	 * @param isOut
	 * @param count
	 */
	private static void outPeople(boolean[] isOut, int count) {
		int k = -1;
		while(count>2){
			for (int i = 1; i < isOut.length; i++) {
				if(!isOut[i]){//���δ����
					k = (k+1)%3;//����
					if(k == 2){
						count--;
						isOut[i] = true;
						System.out.print(i+" ");
					}
				}
			}
			System.out.println("");
		}
	}

}

