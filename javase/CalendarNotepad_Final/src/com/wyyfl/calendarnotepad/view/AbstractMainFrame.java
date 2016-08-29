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
 * 日历记事本可视框架类
 * @author Agrin
 * @version 1.0
 */
public abstract class AbstractMainFrame extends JFrame{
	private static final long serialVersionUID = 1L;
	/**
	 * 日历列表显示天数
	 */
	public static final int DAYS = 42;
	
	public static final String INPUT_YEAR_INFO = "年份框输入年份";
	public static final String INPUT_MONTH_INFO = "月份框输入月份";
	
	/**
	 * 当前激活的日期
	 */
	protected Date date;
	//当前激活的按钮
	protected AbstractDayButton currentDayBtn = new DayButton(this);

	
	/**
	 * 业务层的日历管理对象
	 */
	protected AbstractCalendarManager calendarManager = new CalendarManager();
	/**
	 * 业务层的日记管理对象
	 */
	protected AbstractNoteManager noteManager = new NoteManager();
	
	/**
	 * 组件容器
	 */
	protected JPanel left_top ,left_center,left_bottm,right_top,right_center,right_bottm;
//	protected JPanel left;
	protected JPanel left,right;
	
	/**
	 * Frame框架容器
	 */
	protected Container c ;
	
	/**
	 * 日历控制按钮
	 */
	protected AbstractButton previousYearButton = new ControlButton("<");
	protected AbstractButton nextYearButton = new ControlButton(">");
	protected AbstractButton previousMonthButton = new ControlButton("<");
	protected AbstractButton nextMonthButton = new ControlButton(">");
	protected AbstractButton saveButton = new ControlButton("保存");
	protected AbstractButton deleteButton = new ControlButton("删除");
	/**
	 * 年份文本框
	 */
	protected JTextField yearTextField = new JTextField("",5);
	/**
	 * 月份文本框
	 */
	protected JTextField monthTextField = new JTextField("",5);
	
	/**
	 * 日历列表,DayButton设置为42个
	 */
	protected AbstractDayButton [] dayButtons = new DayButton[DAYS];
	
	/**
	 * 日记文本框
	 */
	protected JTextArea noteTextArea = new JTextArea(15, 13);
	
	/**
	 * 左下方提示信息文本区
	 */
	protected JLabel infoJLabel = new JLabel("Message",10);

	/**
	 * 日记标题区，主要显示当前激活的日期
	 */
	protected JLabel noteTitle = new JLabel("",10);
	
	public AbstractMainFrame(String title) {
		// TODO Auto-generated constructor stub
	}

	public AbstractMainFrame() {
		// TODO Auto-generated constructor stub
	}

	/**
	 * 获取当前激活的年份
	 * @return 当前激活的年份
	 */
	public int getYear() {
		return Integer.parseInt(yearTextField.getText());
	}
	
	/**
	 * 获取当前激活的月份
	 * @return 当前激活的月份
	 */
	public int getMonth() {
		return Integer.parseInt(monthTextField.getText());
	}

	/**
	 * 获取日记标题文本区
	 * @return 标题文本区
	 */
	public JLabel getNoteTitleLabel() {
		return noteTitle;
	}

	/**
	 * 获取当前日记文本框
	 * @return 日记文本框
	 */
	public JTextArea getNoteTextArea() {
		return noteTextArea;
	}

	/**
	 * 设置当前激活的日期，该设置不会更新任何文本框
	 * @param date 要激活的日记
	 */
	public void setDate(Date date) {
		this.date = date;
	}
	/**
	 * 設置當前激活的按鈕
	 */
	public abstract void setCurrentBtn();
	/**
	 * 设置当前年份，newYear会被更新到年份文本框
	 * @param newYear
	 */
	public abstract void setYear(int newYear);
	
	/**
	 * 设置当前月份，newMonth会被更新到月份文本框
	 * @param newMonth
	 */
	public abstract void setMonth(int newMonth);
	
	/**
	 * 初始化图形容器
	 */
	public abstract void initContainer();
	
	/**
	 * 向容器中添加可视组件
	 */
	public abstract void launchComponent();
	
	/**
	 * 为组件初始化监听者
	 */
	public abstract void initListener();
	
	/**
	 * 刷新日历列表
	 */
	public abstract void refreshDayButons();
}
