public class StringDemo{
	public static void main(String[] args) {
		String str1 = "1"+"";
		String str2 = "1"+"";
		System.out.println(str1 == str2);
		String str3 = get("1","");
		String str4 = get("1","");
		System.out.println(str4 == str3);
	}
	public static String get(String str1,String str2){
		return str1 + str2;
	}
}