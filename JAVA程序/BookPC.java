//	------------------前期实现------------------------
interface USB {		//对外暴露的规则，为了以后程序拓展留下余地
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

//	--------------------后期拓展----------------------
//	---这些内容跟前期代码的耦合性很低
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