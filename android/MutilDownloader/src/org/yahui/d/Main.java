package org.yahui.d;

public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		final String uri = "http://www.voidtools.com/Everything-1.3.4.686.x86-Setup.exe";
		DownLoader downLoader = new DownLoader(uri);
		downLoader.setFileFullName("F:\\download\\everthing.exe");
		downLoader.setThreadCount(4);
		downLoader.startDownload();
	}

}
