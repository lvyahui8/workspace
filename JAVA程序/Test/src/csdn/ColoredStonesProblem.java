package csdn;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/*
 * 有一行彩色的棋子，每个棋子的颜色是k种颜色之一。你不能改变棋子的顺序，但是可以移走一些棋子。
 * 问至少移走多少个石子，才能使得两个同色的石子之间没有其他颜色的棋子？ 输入格式： 多组数据，每
 * 组数据两行，第一行是两个整数n和k, 1<=n<=100, 1<=k<=5 下一行是n个在[1..k]范围内的正整
 * 数，代表每个棋子的颜色。 输出格式： 每组测试数据输出一行包含一个整数，表示至少移走的石子数。
 *  注：可以移走第2个第7个棋子。
 */
public class ColoredStonesProblem {

	public static void main(String[] args) {
//		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
//		try {
//			while(true){
//				String str = br.readLine();
//				System.out.println(str);
//			}
//		} catch (IOException e) {
//			//
//			e.printStackTrace();
//		}
		int pebble_count = 10;
		int [] pebbles = new int[pebble_count];
		int color_count = 3;
		int [] colors = new int[color_count];
		
		int[] pebbles_color = {2,1,2,2,1,1,3,1,3,3};
		
		for(int i = 0;i<pebbles.length;i++){
			pebbles[i] = colors[i];
		}
		for(int i = 0;i<pebbles.length-1;i++){
			if(pebbles[i] != pebbles[i+1]){
				
			}
		}
		
		
	}

}
