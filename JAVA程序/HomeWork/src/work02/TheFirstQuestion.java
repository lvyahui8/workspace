
/**
 * ���ʵ�֣�
 * 		��1,2,3,4�ĸ����֣�����ɶ��ٸ�������ͬ�����ظ������֡���ӡ�ڿ���̨
 * 
 * ���н����
 * 	 	123 124 132 134 142 143 213 214 231 234 241 243 312 314 321 324 341 342 412 413 421 423 431 432
 */
package work02;

/**
 * @author Agrin
 */
public class TheFirstQuestion {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		
		for(int i = 1; i <= 4; i++){
			for(int j = 1;j <= 4;j++){
				if(j == i){
					continue;
				}
				for(int k = 1;k<=4;k++){
					if(k == j || k == i){
						continue;
					}
					System.out.print(""+i+j+k+" ");
				}
			}
		}
		
	}

}
