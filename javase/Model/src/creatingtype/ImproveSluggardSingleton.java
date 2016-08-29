
package creatingtype;

//����ʽ:�����棬��֤Ч�ʵ�ǰ���£��̰߳�ȫ
public class ImproveSluggardSingleton {
	private static ImproveSluggardSingleton s = null;
	
	private ImproveSluggardSingleton(){
		System.out.println("������������");
	}
	
	public static  ImproveSluggardSingleton getInstance(){
		if (null == s) {
			synchronized (ImproveSluggardSingleton.class) {
				if(null == s){
					System.out.println("��������");
					s = new ImproveSluggardSingleton();
				}
			}
		}
		return s;
	}
}
