package csdn;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/*
 * ��һ�в�ɫ�����ӣ�ÿ�����ӵ���ɫ��k����ɫ֮һ���㲻�ܸı����ӵ�˳�򣬵��ǿ�������һЩ���ӡ�
 * ���������߶��ٸ�ʯ�ӣ�����ʹ������ͬɫ��ʯ��֮��û��������ɫ�����ӣ� �����ʽ�� �������ݣ�ÿ
 * ���������У���һ������������n��k, 1<=n<=100, 1<=k<=5 ��һ����n����[1..k]��Χ�ڵ�����
 * ��������ÿ�����ӵ���ɫ�� �����ʽ�� ÿ������������һ�а���һ����������ʾ�������ߵ�ʯ������
 *  ע���������ߵ�2����7�����ӡ�
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
