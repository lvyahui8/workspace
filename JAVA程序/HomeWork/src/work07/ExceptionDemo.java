package work07;

public class ExceptionDemo {

	public static void main(String[] args) {
		try {
			CensusTools.add(-1, 4);
		} catch (MyException e) {
			e.printInfo();
		}
	}

}
