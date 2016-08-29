import java.util.ArrayList;
import java.util.List;


class Per {
	private String name;
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getSex() {
		return sex;
	}
	public void setSex(String sex) {
		this.sex = sex;
	}
	private String sex;
	public Per(String name, String sex) {
		super();
		this.name = name;
		this.sex = sex;
	}
	public String toString(){
		return this.name+"_"+this.sex;
	}
}
public class CollTest {

	public static void main(String[] args) {
		// TODO 自动生成的方法存根
		List<Per> pers = new ArrayList<Per>();
		Per p = new Per("nihao","nan");
		pers.add(p);
		
		System.out.println(p);
		System.out.println(pers.get(0));
		
		p.setName("我好");
		
		System.out.println(p);
		System.out.println(pers.get(0));
	}

}
