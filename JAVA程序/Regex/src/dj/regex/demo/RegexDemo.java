package dj.regex.demo;
/*
 * ������ʽ���ڲ����ַ�������
 * ͨ��һЩ�ض��ķ��������ֵ�
 * 
 */
public class RegexDemo {

	public static void main(String[] args) {
		// TODO �Զ����ɵķ������
		String qq = "123456789012";
//		checkQQ(qq);
		
		String regex = "[1-9][0-9]{4,14}";//������ʽ
		
		if(qq.matches(regex)){
			System.out.println("�Ϸ�");
		}
		else{
			System.out.println("���Ϸ�");
		}
	}

	/*
	 * ���󣺶���һ�����ܶ�QQ�Ž���У��
	 * ���󣺳���5-15��ֻ�������֣�0���ܿ�ͷ
	 * 
	 */
	
	public static void checkQQ(String qq){
		int len = qq.length();
		
		if(len >= 5 && len <=15){
			if(!qq.startsWith("0")){
				try {
					long l  = Long.parseLong(qq);
					System.out.println("QQ�źϷ�");
				} catch (NumberFormatException e) {
					// TODO: handle exception
					System.out.println("���зǷ��ַ�");
				}
			}
			else{
				System.out.println("������0��ͷ");
			}
		}else{
			System.out.println("���Ȳ���");
		}
	}
}
