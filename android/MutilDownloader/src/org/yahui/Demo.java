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
		//���ӷ���������ȡһ���ļ�����ȡ�ļ��ĳ��ȣ��ڱ�������
		//����һ����ͬ��С�Ŀ��ļ�
		//http://www.voidtools.com/Everything-1.3.4.686.x86-Setup.exe
		try {
			final String path = "http://www.voidtools.com/Everything-1.3.4.686.x86-Setup.exe";
			URL url = new URL(path);
			HttpURLConnection conn = (HttpURLConnection) url.openConnection();
			conn.setConnectTimeout(4555);
			conn.setRequestMethod("GET");
			int code = conn.getResponseCode();
			if(200==code){
				//���������ص����ݣ�Ӧ���壩�ĳ��ȣ�����������ļ��Ĵ�С
				int length = conn.getContentLength();
				System.out.println("�ļ����ȣ�"+length);
				//�ڱ��ش���һ����С�Ŀ��ļ�
				RandomAccessFile raf = new RandomAccessFile("everthing.exe", "rw");
				raf.setLength(length);
				//��������3���߳̽�������
				int threadCount = 5;
				int blockSize = length / threadCount;
				
				for(int threadID=1;threadID<=threadCount;threadID++){
					int startIndex = (threadID-1)*blockSize;
//					int endIndex = threadID*blockSize-1;
					int endIndex = startIndex + blockSize - 1;//���ּ��㷽ʽ������
					if(threadID==threadCount){endIndex=length;}
					System.out.println(threadID+" download "+startIndex+" to "+endIndex);
					new DownLoadThread(threadID, startIndex, endIndex, path).start();
				}
				//threadPool.shutdown();
			}
			else{
				System.out.println("·������ȷ�������쳣");
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
				System.out.println(threadID+" ��ʵ���� "+startIndex+" - " +endIndex);
				//System.out.println(threadID+" ��ʼ����");
				// TODO Auto-generated method stub
				URL url = new URL(path);
				HttpURLConnection conn = (HttpURLConnection) url.openConnection();
				conn.setConnectTimeout(4555);
				conn.setRequestMethod("GET");
				//��Ҫ�������������ز�����Դ�ļ�����ʼλ��
				conn.setRequestProperty("Range", "bytes="+startIndex+"-"+endIndex);
				int code = conn.getResponseCode();
				System.out.println(code);
				if(206==code){
					System.out.println(threadID+" ��ʼ����");
					InputStream is = conn.getInputStream();
					RandomAccessFile raf = new RandomAccessFile("everthing.exe", "rw");
					raf.seek(startIndex);//��λ�ļ�
					File file = new File(threadID+".txt");
					int len = 0;
					byte [] buffer = new byte[1024];
					long total = 0;	//�˴����ص�������
					while((len = is.read(buffer))!=-1){
						FileOutputStream fos = new FileOutputStream(file);
						raf.write(buffer, 0, len);
						total += len;
						fos.flush();
						fos.write(String.valueOf(total+startIndex).getBytes());//��¼���ص���λ��
					}
					is.close();
					raf.close();
					System.out.println(threadID+" �������");
				}
				File deleteFile = new File(threadID+".txt");
				deleteFile.delete();//������Ϻ�����ļ�,��ʵӦ�����ļ���ȫ������ϲŽ��ļ�ɾ��
			}  catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		
	}
}
