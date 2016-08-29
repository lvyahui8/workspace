class ThreadQuit 
{
	public static void main(String[] args) 
	{
		new Thread(){
			public void run(){
				for (int i=0;i<50 ; i++) {
				    System.out.println(Thread.currentThread().getName()+"     ="+i);
				}
			}
		}.start();

		for (int i=0;i<50 ; i++) {
			System.out.println(Thread.currentThread().getName()+"    ="+i);
		}
		
		Runnable r = new Runnable(){
			public void run(){
				for (int i=0;i<50 ; i++) {
					System.out.println(Thread.currentThread().getName()+"      ="+i);
				}
			}
		};
		new Thread(r).start();
	}
}