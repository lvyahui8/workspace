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

	//�����������峣��
	public static final Font biggerFont = new Font("SansSerif", 1, 15);
	public static final Font originalFont=new Font("Dialog", 2, 15);
	
	String oldNoteContent = null;

	@Override
	public void setYear(int newYear) {
		// TODO Auto-generated method stub
		// �����ı�����꣬ʵ������ת��
		super.yearTextField.setText(String.valueOf(newYear));
	}

	@Override
	public void setMonth(int newMonth) {
		// TODO Auto-generated method stub
		if (1 <= newMonth && newMonth <= 12) {
			// �����ı�����£�ʵ������ת��
			super.monthTextField.setText(String.valueOf(newMonth));
		}
	}

	// Frame��ʼ���������ı��������
	public MainFrame() {
		super();
		// TODO Auto-generated constructor stub
		date = calendarManager.getCurrentDate();
		setYear(date.getYear());
		setMonth(date.getMonth());
		super.setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);//���õ�����ڹرղ���ʾ
		super.addWindowListener(new CloseListener());
		super.setResizable(false);//���ô�С���ɵ�
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
		// �������
		left = new JPanel();
		left.setLayout(new BorderLayout(5, 5));
		// �����ұ�
		right = new JPanel();
		right.setLayout(new BorderLayout(5, 5));

		// ��������
		left_top = new JPanel();
		left_top.setLayout(new FlowLayout(FlowLayout.LEFT, 10, 10));

		// ��������
		left_center = new JPanel();
		left_center.setLayout(new GridLayout(6, 7));
		// ��������
		left_bottm = new JPanel();
		left_bottm.setLayout(new FlowLayout(FlowLayout.LEFT, 10, 10));

		// ��������
		right_top = new JPanel();
		right_top.setLayout(new FlowLayout(FlowLayout.LEFT, 10, 10));
		// ��������
		right_center = new JPanel();
		right_center.setLayout(new BorderLayout());
		// ��������
		right_bottm = new JPanel();
		right_bottm.setLayout(new FlowLayout(FlowLayout.LEFT, 10, 10));

		// �����������
		left.add(left_top, "North");
		left.add(left_center, "Center");
		left.add(left_bottm, "South");

		// �ұ���������
		right.add(right_top, "North");
		right.add(right_center, "Center");
		right.add(right_bottm, "South");
		// ��������
		c.add(left, "West");
		c.add(right, "East");
	}

	@Override
	public void launchComponent() {
		// TODO Auto-generated method stub
		// �󶥲�����
		left_top.add(previousYearButton);
		left_top.add(yearTextField);
		left_top.add(nextYearButton);
		left_top.add(previousMonthButton);
		left_top.add(monthTextField);
		left_top.add(nextMonthButton);
		// ���в����֣�daybuttons�Ľ����ʼ��
		for (int i = 0; i < dayButtons.length; i++) {
			dayButtons[i] = new DayButton(this);
			left_center.add(dayButtons[i]);
		}
		// ���²�����
		left_bottm.add(infoJLabel);

		// �Ҷ�������
		right_top.add(noteTitle);
		// ���в�����
		noteTextArea.setLineWrap(true);//�����Զ�����
		right_center.add(noteTextArea);
		// ���²�����
		right_bottm.add(saveButton);
		right_bottm.add(deleteButton);

	}

	// ���尴ť������
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
		// ��ť������
		previousYearButton.addActionListener(new PreviousYearButtonListener());
		nextYearButton.addActionListener(new NextYearButtonListener());
		previousMonthButton
				.addActionListener(new PreviousMonthButtonListener());
		nextMonthButton.addActionListener(new NextMonthButtonListener());
		saveButton.addActionListener(new SaveButtonListener());
		deleteButton.addActionListener(new DeleteButtonListener());
		// �ı��������
		yearTextField.addActionListener(new YearTextFieldListener());
		monthTextField.addActionListener(new MonthTextFieldListener());
		
	}

	public void setCurrentBtn(){
		
		for (int i = 0; i < dayButtons.length; i++) {
			if(dayButtons[i].getDate().equals(date)){
				if(null != currentDayBtn){
					currentDayBtn.setFont(MainFrame.originalFont);
					//���O����o
					currentDayBtn = dayButtons[i];	

					//�O�ü���o���w
					currentDayBtn.setFont(MainFrame.biggerFont);
					noteTitle.setText(currentDayBtn.getDate().toString());
					noteTextArea.setText(currentDayBtn.getNote());
					
					oldNoteContent = currentDayBtn.getNote();//���ռ������ȱ���
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
//		����ı��
		System.out.println(date.getDay() + "\nRefres");
		Date dates[][] = calendarManager.getDates(super.getYear(),
				super.getMonth());
		noteManager.loadNote(dates);
		int currentBtn = 0; 
		// ����ѭ����ҵ�����������ݻ�ȡ���η���42����ť��
		for (int i = 0; i < 3; i++) {
			Color c;
			if (i == 0 || 2 == i) {
				// ���º�������ʾ��ɫ
				c = Color.gray;
			} else {
				// ������ʾ��ɫ
				c = Color.white;
			}

			for (int j = 0; j < dates[i].length; j++) {
				dayButtons[currentBtn].setDate(dates[i][j]);
				String noteContent = noteManager.getNoteContent(dates[i][j]);
				dayButtons[currentBtn].setNoteContent(null);//�������ԭ������־����
				if (noteContent != null) {
					// �����ּ��ص���ʾ��ɫ
					dayButtons[currentBtn].setNoteContent(noteContent);//���ռ����ݸ�DayButton
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
			//�ж������Ƿ��иı�
			
			String newNoteContent = noteTextArea.getText();
			if(newNoteContent!= null && !"".equals(newNoteContent)){//��ǰ���ݷǿ�
				if(!newNoteContent.equals(oldNoteContent)){//����ռ����ݸı�
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
			int res = JOptionPane.showConfirmDialog(null, "��־�����Ѹı䣬�Ƿ񱣴�");
			if(JOptionPane.CANCEL_OPTION != res){
				if(JOptionPane.YES_OPTION == res){
					noteManager.saveNote(date, newNoteContent);
					JOptionPane.showMessageDialog(null, "����ɹ�");
				}
				System.exit(0);
			}
			else{
System.out.println("ѡ����ȡ��");
				return;
			}
		}
		
	}
}
