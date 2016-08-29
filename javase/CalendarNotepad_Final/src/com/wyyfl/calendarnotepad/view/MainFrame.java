package com.wyyfl.calendarnotepad.view;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

import com.wyyfl.calendarnotepad.view.component.DayButton;
import com.wyyfl.calendarnotepad.vo.Date;

public class MainFrame extends AbstractMainFrame {
	private static final long serialVersionUID = 1L;

	//定义两个字体常量
	public static final Font biggerFont = new Font("SansSerif", 1, 15);
	public static final Font originalFont=new Font("Dialog", 2, 15);
	
	String oldNoteContent = null;

	@Override
	public void setYear(int newYear) {
		// TODO Auto-generated method stub
		// 设置文本框的年，实现类型转换
		super.yearTextField.setText(String.valueOf(newYear));
	}

	@Override
	public void setMonth(int newMonth) {
		// TODO Auto-generated method stub
		if (1 <= newMonth && newMonth <= 12) {
			// 设置文本框的月，实现类型转换
			super.monthTextField.setText(String.valueOf(newMonth));
		}
	}

	// Frame初始化，设置文本框的年月
	public MainFrame() {
		super();
		// TODO Auto-generated constructor stub
		date = calendarManager.getCurrentDate();
		setYear(date.getYear());
		setMonth(date.getMonth());
		super.setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);//设置点击窗口关闭不显示
		super.addWindowListener(new CloseListener());
		super.setResizable(false);//设置大小不可调
		initContainer();
		launchComponent();
		refreshDayButons();
		setCurrentBtn();
		initListener();
		pack();
		setVisible(true);
		System.out.println(date);
	}

	@Override
	public void initContainer() {
		// TODO Auto-generated method stub
		c = super.getContentPane();
		c.setLayout(new BorderLayout(5, 5));
		// 创建左边
		left = new JPanel();
		left.setLayout(new BorderLayout(5, 5));
		// 创建右边
		right = new JPanel();
		right.setLayout(new BorderLayout(5, 5));

		// 创建左上
		left_top = new JPanel();
		left_top.setLayout(new FlowLayout(FlowLayout.LEFT, 10, 10));

		// 创建左中
		left_center = new JPanel();
		left_center.setLayout(new GridLayout(6, 7));
		// 创建左下
		left_bottm = new JPanel();
		left_bottm.setLayout(new FlowLayout(FlowLayout.LEFT, 10, 10));

		// 创建右上
		right_top = new JPanel();
		right_top.setLayout(new FlowLayout(FlowLayout.LEFT, 10, 10));
		// 创建右中
		right_center = new JPanel();
		right_center.setLayout(new BorderLayout());
		// 创建右下
		right_bottm = new JPanel();
		right_bottm.setLayout(new FlowLayout(FlowLayout.LEFT, 10, 10));

		// 左边总体整合
		left.add(left_top, "North");
		left.add(left_center, "Center");
		left.add(left_bottm, "South");

		// 右边总体整合
		right.add(right_top, "North");
		right.add(right_center, "Center");
		right.add(right_bottm, "South");
		// 整体整合
		c.add(left, "West");
		c.add(right, "East");
	}

	@Override
	public void launchComponent() {
		// TODO Auto-generated method stub
		// 左顶部布局
		left_top.add(previousYearButton);
		left_top.add(yearTextField);
		left_top.add(nextYearButton);
		left_top.add(previousMonthButton);
		left_top.add(monthTextField);
		left_top.add(nextMonthButton);
		// 左中部布局，daybuttons的界面初始化
		for (int i = 0; i < dayButtons.length; i++) {
			dayButtons[i] = new DayButton(this);
			left_center.add(dayButtons[i]);
		}
		// 左下部布局
		left_bottm.add(infoJLabel);

		// 右顶部布局
		right_top.add(noteTitle);
		// 右中部布局
		noteTextArea.setLineWrap(true);//设置自动换行
		right_center.add(noteTextArea);
		// 右下部布局
		right_bottm.add(saveButton);
		right_bottm.add(deleteButton);

	}

	// 定义按钮监听器
	class PreviousYearButtonListener implements ActionListener {
		public void actionPerformed(ActionEvent e) {
			noteManager.getNoteContent(dayButtons[1].getDate());
			setYear(getYear() - 1);
			refreshDayButons();
			setCurrentBtn();
		}
	}

	class NextYearButtonListener implements ActionListener {
		public void actionPerformed(ActionEvent e) {
			noteManager.getNoteContent(dayButtons[1].getDate());
			setYear(getYear() + 1);
			refreshDayButons();
			setCurrentBtn();
		}
	}

	class PreviousMonthButtonListener implements ActionListener {
		public void actionPerformed(ActionEvent e) {
			noteManager.getNoteContent(dayButtons[1].getDate());
			if (0 < getMonth() - 1) {
				setMonth(getMonth() - 1);
			} else {
				setMonth(12);
				setYear(getYear() - 1);
			}
			refreshDayButons();
			setCurrentBtn();
		}
	}

	class NextMonthButtonListener implements ActionListener {
		public void actionPerformed(ActionEvent e) {
			noteManager.getNoteContent(dayButtons[1].getDate());
			if (getMonth() + 1 < 13) {
				setMonth(getMonth() + 1);
			} else {
				setMonth(1);
				setYear(getYear() + 1);
			}
			refreshDayButons();
			setCurrentBtn();
		}
	}

	class SaveButtonListener implements ActionListener {
		public void actionPerformed(ActionEvent e) {
			if (noteTextArea.getText() != null) {
				noteManager.saveNote(date,
						noteTextArea.getText());
				refreshDayButons();
			}

		}
	}

	class MonthTextFieldListener implements ActionListener {
		public void actionPerformed(ActionEvent e) {
			if (Integer.valueOf(monthTextField.getText()) < 13
					&& 0 < Integer.valueOf(monthTextField.getText())) {
				date.setMonth(getMonth());
				noteTitle.setText(date.toString());
				refreshDayButons();
				setCurrentBtn();
			}
		}
	}

	class YearTextFieldListener implements ActionListener {
		public void actionPerformed(ActionEvent e) {
			if (0 < Integer.valueOf(yearTextField.getText())) {
				date.setYear(getYear());
				noteTitle.setText(date.toString());
				refreshDayButons();
				setCurrentBtn();
			}
		}
	}

	@Override
	public void initListener() {
		// TODO Auto-generated method stub
		// 按钮监听器
		previousYearButton.addActionListener(new PreviousYearButtonListener());
		nextYearButton.addActionListener(new NextYearButtonListener());
		previousMonthButton
				.addActionListener(new PreviousMonthButtonListener());
		nextMonthButton.addActionListener(new NextMonthButtonListener());
		saveButton.addActionListener(new SaveButtonListener());
		deleteButton.addActionListener(new DeleteButtonListener());
		// 文本框监听器
		yearTextField.addActionListener(new YearTextFieldListener());
		monthTextField.addActionListener(new MonthTextFieldListener());
		
	}

	public void setCurrentBtn(){
		
		for (int i = 0; i < dayButtons.length; i++) {
			if(dayButtons[i].getDate().equals(date)){
				if(null != currentDayBtn){
					currentDayBtn.setFont(MainFrame.originalFont);
					//重設激活按鈕
					currentDayBtn = dayButtons[i];	

					//設置激活按鈕字體
					currentDayBtn.setFont(MainFrame.biggerFont);
					noteTitle.setText(currentDayBtn.getDate().toString());
					noteTextArea.setText(currentDayBtn.getNote());
					
					oldNoteContent = currentDayBtn.getNote();//将日记内容先保存
				}
			}
			else{
				dayButtons[i].setFont(MainFrame.originalFont);		
			}
		}
	}
	@Override
	public void refreshDayButons() {
		// TODO Auto-generated method stub
//		激活的变大
		System.out.println(date.getDay() + "\nRefres");
		Date dates[][] = calendarManager.getDates(super.getYear(),
				super.getMonth());
		noteManager.loadNote(dates);
		int currentBtn = 0; 
		// 二重循环把业务层的日历数据获取依次放入42个按钮中
		for (int i = 0; i < 3; i++) {
			Color c;
			if (i == 0 || 2 == i) {
				// 上月和下月显示灰色
				c = Color.gray;
			} else {
				// 当月显示白色
				c = Color.white;
			}

			for (int j = 0; j < dates[i].length; j++) {
				dayButtons[currentBtn].setDate(dates[i][j]);
				String noteContent = noteManager.getNoteContent(dates[i][j]);
				dayButtons[currentBtn].setNoteContent(null);//先清理掉原来的日志内容
				if (noteContent != null) {
					// 有文字记载的显示红色
					dayButtons[currentBtn].setNoteContent(noteContent);//将日记内容给DayButton
					dayButtons[currentBtn].setBackground(Color.red);
				} else {
					dayButtons[currentBtn].setBackground(c);
				}
				dayButtons[currentBtn].setText("" + dates[i][j].getDay());
				currentBtn++;
			}
		}
	}

	class DeleteButtonListener implements ActionListener {
		public void actionPerformed(ActionEvent e) {
			noteManager.deleteNote(date);
			noteTextArea.setText("");
			refreshDayButons();
		}
	}

	
	class CloseListener extends WindowAdapter{

		@Override
		public void windowClosing(WindowEvent e) {
			//判断内容是否有改变
			
			String newNoteContent = noteTextArea.getText();
			if(newNoteContent!= null && !"".equals(newNoteContent)){//当前内容非空
				if(!newNoteContent.equals(oldNoteContent)){//如果日记内容改变
					showMessage(newNoteContent);
				}
				else{
					System.exit(0);
				}
			}
			else{
				if(oldNoteContent != null){
					showMessage(newNoteContent);
				}
				else{
					System.exit(0);
				}
			}
		}


		private void showMessage(String newNoteContent) {
			int res = JOptionPane.showConfirmDialog(null, "日志内容已改变，是否保存");
			if(JOptionPane.CANCEL_OPTION != res){
				if(JOptionPane.YES_OPTION == res){
					noteManager.saveNote(date, newNoteContent);
					JOptionPane.showMessageDialog(null, "保存成功");
				}
				System.exit(0);
			}
			else{
System.out.println("选择了取消");
				return;
			}
		}
		
	}
}
