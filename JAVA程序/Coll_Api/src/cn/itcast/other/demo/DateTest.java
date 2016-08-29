package cn.itcast.other.demo;

import java.text.DateFormat;
import java.text.ParseException;

/*
 * Date��ϰ
 * "2014-1-1"��"2014-4-23"
 * ˼·��
 * �����������
 * ��ô��
 * ���������������������
 * �ܼ��ľ��Ǻ���ֵ
 * �����Ƚ����ڶ���ת���ź���ֵ
 * Ȼ�����
 * �������ĺ���ֵת��������
 */
public class DateTest {

	public static void main(String[] args) {
		// TODO �Զ����ɵķ������
		/*
		 * 
		 */
		
		String date2 = "2014-4-23";
		String date1 = "2014-1-1";
		int day = distance(date1,date2);
		System.out.println(day);
	}

	private static int distance(String date1, String date2) {
		// TODO �Զ����ɵķ������
		DateFormat dateFormat = DateFormat.getDateInstance();
		int day = 0;
		try {
			long time1 = dateFormat.parse(date1).getTime();
			long time2 = dateFormat.parse(date2).getTime();
			long time = Math.abs(time2-time1);
			day = (int)(time/1000/60/60/24);
		} catch (ParseException e) {
			// TODO �Զ����ɵ� catch ��
			e.printStackTrace();
		}
		return day;
	}

}
