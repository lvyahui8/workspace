
//	Object������java��ĳ��ࣨ���ࡢ���ࣩ
//	Object�ǲ��ϳ�ȡ�����ģ��߱����ж���Ĺ�������
//
/*
*	Object��equals������ֱ�ӱȽ�����  ��  return  this == object
*	ObjectΪʲôҪдһ����ʱ�ܼ��ߵĹ����أ�
*	��Ϊ�����Object������Ĭ��ʵ�֡�Object���ǳ����࣬�������������
*	���󷽷���ʵ�֣��ͻ��ǳ����࣬����ʵ������������Object������
*	Ĭ��ʵ�֣�������Ҫʹ��equals����ʱ�����ȥ��д�÷�����
*/
class Fu {
    Fu(){
		super();
	}
	public String toString(){
		return "Person :"+"wo d";
	}
}
//RuntimeException

class Zi extends Fu {
	private int num;
    Zi(int num){
		this.num = num;
	}
	public boolean equals(Object/*�����Ž���д*/obj){
		if (obj instanceof Zi) {
		    return this.num == ((Zi)obj).num;
		}
		else {
		    throw new ClassCastException("���ʹ���");
		}
	}
}


class ObjectDemo 
{
	public static void main(String[] args) 
	{
		Zi myZi1 = new Zi(2);
		Zi myZi2 = new Zi(2);
		Fu fu = new Fu();
		if (myZi1.equals(myZi2)) {
		    System.out.println("��ͬ����");
		}
		else {
		    System.out.println("��ͬŶ");
		}
	//	Objecct �� hashCode����
		System.out.println(fu);
		System.out.println(Integer.toHexString(fu.hashCode()));
	//	Class �� .class�ļ��ࡣ �������Դ�������ڶ��е�Class��������ġ�
		Class class1 = myZi1.getClass();
		Class class2 = myZi2.getClass();
		System.out.println(class1 == class2);	//	myZi1 �� myZi2��Ȼ��������ͬ�Ķ��󣬵����Ƕ�����ͬһ��Class����õ��ģ���������Ӧ����true��
		System.out.println(class1.getName());
		
		System.out.println(fu.toString());
		System.out.println(fu.getClass().getName()+"$"+Integer.toHexString(fu.hashCode()));
	
	}
}
