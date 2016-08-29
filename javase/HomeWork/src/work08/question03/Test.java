package work08.question03;

import java.util.Iterator;
import java.util.Map;
import java.util.Random;
import java.util.TreeMap;

public class Test {

	public static void main(String[] args) {
		Map<Integer, Integer> map = new TreeMap<Integer,Integer>();
		Random r = new Random();
		
		//�Ӵ�С����
		for (int i = 10; i >= 1; i--) {
			map.put(i, 0);
		}
		
		//���������
		for (int i = 0; i < 100; i++) {
			int num = r.nextInt(10)+1;
			map.put(num, (map.get(num))+1);
		}
		
		//���ȴ�Ǵ�С����
		for (Iterator<Map.Entry<Integer, Integer>> iterator = map.entrySet().iterator(); iterator.hasNext();) {
			Map.Entry<Integer, Integer> element =  iterator.next();
			System.out.println(element.getKey()+"������"+element.getValue()+"��");
		}

	}

}
