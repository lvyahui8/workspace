/*
8、一个人拿100元买100只鸡，已知公鸡每只2元，
母鸡每只1.5元，小鸡每只0.5元，并且要求公鸡、
母鸡、小鸡都至少要有一只，问有多少种买法？
*/
public class ForTest01{

	public static void main(String[] args) {
		for (int i = 1; i <= 100; i++) {
			for (int j = 1; j <= 100 - i; j++) {
				for (int k = 1; k <= 100 - i - j; k++) {
					if((i * 2 + 1.5 * j + 0.5 * k) == 100  && (i + j + k) == 100){
						System.out.println(i +" "+ j +" "+ k);
					}
				}
			}
		}
	}
}