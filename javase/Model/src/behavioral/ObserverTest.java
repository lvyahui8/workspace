package behavioral;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/*
 * �۲���ģʽ��
 * 
 * ��������е�һ��һ�Զ��������ϵ����һ�������״̬�����ı�ʱ���������������Ķ��󶼵õ�֪ͨ�����Զ�����
 * 
 * Ӧ�þ���  �� AWT�¼���������
 * 
 * ����ģ�⾯��Գ���ͻ���¼��ļ���
 * 
 * 
 * ��java�����У���һ���ӿ�Observer���Լ�����ʵ����Observable���Ա��۲��߽�ɫ������ʵ��
 */
//	ͻ���¼�
class SuddenEvent{
	private long time ;
	private String info;
	private Object obj;
	public SuddenEvent(long time, String info, Object obj) {
		this.time = time;
		this.info = info;
		this.obj = obj;
	}
	public long getTime() {
		return time;
	}
	public void setTime(long time) {
		this.time = time;
	}
	public String getInfo() {
		return info;
	}
	public void setInfo(String info) {
		this.info = info;
	}
	public Object getObj() {
		return obj;
	}
	public void setObj(Object obj) {
		this.obj = obj;
	}
	@Override
	public String toString() {
		// TODO �Զ����ɵķ������
		return new String(new Date(time).toString()+"#"+info+"#"+obj.toString());
	}
}
//	Subject
abstract class Citizen{
	List<Policeman> pols;	// ������еļ�����
	String help = "normal";
	
	public void setHelp(String help){
		this.help = help;
	}
	
	public String getHelp(){
		return this.help;
	}
	
	abstract void sendMessage(String help);
		
	public void setPoliceman() {
		this.pols = new ArrayList<Policeman>();
	}
	
	public void addPoliceman(Policeman pol){
		this.pols.add(pol);
	}
	
	public void delPoliceman(Policeman pol){
		this.pols.remove(pol);
	}
	
}

//	Observer
interface Policeman{
	void actionToSuddenEvent(SuddenEvent se);
}

// ConcreteSubject
class HuangPuCitizen extends Citizen{

	public HuangPuCitizen(){
		setPoliceman();
	}
	void sendMessage(String help) {
		setHelp(help);
		for(int i=0;i<pols.size();i++){
			Policeman pol = pols.get(i);
			//	֪ͨ�����ж�
			pol.actionToSuddenEvent(new SuddenEvent(System.currentTimeMillis(),this.getHelp(),this));
		}
	}

	@Override
	public String toString() {
		// TODO �Զ����ɵķ������
		return new String("���ҳ�");
	}
}

class TianHeCitizen extends Citizen {

	public TianHeCitizen(){
		setPoliceman();
	}
	@Override
	void sendMessage(String help) {
		// TODO �Զ����ɵķ������
		setHelp(help);
		for(int i=0;i<pols.size();i++){
			Policeman pol = pols.get(i);
			//	֪ͨ�����ж�
			pol.actionToSuddenEvent(new SuddenEvent(System.currentTimeMillis(),this.getHelp(),this));
		}
	}
	
	@Override
	public String toString() {
		// TODO �Զ����ɵķ������
		return new String("��ӳ�");
	}
	
}

// ConcreteObserver
class HuangPuPoliceman implements Policeman{

	@Override
	public void actionToSuddenEvent(SuddenEvent se) {
		// TODO �Զ����ɵķ������
		String help = se.getInfo();
		System.out.print(se.toString());
		if ("normal".equals(help)) {
			System.out.println("һ�������������ж�");
		} else if ("unnormal".equals(help)){
			System.out.println("�з�����Ϊ�����Ҿ����ж�");
		}
	}
	
}

class TianHePoliceman implements Policeman{

	@Override
	public void actionToSuddenEvent(SuddenEvent se) {
		// TODO �Զ����ɵķ������
		String help = se.getInfo();
		System.out.print(se.toString());
		if ("normal".equals(help)) {
			System.out.println("һ�������������ж�");
		} else if ("unnormal".equals(help)){
			System.out.println("�з�����Ϊ����Ӿ����ж�");
		}
	}
	
}
public class ObserverTest {

	public static void main(String[] args) {
		// TODO �Զ����ɵķ������
		Policeman thPol = new TianHePoliceman();
		Policeman hpPol = new HuangPuPoliceman();
		
		Citizen citizen = new HuangPuCitizen();
		citizen.addPoliceman(hpPol);
		citizen.sendMessage("unnormal");
		citizen.sendMessage("normal");
		
		System.out.println("--------------");
		
		citizen = new TianHeCitizen();
		citizen.addPoliceman(thPol);
		citizen.sendMessage("unnormal");
		citizen.sendMessage("normal");
	}

}
