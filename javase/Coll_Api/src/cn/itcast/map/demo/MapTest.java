package cn.itcast.map.demo;

import java.util.Map;
import java.util.TreeMap;

/*
 * 练习：
 * "khsdkjhkjlkjdijioeuropooiuoirtre";
 * 获取该字符串中，没一个字符串出现的次数
 * 要求打印结果:a(2)b(3).....x(y);
 * 
 */
public class MapTest {

	public static void main(String[] args) {
		// TODO 自动生成的方法存根
		
		String str = "khsdkjhkjlkjdijioeuropooiuoirtre";
		
		Map<Character, Integer> map = getCharCount(str);
		
		System.out.println(map);
	}

	/**
	 * @param str
	 */
//	private static  Map<Character,Integer> getCharCount(String str) {
//		int []count = new int[255];
//		for (int i = 0; i < str.length(); i++) {
//			count[str.charAt(i)]++;
//		}
//		TreeMap<Character,Integer>map = new TreeMap<Character,Integer>();
//		for(int i=0;i<count.length;i++){
//			if (count[i]!=0) {
//				map.put((char)i, count[i]);
//			}
//		}
//		return map;
//	}
	private static  Map<Character,Integer> getCharCount(String str) {
		int []count = new int[255];
		TreeMap<Character,Integer>map = new TreeMap<Character,Integer>();
		for (int i = 0; i < str.length(); i++) {
			map.put(str.charAt(i),++count[str.charAt(i)]);//	个人感觉在字符串很长，但字符重复严重的情况下效率可能更低
		}
		return map;
	}

}

//{d=2, e=2, h=2, i=4, j=4, k=4, l=1, o=5, p=1, r=3, s=1, t=1, u=2}
//{d=2, e=2, h=2, i=4, j=4, k=4, l=1, o=5, p=1, r=3, s=1, t=1, u=2}
