package principle;
class Animal{
	public void breathe(String animal){
		System.out.println(animal+"�������ʿ���");
	}
}
public class SingleResponsibility {

	public static void main(String[] args) {
//		Animal animal = new Animal();
//		animal.breathe("ţ");
//		animal.breathe("��");
//		animal.breathe("��");
		
		Animal animalT = new Terrestrial();
		animalT.breathe("ţ");
		animalT.breathe("��");
		animalT.breathe("��");
		
		Animal animalA = new Aquatic();
		animalA.breathe("��");
	}

}

/*
 * ��������֮���������⣬���������ж��ﶼ��Ҫ���ʿ�������������ֱ�Ӻ���ˮ���������
 * �޸�ʱ�����ѭ��һְ��ԭ����Ҫ��Animal��ϸ��Ϊ½��������Terrestrial��ˮ������Aquatic
 * �޸�����
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
		System.out.println(animal+"����ˮ");
	}
	
}
