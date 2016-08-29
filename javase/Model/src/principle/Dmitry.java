package principle;

import java.util.ArrayList;
import java.util.List;

/*
 * �����ط���
 * ���壺һ������Ӧ�ö��������󱣳���С���˽⣬���Ա�ԭ���ֽ�����֪��ԭ��
 * 
 */

//�ܹ�˾Ա��
class Employee{
	private String id;
	public void setId(String id){
		this.id = id;
	}
	public String getId(){
		return id;
	}
}

//�ֹ�˾Ա��
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
//			emp.setId("�ֹ�˾"+i);
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
//			emp.setId("�ܹ�˾"+i);
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


//�����ԣ��ܹ�˾ֻҪ��ֹ�˾��Ͼ����ˣ�����Ա��֮�������ϣ��Ĵ�������
@SuppressWarnings({"rawtypes","unchecked"})
class SubCompanyManager{
	
	public List getAllEmployee(){
		List list = new ArrayList();
		for (int i = 0; i < 100; i++) {
			SubEmployee emp = new SubEmployee();
			emp.setId("�ֹ�˾"+i);
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
			emp.setId("�ܹ�˾"+i);
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
