/**
�ĵ�ע�ͣ�
��ð�
ע�ⶨ21����31�е�����
*/
public class Demo 
{
	public static void main(String[] args) 
	{
		System.out.println("Hello WDS!");
		byte	b = 3;
		short	s = 4;
		int		i = 5;
		long	l = 6;
		float	f = 2.3f;	//����ָ���������ͣ����߽�����ʾǿ��ת����Ĭ����˫���ȵ�
		System.out.println(b);
		// java�ܹ��Զ������������������ͣ������ܽ��ͣ�������Ҫ��ʾǿ��ת��
		char	charVar = 'h';
		short	shortVar = 3;
		byte	byteVar = 2;
		//short	shortResult = shortVar + byteVar;	// short��byte���ᱻ����Ϊint
		int		intVar = 4;
		// char �� short��byte������������ʱ������char������Ϊint���������ʽ��ֵ����int����,s�����ǲ��ܸ�ֵ��short
		//short	shortResult = shortVar + charVar;
		int		intResult = shortVar + charVar;
		System.out.println("intResult = shortVar + charVar = "+intResult);
		long	longVar = 6;
		long	longResult = intVar + longVar;
		float	floatResult1 = intVar + longVar;
		float	floatResult2 = floatResult1 + intVar + longVar;
		System.out.println("intVar = "+intVar+'\n'+"longVar = "+longVar);
		System.out.println("longResult = intVar + longVar = "+longResult);
		System.out.println("floatResult1 = intVar + longVar = "+floatResult1);
		System.out.println("floatResult2 = floatResult1 + intVar + longVar = "+floatResult2);
		// �����������ַ�ʽ��1��ʹ��new�ؼ��ַ����ڴ� 2��ֱ�ӳ�ʼ�������ڴ�
		String [] name = new String[3];
		System.out.println(name[0]); 
		System.out.println(name[1]);
		System.out.println(name[2]);
		int [][]score = {		//��C\C++������Ʋ�ͬ���ڶ�ά����Ҳ���Բ�ָ��
			{1,2,3},
			{4,5,6},
			{7,8,9}
		};
		char	ch = '��';
		System.out.println(score[1][1]);
		System.out.println(ch);
		short	sv=32767;	// ���浽 2^15-1�������ʼ��Ϊ2^15���뱨��
		sv+=1;	// ��������������
		System.out.println(sv);
		System.out.println(8 >> 2);
		System.out.println(8 << 2);
		System.out.println(8 & 2);
		System.out.println(8 | 2);
		System.out.println(8 ^ 2);
		System.out.println(~8);
		String [] str = new String[]{"nihao","wohao"};
		//System.out.println(str[0]);
		//System.out.println(str[1]);
		//System.out.println(str[2]);
		int [] aa,bb = new int[3];
		aa = null;
		bb[0] = 0;
		bb[1] = 1;
		bb[2] = 2;
		System.out.println(aa);
		System.out.println(bb.toString());
		for(int ii=0;ii<bb.length;ii++){
			System.out.println(bb[ii]);
		}
	}
}
