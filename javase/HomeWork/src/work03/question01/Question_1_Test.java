package work03.question01;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

/*

��ҵһ��
����һ����ʾѧ����Ϣ����Student��Ҫ�����£�
��1����Student�ĳ�Ա������
sNO����ʾѧ�ţ�sName��ʾ������sSex��ʾ�Ա�sAge��ʾ���䣻sJava����ʾJava�γ̳ɼ���
��2����Student�������Ĺ��췽���� 
�ڹ��췽����ͨ���β���ɶԳ�Ա�����ĸ�ֵ������
��3����Student�ķ�����Ա��
getNo���������ѧ�ţ� 
getName��������������� 
getSex����������Ա�
getAge����������䣻
getJava���������Java �γ̳ɼ�
������Student�Ķ��壬�����������Ķ������ÿ��ѧ������Ϣ�����㲢��������ѧ��Java��
�Գɼ���ƽ��ֵ���Լ����㲢�������Java���Գɼ������ֵ����Сֵ��

*/
public class Question_1_Test {

	public static void main(String[] args) {
		List<Student> list = new ArrayList<Student>();
		
		Random r = new Random();
		for (int i = 0; i < 5; i++) {
			list.add(new Student("00" + i, 
					"" + (char) (i + 92 + r.nextInt(26)) + (char) (i + 92 + r.nextInt(26)), 
					r.nextInt(2) == 1 ? "Ů" : "��", 
					"" + (r.nextInt(5) + 17), 
					"" + (r.nextInt(50) + 50)));
		}
		Integer [] arrJava = new Integer[list.size()];
		
		for (int i=0;i<list.size();i++) {
			Student student = list.get(i);
			System.out.println(student);
			arrJava[i] = Integer.parseInt(student.getsJava());
		}
		
		double averageValue  =  MyArrayTools.getAverageValue(arrJava);
		
		MyArrayTools.seleteSort(arrJava,new Comparator() {
			@Override
			public boolean compare(Object obj1, Object obj2) {
				int i1 = (Integer)obj1;
				int i2 = (Integer)obj2;
				
				return i1 > i2;
			}
		});
		System.out.println("ƽ��ֵ��"+averageValue);
		System.out.println("���ֵ��"+arrJava[arrJava.length-1]);
		System.out.println("��Сֵ��"+arrJava[0]);
	}

}
