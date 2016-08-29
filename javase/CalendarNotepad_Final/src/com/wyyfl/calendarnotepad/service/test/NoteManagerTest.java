package com.wyyfl.calendarnotepad.service.test;

import junit.framework.TestCase;

import com.wyyfl.calendarnotepad.service.NoteManager;
import com.wyyfl.calendarnotepad.vo.Date;

public class NoteManagerTest extends TestCase {

	public void testLoadNote(Date[][] Date) {
		NoteManager load = new NoteManager();
		Date[][] dates = new Date[3][];
		dates[0] = new Date[5];
		dates[1] = new Date[24];
		dates[3] = new Date[2];
		for (int i = 0; i < dates.length; i++) {
			for (int j = 0; j < dates[i].length; j++) {
				dates[i][j] = new Date();
				dates[i][j].setYear(2014);
				dates[i][j].setMonth(2);
				dates[i][j].setDay(j);
			}
		}
		load.loadNote(dates);

	}

	public void testSaveNote() {
		NoteManager save = new NoteManager();
		Date dates = new Date();
		save.saveNote(dates, "inhao");
	}

	public void testDeleteNote() {
		NoteManager delete = new NoteManager();
		Date dates = new Date();
		delete.deleteNote(dates);
	}
}