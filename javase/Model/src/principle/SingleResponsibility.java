package principle;
class Animal{
	public void breathe(String animal){
		System.out.println(animal+"呼吸新鲜空气");
	}
}
public class SingleResponsibility {

	public static void main(String[] args) {
//		Animal animal = new Animal();
//		animal.breathe("牛");
//		animal.breathe("羊");
//		animal.breathe("猪");
		
		Animal animalT = new Terrestrial();
		animalT.breathe("牛");
		animalT.breathe("羊");
		animalT.breathe("猪");
		
		Animal animalA = new Aquatic();
		animalA.breathe("鱼");
	}

}

/*
 * 程序上线之后发现了问题，并不是所有动物都需要新鲜空气，比如鱼是直接呼吸水获得氧气的
 * 修改时如果遵循单一职责原则，需要将Animal类细分为陆生动物类Terrestrial，水生动物Aquatic
 * 修改如下
 */

class Terrestrial extends Animal{

	@Override
	public void breathe(String animal) {
		super.breathe(animal);
	}
	
}

class Aquatic extends Animal{

	@Override
	public void breathe(String animal) {
		System.out.println(animal+"呼吸水");
	}
	
}
