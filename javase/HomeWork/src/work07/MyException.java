package work07;

public  class MyException extends Throwable {
	protected int level = 0;
	
	private String location = null;
	
	public void findLocation(int level)
	{
		StackTraceElement element = null;
		int currentLine;
		String fileName;
		element = Thread.currentThread().getStackTrace()[level];
		currentLine = element.getLineNumber();
		fileName = element.getFileName();
		
		location = "File: "+fileName+" Line: "+currentLine;
	}
	
	private static final long serialVersionUID = -9198495466584632327L;
	
	private String info = null;
	
	public String getInfo() {
		return info;
	}

	public void setInfo(String info) {
		this.info = info;
	}

	public MyException() {

	}

	public MyException(String info) {
		this.info = info;
	}
	
	public  void printInfo(){
		System.out.println("Exception Type : "+this.getClass().getName());
		System.out.println("Exception Info : "+this.info);
		System.out.println("Location       : "+this.location);
	}
}


