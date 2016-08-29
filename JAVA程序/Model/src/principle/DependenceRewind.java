package principle;
//依赖倒转原则
/*
 * 它基于这样一个事实，相对于细节的多变性，抽象的东西要稳定的多。
 * 依赖倒转原则的核心就是依赖接口编程
 * 
 * 在实际开发中，我们应该做到以下3点
 * 1、底层模块尽量都要有抽象类或接口，或者两者都有
 * 2、变量的声明类型尽量是抽象类或接口
 * 3、使用几次时遵循里氏替换原则
 */

//class Book{
//	public String getContent(){
//		return "在很久很久以前。。。。。";
//	}
//}


//class Mother{
//	public void marrate(Book book){
//		System.out.println("母亲开始讲故事");
//		System.out.println(book.getContent());
//	}
//}

public class DependenceRewind {

	public static void main(String[] args) {
		Mother mother = new Mother();
		mother.marrate(new Book());
		mother.marrate(new Newspaper());
	}

}


//假如有一天给母亲的是报纸或是其它的什么，那怎么办母亲不会读，需要修母亲才能做到
//解决的方法就是面向接口编程  ，定义读物类接口

interface IReader{
	public String getContent();
}


class Book implements IReader{
	public String getContent(){
		return "在很久很久以前。。。。。";
	}
}

class Newspaper implements IReader{
	public String getContent(){
		return "林书豪17+9助尼克斯击败老鹰。。。。";
	}
}
class Mother{
	public void marrate(IReader reader){
		System.out.println("母亲开始讲故事");
		System.out.println(reader.getContent());
	}
}