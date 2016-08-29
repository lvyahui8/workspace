
package yuyi.model;

//����ʽ���ӳټ��ص���ģʽ
public class GeneralSluggardSingleton {
	private static GeneralSluggardSingleton s = null;
	
	private GeneralSluggardSingleton(){
		System.out.println("������������");
	}
	
	public static  GeneralSluggardSingleton getInstance(){
		if (null == s) {
			System.out.println("��������");
			s = new GeneralSluggardSingleton();
		}
		return s;
	}
	
}