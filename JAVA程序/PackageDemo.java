package mypack;	//	�淶������ͳһСд
				//	���������ļ�ϵͳ������ļ���
/*
import packa.DemoA;
import packa.DemoC;
import packa.DemoD;
//	���ߵ���ȫ����(ע�⣬���ᵼ���Ӱ�)
import packa.*;
//	�����Ӱ�
import packa.zibao.*;
//	������ԭ���õ��ĸ��࣬�͵����ĸ��ࡣ
*/
/*
package 1jimulu.2jimulu.3jimulu  //�����ͻ����ɶ༶�ļ��С�һ�������һ���ļ���
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
		//	�����ǰ��以�õ�����
		//	��֮����໥�ã������ʵ��������public�ġ�
		//DemoA	da = new DemoA();				//	���󣬼�����һ��Ҫ����ôд������ʹ�� import  ���������
		packa.DemoA	da = new packa.DemoA();		//	��ȷ�ģ���Ҫ�������㹻Ȩ��
		da.show("DemoA.show()");
		DemoB	db =	new DemoB();
		db.method();
		System.out.println("Hello World!");
	}
}


/*
����һ��
PackageDemo.java:10: ����: �Ҳ�������
                DemoA   da = new DemoA();
                ^
  ����:   �� DemoA
  λ��: �� PackageDemo
PackageDemo.java:10: ����: �Ҳ�������
                DemoA   da = new DemoA();
                                 ^
  ����:   �� DemoA
  λ��: �� PackageDemo
2 ������
//	���ڵ������Լ����������������Ա��뽫��������
*/