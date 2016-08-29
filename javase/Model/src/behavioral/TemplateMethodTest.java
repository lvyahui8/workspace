/*
 * 模板方法模式
 * 
 * 定义一个模板中算法的框架，而将一些步骤延迟到子类中，使得类可以不改变算法的结构即可重定义
 * 该算法中的某些特定步骤
 * 
 * 模板方法的结构：
 * 模板方法模式由一个抽象类和一个（或一组）实现类通过继承结构组成，抽象类中的方法分为三种：
 * 		抽象方法：父类中只声明但不加以实现，而是定义好规范，然后由它的子类去实现。
 * 		模板方法：由抽象类声明并加以实现。一般来说，模板方法调用抽象方法来完成主要的逻辑功能
 * 				，并且，模板方法大多会定义为final类型，指明不被重载
 * 		钩子方法：由抽象类声明并加以实现，但是子类可以去扩展，子类可以通过扩展钩子方法来影响
 * 				模板方法的逻辑。
 * 
 * 
 */
package behavioral;
//抽象的部分先自己实现
abstract class AbstractSort{
	/**
	 * 将数组Array由小到大排序
	 * @param array
	 */
	protected abstract void sort(int [] array);
	
	public void showSortResult(int [] array){
		this.sort(array);
		System.out.println("排序结果:");
		for (int i = 0; i < array.length; i++) {
			System.out.printf("%3s",array[i]);
		}
	}
}

//下面的部分可以先交给别人来做
class ConcreteSort extends AbstractSort{

	@Override
	protected void sort(int[] array) {
		for (int i = 0; i < array.length-1; i++) {
			int indexMin = i;
			for(int j = i+1;j<array.length;j++){
				if(array[indexMin] > array[j]){
					indexMin = j;
				}
			}
			if(i!=indexMin){
				swap(array,i,indexMin);
			}
		}
	}

	private void swap(int[] array, int m, int n) {
		int temp = array[m];
		array[m] = array[n];
		array[n] = temp;
	}
	
}
public class TemplateMethodTest {

	public static void main(String[] args) {
		int [] array = {10,2,3,4,7,5,9,8,1};
		AbstractSort as = new ConcreteSort();
		as.showSortResult(array);
	}

}
