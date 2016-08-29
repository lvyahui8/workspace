package cn.upgrade;

import java.util.Random;
import java.util.concurrent.Callable;
import java.util.concurrent.CompletionService;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorCompletionService;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

@SuppressWarnings("unused")
public class CallableAndFuture {

	public static void main(String [] args){
		ExecutorService threadPool = Executors.newSingleThreadExecutor();
		Future<String> future = threadPool.submit(new Callable<String>() {
			@Override
			public String call() throws Exception {
				Thread.sleep(1000);
				return "hello world";
			}
		});
		
		System.out.println("等待结果");
		
		try{
			System.out.println("拿到结果："+future.get());
		}
		catch (Exception e) {
			e.printStackTrace();
		}
		
		
//		ExecutorService threadPool = Executors.newFixedThreadPool(10);
//		CompletionService<Integer> completionService = new ExecutorCompletionService<Integer>(threadPool);
//		for(int i=0;i<10;i++){
//			final int task = i;
//			completionService.submit(new Callable<Integer>(){
//				@Override
//				public Integer call() throws Exception {
//					Thread.sleep(new Random().nextInt(5000));
//					return task;
//				}
//			});
//		}
//		
//		for(int i=0;i<10;i++){
//			try {
//				System.out.println(
//						completionService.take().get()
//						);
//			} catch (InterruptedException e) {
//				e.printStackTrace();
//			} catch (ExecutionException e) {
//				e.printStackTrace();
//			}
//		}

	
	}
	
	
	
}
