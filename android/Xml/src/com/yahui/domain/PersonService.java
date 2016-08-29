package com.yahui.domain;

import java.io.InputStream;
import java.io.OutputStream;
import java.util.ArrayList;
import java.util.List;

import org.xmlpull.v1.XmlPullParser;
import org.xmlpull.v1.XmlSerializer;

import android.util.Xml;

public class PersonService {
	public static List<Person> getPersons(InputStream xml) throws Exception{
//		XmlPullParser pullParser = XmlPullParserFactory.newInstance().newPullParser();
		XmlPullParser pullParser = Xml.newPullParser();
		List<Person> persons = null;
		pullParser.setInput(xml, "UTF-8");
		int id = 0;
		String name = null;
		String age = null;
		int event = pullParser.getEventType();
		while(event != XmlPullParser.END_DOCUMENT){
			switch (event) {
			case XmlPullParser.START_DOCUMENT:
				persons = new ArrayList<Person>();
				break;
			case XmlPullParser.START_TAG:
				String tagName = pullParser.getName();
				if("person".equals(tagName)){
					id = Integer.parseInt(pullParser.getAttributeValue(0));
				}
				else if("name".equals(tagName)){
					name = pullParser.nextText();
				}
				else if("age".equals(tagName)){
					age = pullParser.nextText();
					persons.add(new Person(id,name,age));
				}
				break;
			default:
				break;
			}
			
			event = pullParser.next();
		}
		return persons;
	}
	
	
	public static void save(List<Person> persons,OutputStream out) throws Exception{
		XmlSerializer serializer = Xml.newSerializer();
		serializer.setOutput(out,"UTF-8");
		
		serializer.startDocument("UTF-8", true);
		serializer.startTag(null, "persons");
		
		for(Person p : persons){
			serializer.startTag(null, "person");
			serializer.attribute(null, "id", p.getId().toString());
			
			serializer.startTag(null, "name");
			serializer.text(p.getName());
			serializer.endTag(null, "name");
			
			serializer.startTag(null, "age");
			serializer.text(p.getAge());
			serializer.endTag(null, "age");
			
			serializer.endTag(null, "person");
		}
		
		serializer.endTag(null, "persons");
		serializer.endDocument();
	}
}
