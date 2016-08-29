package work07;

@SuppressWarnings("serial")
public final class NumberSizeException extends MyException {

	{
		findLocation(3);
	}
	
	public NumberSizeException() {
	}
	
	
	public NumberSizeException(String info) {
		super(info);
	}

}
