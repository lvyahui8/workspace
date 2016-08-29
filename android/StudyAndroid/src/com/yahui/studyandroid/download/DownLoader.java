package com.yahui.studyandroid.download;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.io.RandomAccessFile;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class DownLoader {
	private String filePath;			//文件路径，例如D:/xampp/
	private String fileFullName;		//文件全名，例如D:/xampp/start.exe
	private Set<Integer> ids = new HashSet<Integer>();

	private int threadCount = 1;
	
	private int finishR = 0;
	private boolean downFinish = false;
	
	private String uri;
	private long size = 0;
	private CountDownLatch cdAnswer = null;
	public DownLoader(String uri) {
		this.uri = uri;
		
		//设置文件大小
		try {
			URL url = new URL(uri);
			HttpURLConnection conn = (HttpURLConnection) url.openConnection();
			conn.setConnectTimeout(4555);
			conn.setRequestMethod("GET");
			int code = conn.getResponseCode();
			if(200==code){
				this.size =  conn.getContentLength();
			}
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
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
		int lastSpIndex = fileFullName.lastIndexOf(File.separator) + 1;
		filePath = fileFullName.substring(0, lastSpIndex);
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
			}  catch (Exception e) {
				e.printStackTrace();
			}
			finally{
				synchronized (DownLoadRunnable.class) {
					finishR++;
					if(finishR==threadCount){
						downFinish = true;
					}
				}
			}
		}

		@SuppressWarnings("resource")
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
				tmpRaf.writeLong(total+startIndex);//记录下载到的位置
			}
			is.close();
			raf.close();
		}

		private void confirmStart() throws FileNotFoundException, IOException {
			File f = new File(tmpFile);
			if(f.exists()){
				RandomAccessFile tmpRaf = new RandomAccessFile(f,"r");
				startIndex = tmpRaf.readLong();
				tmpRaf.close();
			}
		}
	}
	private  void delTmpFile() {
		for (Iterator<Integer> it = ids.iterator(); it.hasNext(); ) {
			File deleteFile = new File(it.next().toString());
			if(deleteFile.exists()) deleteFile.delete();
		}
	}

	public void startDownload() {
		try {
			RandomAccessFile raf;
			raf = new RandomAccessFile(fileFullName, "rw");
			raf.setLength(size);		//创建一个一样大的空文件
			raf.close();
			long blockSize = size / threadCount;
			ExecutorService threadPool = Executors.newFixedThreadPool(threadCount);
			
			for (int i = 0; i < threadCount; i++) {
				long startIndex = (threadCount)*blockSize;
				long endIndex = startIndex+blockSize - 1;
				ids.add(i);	//记录每个线程的id
				String tmpFile = filePath+File.separator+i;
				DownLoadRunnable dr = new DownLoadRunnable(startIndex,endIndex,uri,tmpFile);
				threadPool.execute(dr);
			}
			cdAnswer.await();//等待线程下载完毕
			threadPool.shutdown();		//保证线程执行完毕后关闭线程池
			if(downFinish) delTmpFile();//删除临时文件
		}catch (IOException e) {
			e.printStackTrace();
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public  long getSize(){
		return this.size;
	}
}
