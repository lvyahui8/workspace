package cn.itcast.wrapper.demo;

public class WrapperDemo {

	public static void main(String[] args) {
		// TODO �Զ����ɵķ������
		/*
		 * �����������ͷ�װ
		 * Ϊ�˲���������������
		 * byte		Byte
		 * short	Short
		 * int		Integer
		 * long		Long
		 * float	Float
		 * double	Double
		 * char		Character
		 * boolean	Boolean
		 * 
		 * �����������ͺ��ַ���֮���ת��
		 * 
		 * ��������------>�ַ���
		 * 		1��������������+string
		 * 		2����String���еľ�̬���� valueOf(������������);
		 * 
		 * �ַ���--------->��������
		 * 		1��ʹ�ð�װ��ľ�̬������xxx  parseXxx("xxx�����ַ���");
		 * 			int parseInt("int string");
		 * 			long parseLong("long string");
		 * 			boolean parseBoolean("booleanString");
		 * 			ֻ��    Characterû��parse����
		 * 
		 * 		2������ַ�����Integer�����˷�װ
		 * 			����ʹ����һ���Ǿ�̬����
		 * 			��һ��Integer����ת���ɻ�����������
		 *  
		 * 
		 */
		
//		int num ;
		System.out.println(Integer.MAX_VALUE+"...."+Integer.MIN_VALUE);
//		num = 10;
		System.out.println(Integer.toBinaryString(-6));
		int var = Integer.parseInt("123"+1);
		System.out.println(var);
//		var = Integer.parseInt("123abc");	// �÷�����������ʱ�쳣�������Բ��ף�������ϣ��������ע��һ�£����Ի�������
//		System.out.println(var);
		
		Integer	i	=	new Integer("123");
		System.out.println(i.intValue());
		
		/*
		 * �����߱���ͬ�Ľ�������
		 * 
		 * ʮ����----->��������
		 * 
		 * ��������------>ʮ����
		 * 
		 */
		
		//	ʮ����---->��������
		System.out.println(Integer.toBinaryString(60));
		System.out.println(Integer.toOctalString(60));
		System.out.println(Integer.toHexString(60));
		System.out.println(Integer.toString(60, 16));
		//	��������------>ʮ����
		System.out.println(Integer.parseInt("3c", 16));
		
		Integer a = new Integer(3);
		Integer b = new Integer("3");
		System.out.println(a == b);
		System.out.println(a.equals(b));
		System.out.println(a.compareTo(b+1));
		
	}
}
