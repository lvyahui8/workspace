package com.wyyfl.calendarnotepad.view.component;

import javax.swing.JButton;

import com.wyyfl.calendarnotepad.view.AbstractMainFrame;
import com.wyyfl.calendarnotepad.vo.Date;

/**
 * 日历列表中的按钮
 * @author Agrin
 * @version 1.0
 */
public abstract class AbstractDayButton extends JButton{
	private static final long serialVersionUID = 1L;
	/**
	 * 此按钮代表的日期
	 */
	protected Date date;
	/**
	 * 此按钮持有的日记内容
	 */
	protected String noteContent;

	/**
	 * 可供此按钮访问的可视框架
	 */
	protected AbstractMainFrame frame;

	public AbstractDayButton(String text) {
		super(text);
	}

	public AbstractDayButton() {
	}

	/**
	 * 获取按钮代表的日期
	 * @return 日期
	 */
	public Date getDate() {
		return date;
	}

	/**
	 * 设置此按钮代表的日期
	 * @param date 日期
	 */
	public void setDate(Date date) {
		this.date = date;
	}

	/**
	 * 获取按钮持有的日记内容
	 * @return 持有的日记内容
	 */
	public String getNoteContent() {
		return noteContent;
	}

	/**
	 * 设置按钮持有的日记内容
	 * @param noteContent 日记内容
	 */
	public void setNoteContent(String noteContent) {
		this.noteContent = noteContent;
	}
	

	public String getNote(){
		return noteContent;
	}
}
