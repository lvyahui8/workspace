
package creatingtype;

//懒汉式:升级版，保证效率的前提下，线程安全
public class ImproveSluggardSingleton {
	private static ImproveSluggardSingleton s = null;
	
	private ImproveSluggardSingleton(){
		System.out.println("单例对象构造中");
	}
	
	public static  ImproveSluggardSingleton getInstance(){
		if (null == s) {
			synchronized (ImproveSluggardSingleton.class) {
				if(null == s){
					System.out.println("创建对象");
					s = new ImproveSluggardSingleton();
				}
			}
		}
		return s;
	}
}
