package behavioral;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/*
 * 观察者模式：
 * 
 * 定义对象中的一种一对多的依赖关系，当一个对象的状态发生改变时，所有依赖于它的对象都得到通知并被自动更新
 * 
 * 应用举例  ： AWT事件监听机制
 * 
 * 下面模拟警察对城市突发事件的监听
 * 
 * 
 * 在java语言中，有一个接口Observer，以及它的实现类Observable，对被观察者角色进行了实现
 */
//	突发事件
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
		// TODO 自动生成的方法存根
		return new String(new Date(time).toString()+"#"+info+"#"+obj.toString());
	}
}
//	Subject
abstract class Citizen{
	List<Policeman> pols;	// 存放所有的监听者
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
			//	通知警察行动
			pol.actionToSuddenEvent(new SuddenEvent(System.currentTimeMillis(),this.getHelp(),this));
		}
	}

	@Override
	public String toString() {
		// TODO 自动生成的方法存根
		return new String("黄埔城");
	}
}

class TianHeCitizen extends Citizen {

	public TianHeCitizen(){
		setPoliceman();
	}
	@Override
	void sendMessage(String help) {
		// TODO 自动生成的方法存根
		setHelp(help);
		for(int i=0;i<pols.size();i++){
			Policeman pol = pols.get(i);
			//	通知警察行动
			pol.actionToSuddenEvent(new SuddenEvent(System.currentTimeMillis(),this.getHelp(),this));
		}
	}
	
	@Override
	public String toString() {
		// TODO 自动生成的方法存根
		return new String("天河城");
	}
	
}

// ConcreteObserver
class HuangPuPoliceman implements Policeman{

	@Override
	public void actionToSuddenEvent(SuddenEvent se) {
		// TODO 自动生成的方法存根
		String help = se.getInfo();
		System.out.print(se.toString());
		if ("normal".equals(help)) {
			System.out.println("一切正常！不用行动");
		} else if ("unnormal".equals(help)){
			System.out.println("有犯罪行为！黄埔警方行动");
		}
	}
	
}

class TianHePoliceman implements Policeman{

	@Override
	public void actionToSuddenEvent(SuddenEvent se) {
		// TODO 自动生成的方法存根
		String help = se.getInfo();
		System.out.print(se.toString());
		if ("normal".equals(help)) {
			System.out.println("一切正常！不用行动");
		} else if ("unnormal".equals(help)){
			System.out.println("有犯罪行为！天河警方行动");
		}
	}
	
}
public class ObserverTest {

	public static void main(String[] args) {
		// TODO 自动生成的方法存根
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
