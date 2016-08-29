class ThreadTest 
{
	public static void main(String[] args) 
	{
		Thread t = new Thread(
			new Runnable(){
				public void run(){
					System.out.println("1");
				}
			}
			){
			public void run(){
				System.out.println("2");
			}
		};
		t.start();
		System.out.println("Hello World!");
	}
}
