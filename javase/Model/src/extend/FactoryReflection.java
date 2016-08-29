/*
 * 这里将常品归为一个体系
 * 如果想要新产品在程序中起作用就需要实现Product接口，符合Product的规则。
 */

package extend;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Properties;
import java.util.Set;

interface Product{
	public void work();
}

class ProductA implements Product{

	@Override
	public void work() {
		System.out.println("A Work!");
	}
	
}

class ProductB implements Product{
	public void work() {
		System.out.println("B Work!");
	}
}

class ProductC implements Product{
	public void work() {
		System.out.println("C Work!");
	}
}

class Factory{
	private Set<Product> products = new HashSet<Product>();
	public Set<Product> create() throws IOException,ReflectiveOperationException {
		File file = new File("product.properties");
		if(!file.exists()){
			throw new FileNotFoundException();
		}
		Properties prop = new Properties();
		prop.load(new FileReader(file));
		String [] pros = prop.getProperty("product").split(",");
		for (int i = 0; i < pros.length; i++) {
			String className = pros[i];
			Product pro = (Product) Class.forName(className).newInstance();
			this.products.add(pro);
		}
		return products;
	}
}

public class FactoryReflection {

	public static void main(String[] args) {
		Factory fac = new Factory();
		Set<Product> products = null;
		try {
			products = fac.create();
		} catch (ReflectiveOperationException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		for (Iterator<Product>iterator = products.iterator(); iterator.hasNext();) {
			Product product =  iterator.next();
			product.work();
		}
	}

}
