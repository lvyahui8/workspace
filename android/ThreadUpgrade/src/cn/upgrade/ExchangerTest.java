package cn.upgrade;
import java.util.concurrent.Exchanger;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * 
 * ���������߳�֮�佻������
 * @author Agrin
 *
 */
public class ExchangerTest {

	@SuppressWarnings("rawtypes")
	public static void main(String[] args) {
		ExecutorService service = Executors.newCachedThreadPool();
		final Exchanger exchanger = new Exchanger();
		service.execute(new Runnable(){
			@SuppressWarnings("unchecked")
			public void run() {
				try {				

					String data1 = "zxx";
					System.out.println("�߳�" + Thread.currentThread().getName() + 
					"���ڰ�����" + data1 +"����ȥ");
					Thread.sleep((long)(Math.random()*10000));
					String data2 = (String)exchanger.exchange(data1);
					System.out.println("�߳�" + Thread.currentThread().getName() + 
					"���ص�����Ϊ" + data2);
				}catch(Exception e){
					
				}
			}	
		});
		service.execute(new Runnable(){
			@SuppressWarnings("unchecked")
			public void run() {
				try {				

					String data1 = "lhm";
					System.out.println("�߳�" + Thread.currentThread().getName() + 
					"���ڰ�����" + data1 +"����ȥ");
					Thread.sleep((long)(Math.random()*10000));					
					String data2 = (String)exchanger.exchange(data1);
					System.out.println("�߳�" + Thread.currentThread().getName() + 
					"���ص�����Ϊ" + data2);
				}catch(Exception e){
					
				}				
			}	
		});		
	}
}
