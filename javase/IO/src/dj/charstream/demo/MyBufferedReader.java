package dj.charstream.demo;

import java.io.IOException;
import java.io.Reader;
/*
 * 缓冲区的原理
 * 缓冲区其实就是封装了一个足够大的数组
 * 从源中获取一批数据放进数组中
 * 让后从数组中一个一个的取数据
 * 当数组中的数据取完，就到源中再取一批。
 * 如此反复，直到源读取完毕
 */
public class MyBufferedReader extends Reader{
//	private static final String LINE_SEPARATOR = System.getProperty("line.separator");
	private Reader r = null;
	private char [] buffer = new char[1024];
	private int pos = 0;
	private int count = 0;
	
	MyBufferedReader(Reader r){
		this.r = r;
	}
	public int myRead() throws IOException{
		if(count <= 0){
			count = this.r.read(buffer);
			if(-1 == count) return -1;//源读完了
			pos = 0;
		}
		count--;
		return buffer[pos++];
	}
	public String myReadLine() throws IOException{
		StringBuilder sb = new StringBuilder();
		int ch = 0;
//		while((ch = myRead())!=-1 && !(new StringBuffer((char)ch).equals(LINE_SEPARATOR))){
		while((ch = myRead())!=-1){
			if ('\r' == ch) {
				continue;
			}
			else if ('\n' == ch){
				break;
			}
			sb.append((char)ch);
		}
		String result = sb.toString();
		return result.equals("") ? null : result;
	}
	public void myClose() throws IOException{
		this.r.close();
	}
	@Override
	public int read(char[] cbuf, int off, int len) throws IOException {
		// TODO 自动生成的方法存根
		return 0;
	}
	@Override
	public void close() throws IOException {
		// TODO 自动生成的方法存根
		
	}
}
