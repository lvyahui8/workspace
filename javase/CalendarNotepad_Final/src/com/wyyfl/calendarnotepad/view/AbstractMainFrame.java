package com.wyyfl.calendarnotepad.view;

import java.awt.Container;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.JTextField;

import com.wyyfl.calendarnotepad.service.AbstractCalendarManager;
import com.wyyfl.calendarnotepad.service.AbstractNoteManager;
import com.wyyfl.calendarnotepad.service.CalendarManager;
import com.wyyfl.calendarnotepad.service.NoteManager;
import com.wyyfl.calendarnotepad.view.component.AbstractButton;
import com.wyyfl.calendarnotepad.view.component.AbstractDayButton;
import com.wyyfl.calendarnotepad.view.component.ControlButton;
import com.wyyfl.calendarnotepad.view.component.DayButton;
import com.wyyfl.calendarnotepad.vo.Date;

/**
 * �������±����ӿ����
 * @author Agrin
 * @version 1.0
 */
public abstract class AbstractMainFrame extends JFrame{
	private static final long serialVersionUID = 1L;
	/**
	 * �����б���ʾ����
	 */
	public static final int DAYS = 42;
	
	public static final String INPUT_YEAR_INFO = "��ݿ��������";
	public static final String INPUT_MONTH_INFO = "�·ݿ������·�";
	
	/**
	 * ��ǰ���������
	 */
	protected Date date;
	//��ǰ����İ�ť
	protected AbstractDayButton currentDayBtn = new DayButton(this);

	
	/**
	 * ҵ���������������
	 */
	protected AbstractCalendarManager calendarManager = new CalendarManager();
	/**
	 * ҵ�����ռǹ������
	 */
	protected AbstractNoteManager noteManager = new NoteManager();
	
	/**
	 * �������
	 */
	protected JPanel left_top ,left_center,left_bottm,right_top,right_center,right_bottm;
//	protected JPanel left;
	protected JPanel left,right;
	
	/**
	 * Frame�������
	 */
	protected Container c ;
	
	/**
	 * �������ư�ť
	 */
	protected AbstractButton previousYearButton = new ControlButton("<");
	protected AbstractButton nextYearButton = new ControlButton(">");
	protected AbstractButton previousMonthButton = new ControlButton("<");
	protected AbstractButton nextMonthButton = new ControlButton(">");
	protected AbstractButton saveButton = new ControlButton("����");
	protected AbstractButton deleteButton = new ControlButton("ɾ��");
	/**
	 * ����ı���
	 */
	protected JTextField yearTextField = new JTextField("",5);
	/**
	 * �·��ı���
	 */
	protected JTextField monthTextField = new JTextField("",5);
	
	/**
	 * �����б�,DayButton����Ϊ42��
	 */
	protected AbstractDayButton [] dayButtons = new DayButton[DAYS];
	
	/**
	 * �ռ��ı���
	 */
	protected JTextArea noteTextArea = new JTextArea(15, 13);
	
	/**
	 * ���·���ʾ��Ϣ�ı���
	 */
	protected JLabel infoJLabel = new JLabel("Message",10);

	/**
	 * �ռǱ���������Ҫ��ʾ��ǰ���������
	 */
	protected JLabel noteTitle = new JLabel("",10);
	
	public AbstractMainFrame(String title) {
		// TODO Auto-generated constructor stub
	}

	public AbstractMainFrame() {
		// TODO Auto-generated constructor stub
	}

	/**
	 * ��ȡ��ǰ��������
	 * @return ��ǰ��������
	 */
	public int getYear() {
		return Integer.parseInt(yearTextField.getText());
	}
	
	/**
	 * ��ȡ��ǰ������·�
	 * @return ��ǰ������·�
	 */
	public int getMonth() {
		return Integer.parseInt(monthTextField.getText());
	}

	/**
	 * ��ȡ�ռǱ����ı���
	 * @return �����ı���
	 */
	public JLabel getNoteTitleLabel() {
		return noteTitle;
	}

	/**
	 * ��ȡ��ǰ�ռ��ı���
	 * @return �ռ��ı���
	 */
	public JTextArea getNoteTextArea() {
		return noteTextArea;
	}

	/**
	 * ���õ�ǰ��������ڣ������ò�������κ��ı���
	 * @param date Ҫ������ռ�
	 */
	public void setDate(Date date) {
		this.date = date;
	}
	/**
	 * �O�î�ǰ����İ��o
	 */
	public abstract void setCurrentBtn();
	/**
	 * ���õ�ǰ��ݣ�newYear�ᱻ���µ�����ı���
	 * @param newYear
	 */
	public abstract void setYear(int newYear);
	
	/**
	 * ���õ�ǰ�·ݣ�newMonth�ᱻ���µ��·��ı���
	 * @param newMonth
	 */
	public abstract void setMonth(int newMonth);
	
	/**
	 * ��ʼ��ͼ������
	 */
	public abstract void initContainer();
	
	/**
	 * ����������ӿ������
	 */
	public abstract void launchComponent();
	
	/**
	 * Ϊ�����ʼ��������
	 */
	public abstract void initListener();
	
	/**
	 * ˢ�������б�
	 */
	public abstract void refreshDayButons();
}
