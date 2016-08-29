public class OprDemo 
{
	public static void main(String[] args) 
	{
		System.out.println("Hello World!");
		int		a=3,b=4;
		/*
		int		temp;
		System.out.println("a="+a+",b="+b);
		temp = a;
		a = b;
		b = temp;
		System.out.println("a="+a+",b="+b);
		a = a ^ b;
		b = a ^ b;
		a = a ^ b;*/
		System.out.println("a="+a+",b="+b);
		a ^= b ^= a ^= b;
		//a = a ^ (b = b ^ (a = a ^ b));
		System.out.println("a="+a+",b="+b);
	}
	if () {
	    
	}
}
