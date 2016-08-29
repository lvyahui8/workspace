import java.util.ArrayList;
//import java.util.Collections;
import java.util.List;

import static java.util.Collections.sort;//静态导包，导入类中静态的内容 （静态函数或者静态变量）

//import static java.lang.System.out;//不能这样导包，因为println不是静态的，他需要对象
import static java.lang.System.*;	//	这里面有一个out的对象
// 1.5后的新特性，静态导入
public class StaticImportDemo {

	public static void main(String[] args) {
		// TODO 自动生成的方法存根
		List<String> list = new ArrayList<String>();
		
		list.add("list_1");
		list.add("list_2");
		list.add("list_3");
		list.add("list_4");
		
		out.println(list);
		
		sort(list);
		
		out.println(list);
	}

}
