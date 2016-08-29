public class InstanceFactory 
{

	private static class InstanceHolder {
	    public static Instance instance = new Instance();
	}
	
	public static Instance getInstance(){
		return InstanceHolder.instance;//这里将导致InstanceHolder类被初始化 
	}
}


public class Someting {
    private Someting(){
	
	}
	private static class LazyHolder {
	    private static final Someting INSTANCE = new Someting();
	}
	public static Someting getInstance(){
		return LazyHolder.INSTANCE;
	}
}

public class Singleton {
    private Singleton(){
	}
	private static class SingletonHolder {
	    public static final Singleton INSTANCE = new Singleton();
	}
	public static Singleton getInstance(){
		return SingletonHolder.INSTANCE;
	}
}

public class Singleton {
    private Singleton(){
	}
	private static class SingletonHolder {
	    static final Singleton INSTANCE = new Singleton();
	}
	public static Singleton getInstance(){
		return SingletonHolder.INSTANCE;
	}
}

