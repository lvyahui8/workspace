package work03.question02;
/*
 * 作业二：
编写一个家庭类，有三个属性：外观、存折、电话，分别赋值，另外有三个方法：查看存折金额(私有)，拨打电话(保护)，观看房屋(公共)
在测试类里实例化对象并调用以上3个方法，结果是什么？并说明原因？

在JAVA中，访问权限
	public > protected > default > private
	其中protected在相同包内等同于public
 */
public class Question_2_Test {

	public static void main(String[] args) {
		Family family = new Family("丽水别墅","央行存折","88888888");
//		family.getBankbook();//方法不能调用
		family.callPhone();//处在同一包中可以访问，与C++ 存在区别
		family.viewExterior();//可以调用
	}

}
