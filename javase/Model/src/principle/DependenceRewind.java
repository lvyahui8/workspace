package principle;
//������תԭ��
/*
 * ����������һ����ʵ�������ϸ�ڵĶ���ԣ�����Ķ���Ҫ�ȶ��Ķࡣ
 * ������תԭ��ĺ��ľ��������ӿڱ��
 * 
 * ��ʵ�ʿ����У�����Ӧ����������3��
 * 1���ײ�ģ�龡����Ҫ�г������ӿڣ��������߶���
 * 2���������������;����ǳ������ӿ�
 * 3��ʹ�ü���ʱ��ѭ�����滻ԭ��
 */

//class Book{
//	public String getContent(){
//		return "�ںܾúܾ���ǰ����������";
//	}
//}


//class Mother{
//	public void marrate(Book book){
//		System.out.println("ĸ�׿�ʼ������");
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


//������һ���ĸ�׵��Ǳ�ֽ����������ʲô������ô��ĸ�ײ��������Ҫ��ĸ�ײ�������
//����ķ�����������ӿڱ��  �����������ӿ�

interface IReader{
	public String getContent();
}


class Book implements IReader{
	public String getContent(){
		return "�ںܾúܾ���ǰ����������";
	}
}

class Newspaper implements IReader{
	public String getContent(){
		return "�����17+9�����˹������ӥ��������";
	}
}
class Mother{
	public void marrate(IReader reader){
		System.out.println("ĸ�׿�ʼ������");
		System.out.println(reader.getContent());
	}
}