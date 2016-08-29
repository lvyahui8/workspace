//	饿汉式：单例模式
class Single {
    private static final Single s = new Single();
	private Single(){}
	public static Single getInstance(){
		return s;
	}
}
//	懒汉式：延迟加载单例模式
class Single {
    private static Single s = null;

	private Single(){}

	public static  Single getInstance(){
		if (null == s) {			//	加一次判断是为了提高效率问题
		    synchronized (Single.class){	//	加锁是为了解决线程安全问题
				if (null == s) {			
					s = new Single();
				}
			}
		}
		return s;
	}
}

class SingleDemo 
{
	public static void main(String[] args) 
	{
		System.out.println("Hello World!");
	}
}
