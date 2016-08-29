package org.yahui.d;


import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.io.RandomAccessFile;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.CountDownLatch;

public class DownLoader {
	public static final long MAX_WAIT_TIME = 5000;
	private String filePath;			//文件路径，例如D:/xampp/
	private String fileFullName;		//文件全名，例如D:/xampp/start.exe
	private List<Long> ids = new ArrayList<Long>();

	private int threadCount = 1;
	
	private int finishR = 0;
	private boolean downFinish = false;
	
	private String uri;
	private long size = 0;
	private boolean getSizeOk = false;
	
	private CountDownLatch cdAnswer = new CountDownLatch(1);
	public DownLoader(final String uri) {
		this.uri = uri;
		new Thread(
				new Runnable() {
					
					@Override
					public void run() {
						// TODO Auto-generated method stub
						//设置文件大小
						try {
							URL url = new URL(uri);
							HttpURLConnection conn = (HttpURLConnection) url.openConnection();
							conn.setConnectTimeout(4555);
							conn.setRequestMethod("GET");
							int code = conn.getResponseCode();
							if(200==code){
								DownLoader.this.size =  conn.getContentLength();
								getSizeOk = true;
							}
						} catch (IOException e) {
							// TODO Auto-generated catch block
							e.printStackTrace();
						}
					}
				}
		).start();
		
	}

	public int getThreadCount() {
		return threadCount;
	}

	public void setThreadCount(int threadCount) {
		this.threadCount = threadCount;
		cdAnswer = new CountDownLatch(threadCount);
	}

	public String getFileFullName() {
		return fileFullName;
	}

	public void setFileFullName(String fileFullName) {
		this.fileFullName = fileFullName;
		File f = new File(fileFullName);
		filePath = f.getParent();
		File fileDir = new File(filePath);
		if(!fileDir.exists()){
			fileDir.mkdir();
		}
	}

	private  class DownLoadRunnable implements Runnable{
		private long startIndex;
		private long endIndex;
		private String uri;
		private String tmpFile;

		public DownLoadRunnable(long startIndex, long endIndex,
				String uri,String tmpFile) {
			super();
			this.startIndex = startIndex;
			this.endIndex = endIndex;
			this.uri = uri;
			this.tmpFile = tmpFile;
		}
		
		@Override
		public void run() {
			try {
				confirmStart();						//确认起点，从断点下载
				URL url = new URL(uri);
				HttpURLConnection conn = (HttpURLConnection) url.openConnection();
				conn.setConnectTimeout(4555);
				conn.setRequestMethod("GET");
				conn.setRequestProperty("Range", "bytes="+startIndex+"-"+endIndex);		//重点，设置下载部分数据
				if(206==conn.getResponseCode()){
					download(conn);
				}
				cdAnswer.countDown();	//表示此线程下载完毕
System.out.println("线程"+tmpFile+"下载完毕");
			}  catch (Exception e) {
				e.printStackTrace();
			}
			finally{
				synchronized (DownLoadRunnable.class) {
					finishR++;
					if(finishR==threadCount){
						downFinish = true;
						System.out.println("下载完成");
					}
				}
			}
		}


		private void download(HttpURLConnection conn) throws IOException,
				FileNotFoundException {
			InputStream is = conn.getInputStream();
			RandomAccessFile raf = new RandomAccessFile(fileFullName, "rw");
			raf.seek(startIndex);//定位文件

			int len = 0;
			byte [] buffer = new byte[1024];
			long total = 0;	//此次下载的数据量
			while((len = is.read(buffer))!=-1){
				RandomAccessFile tmpRaf = new RandomAccessFile(tmpFile,"rwd");//保证覆盖原tmp文件，以防数字尾部不被覆盖
				raf.write(buffer, 0, len);
				total += len;
				tmpRaf.writeUTF(total+startIndex+"");
System.out.println("线程"+tmpFile+"下载到"+(total+startIndex));
				tmpRaf.close();
			}
			is.close();
			raf.close();
		}

		private void confirmStart() throws FileNotFoundException, IOException {
			File f = new File(tmpFile);
			if(f.exists()){
				RandomAccessFile tmpRaf = new RandomAccessFile(f,"r");
				startIndex = Long.parseLong(tmpRaf.readUTF());
				tmpRaf.close();
			}
		}
	}
	private  void delTmpFile() {
		System.out.println("删除临时文件");
		for (Iterator<Long> it = ids.iterator(); it.hasNext(); ) {
			File deleteFile = new File(filePath+File.separator+String.valueOf(it.next()));
			if(deleteFile.exists()) deleteFile.delete();
		}
	}

	public void startDownload() {
		new Thread(new Runnable() {
			
			@Override
			public void run() {
				// TODO Auto-generated method stub
				try {
					{
						long startTime = System.currentTimeMillis();
						long currentTime = System.currentTimeMillis();
						while(!getSizeOk && currentTime - startTime < MAX_WAIT_TIME){
							currentTime = System.currentTimeMillis();
						}
					}
					RandomAccessFile raf;
					raf = new RandomAccessFile(fileFullName, "rw");
					raf.setLength(size);		//创建一个一样大的空文件
					raf.close();
					long blockSize = size / threadCount;
					//ExecutorService threadPool = Executors.newFixedThreadPool(threadCount);
					
					for (long i = 0; i < threadCount; i++) {
						long startIndex = i*blockSize;
						long endIndex = startIndex+blockSize - 1;
						if(i==threadCount-1){endIndex=size;}//最后一个线程下载到文件尾部
						System.out.println("线程"+i+"下载"+startIndex+"到"+endIndex);
						ids.add(i);	//记录每个线程的id
						String tmpFile = filePath+File.separator+i+".dtmp";
						DownLoadRunnable dr = new DownLoadRunnable(startIndex,endIndex,uri,tmpFile);
						//threadPool.execute(dr);
						new Thread(dr).start();
					}
					cdAnswer.await();//等待线程下载完毕
					//threadPool.shutdown();		//保证线程执行完毕后关闭线程池
					if(downFinish) delTmpFile();//删除临时文件
				}catch (Exception e) {
					e.printStackTrace();
				} 
				
			}
		}).start();
	}
	
	public  long getSize(){
		return this.size;
	}
}
