
public class newFunDemo {

	public static void main(String[] args) {
		// TODO �Զ����ɵķ������
		method();
		method(1,2,3,4,5,6,7,8);
	}
	public static int method(/*������Ŷ����������*/int... arr/*���������в���*/){//...����ܶ࣬��ʵ�������顣�Զ���Ԫ�ط�װ�����飬����д���о����ԣ��������治���в���
		System.out.println(arr);
		for (int i = 0; i < arr.length; i++) {
			System.out.print(arr[i]+" ");
		}
		return 0;
	}
	
//	public static int method(int[] arr){
//		System.out.println(arr);
//		for (int i = 0; i < arr.length; i++) {
//			System.out.print(arr[i]+" ");
//		}
//		return 0;
//	}
	
}
