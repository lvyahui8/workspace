/**
 * 有500个小朋友拉成一个呼啦圈，从其中一个小朋友开始一次编号1-500，从1号小朋友
 * 开始循环1-3报数，数到3的小朋友就退出。打印一次退出小朋友的编号（数组实现）。
 */
package work02;

/**
 * @author Agrin
 */
public class TheSecondQuestion {

	/**
	 * 
	 */
	private static final int MAN_COUNTS = 500;//人数
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		//false 表示未出局      true表示已出局    数组角标就是编号
		boolean [] isOut = new boolean[TheSecondQuestion.MAN_COUNTS+1];
		
		outPeople(isOut,TheSecondQuestion.MAN_COUNTS -1 );
		
		alivePeople(isOut);
	}
	/**
	 * 找出未出局的输出
	 * @param isOut
	 */
	private static void alivePeople(boolean[] isOut) {
		for (int i = 1; i < isOut.length; i++) {
			boolean b = isOut[i];
			if(!b){
				System.out.println(i+"还活着");
			}
		}
	}
	/**
	 * T人出局，并输出
	 * @param isOut
	 * @param count
	 */
	private static void outPeople(boolean[] isOut, int count) {
		int k = -1;
		while(count>2){
			for (int i = 1; i < isOut.length; i++) {
				if(!isOut[i]){//如果未出局
					k = (k+1)%3;//报号
					if(k == 2){
						count--;
						isOut[i] = true;
						System.out.print(i+" ");
					}
				}
			}
			System.out.println("");
		}
	}

}

