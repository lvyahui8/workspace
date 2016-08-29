package work03.question03;
/*
 * 作业三：
	定义一个自行车类（Bicycle），属性是：车品牌、颜色。方法是：启动、停车。
	定义一个电动自行车类（Moto）继承自行车类，定义自己的方法：行驶方法。用
	Moto类实例化对象，分别调用启动、行驶、停车三方法（模拟骑车过程）。

 */
public class Question_3_Test {

	public static void main(String[] args) {
		Moto moto = new Moto(1234,"红色");
		moto.start();
		moto.travel();
		moto.stop();
	}

}
