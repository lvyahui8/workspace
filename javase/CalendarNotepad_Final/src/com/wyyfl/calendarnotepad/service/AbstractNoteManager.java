package com.wyyfl.calendarnotepad.service;

import java.util.HashMap;
import java.util.Map;

import com.wyyfl.calendarnotepad.dao.INoteDAOProxy;
import com.wyyfl.calendarnotepad.dao.NoteDAOProxy;
import com.wyyfl.calendarnotepad.vo.Date;

/**
 * �ռǹ�����
 * @author Agrin
 * @version 1.0
 */
public abstract class AbstractNoteManager {
	/**
	 * ���������ռǵ�����
	 */
	protected Map<Date,String> notes = new HashMap<Date, String>();
	/**
	 * ���ݲ�����ݷ��ʴ�����
	 */
	protected INoteDAOProxy dao = new NoteDAOProxy();
	
	/**
	 * ���������б�����ݲ�����ռǵ���������
	 * @param dates �����б��е����ڣ�ʹ�ö�ά��������Ϊÿ�β�ѯ����3���µ����ڣ�Ҫ����3�еĶ�ά����
	 */
	public abstract void loadNote(Date [][] dates);
	
	/**
	 * �ӻ������л�ȡ�������ڵ��ռ���������
	 * @param date ��������
	 * @return �ռ����ģ���������ڻ᷵�� null
	 */
	public String getNoteContent(Date date) {
		return notes.get(date);
	}

	/**
	 * �����ռǣ�ҵ���Ӧ����������������жϱ������ͣ��Ǹ��£������½�������ɾ�������ڶ�������Ϊ����ʱ����
	 * ͬʱ���»�������
	 * @param date ����
	 * @param noteContent �ռ�����
	 */
	public abstract void saveNote(Date date, String noteContent) ;

	/**
	 * �ڵ������ݲ㷽��ɾ����������ָ�����ռǣ�ͬʱ���»�������
	 * @param date ��������
	 */
	public abstract void deleteNote(Date date) ;
}
