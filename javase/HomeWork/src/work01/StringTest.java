/*
 * String �ص㲻�ɱ䣨���Բ��ÿ��Ƕ��߳��Ƿ�ȫ�����⣩����Ȼ���Խ�����ɾ�ģ���ʵ���ǽ�����ָ����һ������
 * 		String ��������ֶ��巽ʽ
 * 		1��String str = "XXXXXXX";
 * 				��һ�����ַ����������������ݵ��ַ������������ֱ�ӽ�����strָ������û�������ڳ�����������
 * 		2��String str = new String("XXXXXXX");
 * 				��һ�ַ�ʽ���ڶ��ϲ����ַ������������Լ���װ���Լ�ά���������ַ�����������
 * 
 * 
 * StringBuilder ��    StringBuffer
 * 		��ͬ�㣺�ڲ�ά����һ���ַ����飬���ȿɱ�
 * 		��ͬ�㣺ǰ���̲߳���ȫ��Ч���Ըߣ��ʺϵ��̡߳������̰߳�ȫ��ʹ����ͬ������Ч���Եͣ��ʺ϶��߳�
 * 
 * 
 * ����Ĳ��Գ�����ʾ�����ߵ�����
 * 
 * ���Գ���ʹ�����������̶߳�ͬһ������ִ�в������
 * ���н����ʾ��
 * ��β����ǰ�߳��ֳ����ֶ���ʵ���ַ������Ȳ�ͬ�����⣬������û��
 */
package work01;

/**
 * StringTest����StringBulder �� StringBuffer ������
 * @author Agrin
 *
 */
public class StringTest {
	
//	StringBuilder sb = new StringBuilder();
	StringBuffer sb = new StringBuffer();
	private static long WAIT_TIME = 20;//����  һ��Ϊ������߳��л���ʱ�� 

	class Inserter implements Runnable{
		String str = null;
		public Inserter(String str){
			this.str = str;
		}
		@Override
		public void run() {
			while(true){
				try {
					Thread.sleep(WAIT_TIME);///   1394360789497 -  1394360789373  == 124 ms
					sb.insert(0, str);
					System.out.println(sb);
				} catch (InterruptedException e) {//Interrupted
					// TODO �Զ����ɵ� catch ��
					e.printStackTrace();
				}
			}
		}
	}
	

	public void inserter(String str){
		new Thread(new Inserter(str)).start();
	}

	public static void main(String[] args) {
		// TODO �Զ����ɵķ������
		StringTest st = new StringTest();
		st.inserter("-");
		st.inserter("-");
	}

}
