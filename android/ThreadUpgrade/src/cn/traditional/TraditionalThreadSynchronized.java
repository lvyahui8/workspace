package cn.traditional;

public class TraditionalThreadSynchronized {
	private Outputer op = new Outputer();
	public Outputer getOutputer(){
		return op;
	}
	class Outputer{
		private int i=0;
		public void output(String name){
			int len = name.length();
			synchronized (this) {
				for(i = 0;i<len;i++){
					System.out.print(name.charAt(i));
				}
			}
			System.out.println("");
		}
	}
	
	public static void main(String[] args) {
		// TODO �Զ����ɵķ������
		TraditionalThreadSynchronized tts = new TraditionalThreadSynchronized();
		final Outputer op  = tts.getOutputer();
		tts.print(op,"hahahahahaha");
		tts.print(op,"234567890664");
	}

	private  void print(final Outputer op,final String str) {
		new Thread(new Runnable() {
			
			@Override
			public void run() {
				while (true) {
					try {
						Thread.sleep(20);
					} catch (InterruptedException e) {
						// TODO �Զ����ɵ� catch ��
						e.printStackTrace();
					}
					op.output(str);
				}
			}
		}).start();;
	}
	
	

}
