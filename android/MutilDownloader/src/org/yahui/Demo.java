package org.yahui;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.io.RandomAccessFile;
import java.net.HttpURLConnection;
import java.net.URL;

public class Demo {
	@SuppressWarnings("resource")
	public static void main(String[]a){
		//连接服务器，获取一个文件，获取文件的长度，在本地首先
		//创建一个相同大小的空文件
		//http://www.voidtools.com/Everything-1.3.4.686.x86-Setup.exe
		try {
			final String path = "http://www.voidtools.com/Everything-1.3.4.686.x86-Setup.exe";
			URL url = new URL(path);
			HttpURLConnection conn = (HttpURLConnection) url.openConnection();
			conn.setConnectTimeout(4555);
			conn.setRequestMethod("GET");
			int code = conn.getResponseCode();
			if(200==code){
				//服务器返回的数据（应答体）的长度，在这里便是文件的大小
				int length = conn.getContentLength();
				System.out.println("文件长度："+length);
				//在本地创建一个大小的空文件
				RandomAccessFile raf = new RandomAccessFile("everthing.exe", "rw");
				raf.setLength(length);
				//假设启动3个线程进行下载
				int threadCount = 5;
				int blockSize = length / threadCount;
				
				for(int threadID=1;threadID<=threadCount;threadID++){
					int startIndex = (threadID-1)*blockSize;
//					int endIndex = threadID*blockSize-1;
					int endIndex = startIndex + blockSize - 1;//两种计算方式都可以
					if(threadID==threadCount){endIndex=length;}
					System.out.println(threadID+" download "+startIndex+" to "+endIndex);
					new DownLoadThread(threadID, startIndex, endIndex, path).start();
				}
				//threadPool.shutdown();
			}
			else{
				System.out.println("路径不正确或网络异常");
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	private static class DownLoadThread extends Thread{
		private int threadID;
		private int startIndex;
		private int endIndex;
		private String path;
		
		public DownLoadThread(int threadID, int startIndex, int endIndex,
				String path) {
			super();
			this.threadID = threadID;
			this.startIndex = startIndex;
			this.endIndex = endIndex;
			this.path = path;
		}

		@Override
		public void run() {
			try {
				File f = new File(threadID+".txt");
				if(f.exists()){
					FileInputStream fis = new FileInputStream(f);
					byte [] temp = new byte[1024];
					int leng = fis.read(temp);
					startIndex = Integer.parseInt(new String(temp,0,leng));
					fis.close();
				}
				System.out.println(threadID+" 真实下载 "+startIndex+" - " +endIndex);
				//System.out.println(threadID+" 开始链接");
				// TODO Auto-generated method stub
				URL url = new URL(path);
				HttpURLConnection conn = (HttpURLConnection) url.openConnection();
				conn.setConnectTimeout(4555);
				conn.setRequestMethod("GET");
				//重要参数，设置下载部分资源文件的起始位置
				conn.setRequestProperty("Range", "bytes="+startIndex+"-"+endIndex);
				int code = conn.getResponseCode();
				System.out.println(code);
				if(206==code){
					System.out.println(threadID+" 开始下载");
					InputStream is = conn.getInputStream();
					RandomAccessFile raf = new RandomAccessFile("everthing.exe", "rw");
					raf.seek(startIndex);//定位文件
					File file = new File(threadID+".txt");
					int len = 0;
					byte [] buffer = new byte[1024];
					long total = 0;	//此次下载的数据量
					while((len = is.read(buffer))!=-1){
						FileOutputStream fos = new FileOutputStream(file);
						raf.write(buffer, 0, len);
						total += len;
						fos.flush();
						fos.write(String.valueOf(total+startIndex).getBytes());//记录下载到的位置
					}
					is.close();
					raf.close();
					System.out.println(threadID+" 下载完毕");
				}
				File deleteFile = new File(threadID+".txt");
				deleteFile.delete();//下载完毕后清除文件,其实应该在文件完全下载完毕才将文件删除
			}  catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		
	}
}
