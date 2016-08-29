package mypack;	//	规范：包名统一小写
				//	包体现在文件系统里就是文件夹
/*
import packa.DemoA;
import packa.DemoC;
import packa.DemoD;
//	或者导入全部类(注意，不会导入子包)
import packa.*;
//	导入子包
import packa.zibao.*;
//	导包的原则，用到哪个类，就导入哪个类。
*/
/*
package 1jimulu.2jimulu.3jimulu  //这样就会生成多级文件夹。一个点就是一级文件夹
*/
class DemoB extends packa.DemoA {
	void method(){
		System.out.println("DemoB.method()");
	}
}

class PackageDemo 
{
	public static void main(String[] args) 
	{
		//	下面是包间互访的内容
		//	包之间的类互访，被访问的类必须是public的。
		//DemoA	da = new DemoA();				//	错误，见错误一。要想这么写，必须使用 import  导入软件包
		packa.DemoA	da = new packa.DemoA();		//	正确的，但要满足有足够权限
		da.show("DemoA.show()");
		DemoB	db =	new DemoB();
		db.method();
		System.out.println("Hello World!");
	}
}


/*
错误一：
PackageDemo.java:10: 错误: 找不到符号
                DemoA   da = new DemoA();
                ^
  符号:   类 DemoA
  位置: 类 PackageDemo
PackageDemo.java:10: 错误: 找不到符号
                DemoA   da = new DemoA();
                                 ^
  符号:   类 DemoA
  位置: 类 PackageDemo
2 个错误
//	现在的类有自己所属（包），所以必须将包名带上
*/