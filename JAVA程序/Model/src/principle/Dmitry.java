package principle;

import java.util.ArrayList;
import java.util.List;

/*
 * 迪米特法则
 * 定义：一个对象应该对其它对象保持最小的了解，所以本原则又叫最少知道原则
 * 
 */

//总公司员工
class Employee{
	private String id;
	public void setId(String id){
		this.id = id;
	}
	public String getId(){
		return id;
	}
}

//分公司员工
class SubEmployee{
	private String id;
	public void setId(String id){
		this.id = id;
	}
	public String getId(){
		return id;
	}
}

//@SuppressWarnings({"rawtypes","unchecked"})
//class SubCompanyManager{
//	
//	public List getAllEmployee(){
//		List list = new ArrayList();
//		for (int i = 0; i < 100; i++) {
//			SubEmployee emp = new SubEmployee();
//			emp.setId("分公司"+i);
//			list.add(emp);
//		}
//		return list;
//	}
//}
//
//@SuppressWarnings({"rawtypes","unchecked"})
//class CompanyManager{
//	public List getAllEmployee(){
//		List list = new ArrayList();
//		for (int i = 0; i < 100; i++) {
//			Employee emp = new Employee();
//			emp.setId("总公司"+i);
//			list.add(emp);
//		}
//		return list;
//	}
//	public void printAllEmployee(SubCompanyManager sub){
//		List<SubEmployee> list1 = sub.getAllEmployee();
//		for(SubEmployee e : list1){
//			System.out.println(e.getId());
//		}
//		List<Employee> list2 = this.getAllEmployee();
//		for(Employee e : list2){
//			System.out.println(e.getId());
//		}
//	}
//}

public class Dmitry {

	public static void main(String[] args) {
		CompanyManager e = new CompanyManager();
		e.printAllEmployee(new SubCompanyManager());
	}
}


//很明显：总公司只要与分公司耦合就行了，不需员工之间产生耦合，改代码如下
@SuppressWarnings({"rawtypes","unchecked"})
class SubCompanyManager{
	
	public List getAllEmployee(){
		List list = new ArrayList();
		for (int i = 0; i < 100; i++) {
			SubEmployee emp = new SubEmployee();
			emp.setId("分公司"+i);
			list.add(emp);
		}
		return list;
	}
	public void printEmployee(){
		List<SubEmployee> list1 = this.getAllEmployee();
		for(SubEmployee e : list1){
			System.out.println(e.getId());
		}
	
	}
}

@SuppressWarnings({"rawtypes","unchecked"})
class CompanyManager{
	public List getAllEmployee(){
		List list = new ArrayList();
		for (int i = 0; i < 100; i++) {
			Employee emp = new Employee();
			emp.setId("总公司"+i);
			list.add(emp);
		}
		return list;
	}
	public void printAllEmployee(SubCompanyManager sub){
		sub.printEmployee();
		List<Employee> list2 = this.getAllEmployee();
		for(Employee e : list2){
			System.out.println(e.getId());
		}
	}
}
