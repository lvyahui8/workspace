package creatingtype;

//Builder��������'
abstract class  ProductBuilder{
	abstract void buildModule_1();
	abstract void buildModule_2();
	abstract void buildModule_3();
	
	abstract Product buildProduct();
	
	Product constructProduct(){
		buildModule_1();
		buildModule_2();
		buildModule_3();
		return buildProduct();
	}
}
//Product��Ʒ
class Product{
	private String module_1;
	private String module_2;
	private String module_3;
	public String getModule_1() {
		return module_1;
	}
	public void setModule_1(String module_1) {
		this.module_1 = module_1;
	}
	public String getModule_2() {
		return module_2;
	}
	public void setModule_2(String module_2) {
		this.module_2 = module_2;
	}
	public String getModule_3() {
		return module_3;
	}
	public void setModule_3(String module_3) {
		this.module_3 = module_3;
	}
}

class ProductA extends Product{
	
}

//ConcreteBuilderʵ�ʽ�����
class ProductABuilder extends ProductBuilder{

	private Product product;
	public ProductABuilder(){
		this.product = new ProductA();
	}
	@Override
	public void buildModule_1() {
		product.setModule_1("ģ��1");
	}

	@Override
	public void buildModule_2() {
		product.setModule_2("ģ��2");
	}

	@Override
	public void buildModule_3() {
		product.setModule_3("ģ��3");
	}

	@Override
	public Product buildProduct() {
		return this.product;
	}

}

//Director����
class Director{
	public Product constructProduct(ProductBuilder pb){
		pb.buildModule_1();
		pb.buildModule_2();
		pb.buildModule_3();
		return pb.buildProduct();
	}
}

public class BuilderTest {

	public static void main(String[] args) {
		// TODO �Զ����ɵķ������
		Director d = new Director();
//		Product product = d.constructProduct(new ProductABuilder());
		Product product =  new ProductABuilder().constructProduct();
		System.out.println(product.getModule_1());
		System.out.println(product.getModule_2());
		System.out.println(product.getModule_3());
	}

}
