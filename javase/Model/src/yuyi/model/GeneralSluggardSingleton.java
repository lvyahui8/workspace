
package yuyi.model;

//懒汉式：延迟加载单例模式
public class GeneralSluggardSingleton {
	private static GeneralSluggardSingleton s = null;
	
	private GeneralSluggardSingleton(){
		System.out.println("单例对象构造中");
	}
	
	public static  GeneralSluggardSingleton getInstance(){
		if (null == s) {
			System.out.println("创建对象");
			s = new GeneralSluggardSingleton();
		}
		return s;
	}
	
}