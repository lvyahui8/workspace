package day01;

public class Test01 {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		//×Ö·û´®³£Á¿³Ø 
		String str1 = "abc";
		String str2 = "abc";
		
		String str3 = new String("abc");
		String str4 = new String("abc");
//		str1.hashCode();
		System.out.println(str1 == str2);
		
//		==;
		str3.equals(str4);
		
		System.out.println(str3 == str4);
	}

}
