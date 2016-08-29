class StackTraceDemo
{
	public static void main(String[] args) 
	{
		System.out.println(findLocation(2));
		System.out.println();
		System.out.println(findAllLocation());
	}

	public static String findAllLocation()
	{
		StringBuilder locations = new StringBuilder();
		StackTraceElement elements [] = Thread.currentThread().getStackTrace();

		for(int i=0;i<elements.length;i++){
			locations.append(findLocation(i) +"\n");
		}
	
		return locations.toString();
	}
	
	public static String findLocation(int level)
	{
		StackTraceElement element = Thread.currentThread().getStackTrace()[level];
		return "File: "+element.getFileName()+" Line: "+element.getLineNumber()+" Method: "+element.getMethodName();
	}
}
