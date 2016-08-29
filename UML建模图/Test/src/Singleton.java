
public class Singleton {
	private static final Singleton s = new Singleton();

	private Singleton() {
	}

	public static Singleton getInstance() {
		return s;
	}

}
