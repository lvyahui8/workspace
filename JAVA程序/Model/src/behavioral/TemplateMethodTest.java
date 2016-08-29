/*
 * ģ�巽��ģʽ
 * 
 * ����һ��ģ�����㷨�Ŀ�ܣ�����һЩ�����ӳٵ������У�ʹ������Բ��ı��㷨�Ľṹ�����ض���
 * ���㷨�е�ĳЩ�ض�����
 * 
 * ģ�巽���Ľṹ��
 * ģ�巽��ģʽ��һ���������һ������һ�飩ʵ����ͨ���̳нṹ��ɣ��������еķ�����Ϊ���֣�
 * 		���󷽷���������ֻ������������ʵ�֣����Ƕ���ù淶��Ȼ������������ȥʵ�֡�
 * 		ģ�巽�����ɳ���������������ʵ�֡�һ����˵��ģ�巽�����ó��󷽷��������Ҫ���߼�����
 * 				�����ң�ģ�巽�����ᶨ��Ϊfinal���ͣ�ָ����������
 * 		���ӷ������ɳ���������������ʵ�֣������������ȥ��չ���������ͨ����չ���ӷ�����Ӱ��
 * 				ģ�巽�����߼���
 * 
 * 
 */
package behavioral;
//����Ĳ������Լ�ʵ��
abstract class AbstractSort{
	/**
	 * ������Array��С��������
	 * @param array
	 */
	protected abstract void sort(int [] array);
	
	public void showSortResult(int [] array){
		this.sort(array);
		System.out.println("������:");
		for (int i = 0; i < array.length; i++) {
			System.out.printf("%3s",array[i]);
		}
	}
}

//����Ĳ��ֿ����Ƚ�����������
class ConcreteSort extends AbstractSort{

	@Override
	protected void sort(int[] array) {
		for (int i = 0; i < array.length-1; i++) {
			int indexMin = i;
			for(int j = i+1;j<array.length;j++){
				if(array[indexMin] > array[j]){
					indexMin = j;
				}
			}
			if(i!=indexMin){
				swap(array,i,indexMin);
			}
		}
	}

	private void swap(int[] array, int m, int n) {
		int temp = array[m];
		array[m] = array[n];
		array[n] = temp;
	}
	
}
public class TemplateMethodTest {

	public static void main(String[] args) {
		int [] array = {10,2,3,4,7,5,9,8,1};
		AbstractSort as = new ConcreteSort();
		as.showSortResult(array);
	}

}
