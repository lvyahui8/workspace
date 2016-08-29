package jb.sendinfo;

import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;

import org.xmlpull.v1.XmlPullParser;

import android.util.Xml;

public class PhoneService {
	public static List<String> getAllPhones(InputStream xml) throws Exception{
		XmlPullParser pullParser = Xml.newPullParser();
		List<String> allPhones = null;
		pullParser.setInput(xml, "UTF-8");
		int event = pullParser.getEventType();
		while(event != XmlPullParser.END_DOCUMENT){
			switch (event) {
			case XmlPullParser.START_DOCUMENT:
				allPhones = new ArrayList<String>();
				break;
			case XmlPullParser.START_TAG:
				String tagName = pullParser.getName();
				if("phone".equals(tagName)){
					allPhones.add(pullParser.nextText());
				}
				break;
			default:
				break;
			}
			
			event = pullParser.next();
		}
		return allPhones;
		
	}
}
