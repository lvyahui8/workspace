/*
 * �н���ģʽ��
 * 
 * ���壺���н��߶����װһϵ�еĶ��󽻻����н���ʹ��������Ҫ��ʾ���໥����
 * ���Ӷ�ʹ�����ɢ�����Ҷ����ı�����֮��Ľ���
 * �н���ģʽ�ֳ�Ϊ��ͣģʽ����3����
 * 
 * �����н���
 * ʵ���н���
 * ͬ����
 * 
 * Ϊ����Ҫ����ģʽ��
 * 		һ����ԣ�ͬ����֮��Ĺ�ϵ�ǱȽϸ��ӵģ����ͬ����֮�以�����ʱ�������ʼ쵥
 * 		��ϵ����ֳ����ӵ���״�ṹ������һ�ֹ�����ϵļܹ����Ȳ�������ĸ��ã�Ҳ���ȶ�
 * 		�����ļܹ�����������ͬ��֮�䶼Ҫͨ�ţ���˱����һ��������ȫͼ��ʵ��̫�����ӡ�
 * 		�����ʹ���н���ģʽ������ṹ�ͱ����һ����״�ṹ��һ��ͬ����䶯��ֻ��Ҫ�޸�
 * 		������н��ߣ�����Ҫ�޸�����ͬ���ࡣ
 * 		
 */
package behavioral;
////����ͬ����
//abstract class AbstractColleague{
//	protected int number;
//	public int getNumber(){
//		return number;
//	}
//	
//	public void setNumber(int number){
//		this.number = number;
//	}
//	
//	//���󷽷����޸�����ʱͬʱ�޸Ĺ�������
//	public abstract void setNumber(int number,AbstractColleague coll);
//	
//}
//
//class ColleagueA extends AbstractColleague{
//	public void setNumber(int number,AbstractColleague coll){
//		this.number = number;
//		coll.setNumber(number*100);
//	}
//}
//
//class ColleagueB extends AbstractColleague{
//
//	@Override
//	public void setNumber(int number, AbstractColleague coll) {
//		this.number = number;
//		coll.setNumber(number/100);
//	}
//	
//}
public class IntermediariesTest {

	public static void main(String[] args) {
		AbstractColleague collA = new ColleagueA();
		AbstractColleague collB = new ColleagueB();
		
		AbstractMediator am = new Mediator(collA, collB);
		

		System.out.println("==============����AӰ��B==============");
//		collA.setNumber(1288,collB);
		collA.setNumber(1000, am);
		System.out.println("collA��numberֵ:"+collA.getNumber());
//		System.out.println("collB��numberֵ:"+collB.getNumber());
		System.out.println("collB��numberֵΪA��100��:"+collB.getNumber());
//		
		System.out.println("==============����BӰ��A==============");
//		collB.setNumber(87635, collA);
		collB.setNumber(1000,am);
		System.out.println("collB��numberֵ��"+collB.getNumber());
//		System.out.println("collA��numberֵ��"+collA.getNumber());
		System.out.println("collA��numberֵΪB��0.01����"+collA.getNumber());

	}

}

//����������֮��ֱ�ӷ�����ϵ������������Ҫʹ���н���ģʽ����A����B֮����
//������ֱ�ӹ���������֮�����Ҫͨ��һ���н������ﵽ������Ŀ��

abstract class AbstractMediator{
	protected AbstractColleague a;
	protected AbstractColleague b;
	public AbstractMediator(AbstractColleague a,AbstractColleague b){
		this.a = a;
		this.b = b;
	}
	public abstract void BaffectA();
	public abstract void AaffectB();
}
class Mediator extends AbstractMediator{

	public Mediator(AbstractColleague a, AbstractColleague b) {
		super(a, b);
	}

	@Override
	public void BaffectA() {
		int number = b.getNumber();
		a.setNumber(number/100);
	}

	@Override
	public void AaffectB() {
		int number = a.getNumber();
		b.setNumber(number*100);
	}
	
}
abstract class AbstractColleague{
	protected int number;
	public int getNumber(){
		return number;
	}
	
	public void setNumber(int number){
		this.number = number;
	}
	
	//ע������Ĳ���������ͬ���࣬�����н���
	public abstract void setNumber(int number,AbstractMediator am);
	
}

class ColleagueA extends AbstractColleague{
	public void setNumber(int number,AbstractMediator am){
		this.number = number;
		am.AaffectB();
	}
}

class ColleagueB extends AbstractColleague{

	@Override
	public void setNumber(int number,AbstractMediator am) {
		this.number = number;
		am.BaffectA();
	}
	
}