package com.wyyfl.calendarnotepad.view.component;

import javax.swing.JButton;

import com.wyyfl.calendarnotepad.view.AbstractMainFrame;
import com.wyyfl.calendarnotepad.vo.Date;

/**
 * �����б��еİ�ť
 * @author Agrin
 * @version 1.0
 */
public abstract class AbstractDayButton extends JButton{
	private static final long serialVersionUID = 1L;
	/**
	 * �˰�ť���������
	 */
	protected Date date;
	/**
	 * �˰�ť���е��ռ�����
	 */
	protected String noteContent;

	/**
	 * �ɹ��˰�ť���ʵĿ��ӿ��
	 */
	protected AbstractMainFrame frame;

	public AbstractDayButton(String text) {
		super(text);
	}

	public AbstractDayButton() {
	}

	/**
	 * ��ȡ��ť���������
	 * @return ����
	 */
	public Date getDate() {
		return date;
	}

	/**
	 * ���ô˰�ť���������
	 * @param date ����
	 */
	public void setDate(Date date) {
		this.date = date;
	}

	/**
	 * ��ȡ��ť���е��ռ�����
	 * @return ���е��ռ�����
	 */
	public String getNoteContent() {
		return noteContent;
	}

	/**
	 * ���ð�ť���е��ռ�����
	 * @param noteContent �ռ�����
	 */
	public void setNoteContent(String noteContent) {
		this.noteContent = noteContent;
	}
	

	public String getNote(){
		return noteContent;
	}
}
