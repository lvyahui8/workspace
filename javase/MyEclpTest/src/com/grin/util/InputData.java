package com.grin.util;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.sql.Date;
import java.text.ParseException;
import java.text.SimpleDateFormat;

public class InputData {
	private BufferedReader buf = null;
	
	public InputData() {
		this.buf = new BufferedReader(new InputStreamReader(System.in));
	}

	public String getString(String info) {
		String str = null;
		System.out.print(info);
		try {
			str = this.buf.readLine();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return str;
	}

	public Date getDate(String info, String err) {
		Date date = null;
		boolean flag = true;
		while (flag) {
			String str = this.getString(info);
			if(str.matches("\\d{4}-\\d{2}-\\d{2}")){
				try {
					date = new Date(new SimpleDateFormat("yyyy-mm-dd").parse(str).getTime());
					flag = false;
				} catch (ParseException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
			else{
				System.out.println(err);
			}
		}
		return date;
	}

	public int getInt(String info, String err) {
		int i=0;
		boolean flag = true;
		while (flag) {
			String str = this.getString(info);
			if(str.matches("\\d+")){
				i = Integer.parseInt(str);
				flag = false;
			}
			else{
				System.out.println(err);
			}
		}
		return i;
	}

}
