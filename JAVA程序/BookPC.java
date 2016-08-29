//	------------------ǰ��ʵ��------------------------
interface USB {		//���Ⱪ¶�Ĺ���Ϊ���Ժ������չ�������
    public abstract void open();
	public abstract void close();
}
class BookPC {
    public static void main(String [] args){
		//useUSB(new UPan());
		useUSB(null);
	}

	public static void useUSB(USB u){
		if (null != u) {
		    u.open();
			u.close();
		}
	}
}

//	--------------------������չ----------------------
//	---��Щ���ݸ�ǰ�ڴ��������Ժܵ�
class Mouse implements USB{
    public void open(){
		System.out.println("Mouse Open!");
	}

	public void close(){
		System.out.println("Mouse Close!");
	}
}

class UPan implements USB{
    public void open(){
		System.out.println("UPan Open!");
	}

	public void close(){
		System.out.println("UPan Close!");
	}
}