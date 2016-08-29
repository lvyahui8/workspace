package com.yahui.test;

import java.io.File;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.ArrayList;
import java.util.List;

import android.test.AndroidTestCase;
import android.util.Log;

import com.yahui.domain.Person;
import com.yahui.domain.PersonService;

public class PersonServiceTest extends AndroidTestCase{
	private static final String TAG = "PersonServiceTest";

	public void testPersons() throws Exception{
			
		InputStream xml = this.getClass().getClassLoader().getResourceAsStream("NewFile.xml");
		List<Person> persons = PersonService.getPersons(xml);
		for(Person p : persons){
			Log.i(TAG, p.toString());
		}
	}
	public void testSave() throws Exception{
		List<Person> persons = new ArrayList<Person>();
		persons.add(new Person(34,"ghf","45"));
		persons.add(new Person(33,"rtyf","44"));
		persons.add(new Person(36,"ashf","48"));
		File xmlFile = new File(getContext().getFilesDir(),"persons.xml");
		OutputStream osp = new FileOutputStream(xmlFile);
		PersonService.save(persons, osp);
	}
	
}
