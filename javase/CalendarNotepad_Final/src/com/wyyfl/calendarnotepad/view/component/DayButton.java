package com.wyyfl.calendarnotepad.view.component;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import com.wyyfl.calendarnotepad.view.AbstractMainFrame;

public class DayButton extends AbstractDayButton {
	private static final long serialVersionUID = 1L;

	public DayButton(AbstractMainFrame frame) {
		super();
		// TODO Auto-generated constructor stub
		super.frame = frame;
	}
	
	class DayButtonsListener implements ActionListener {
		public void actionPerformed(ActionEvent e) {
			// 將原來激活的按鈕復原
			// 按钮时间放入标题
			frame.getNoteTitleLabel().setText(date.toString());
			// 更新当前激活的date
			frame.setDate(date);
			// 将日记内容写入文本框
			if (noteContent != null) {
				frame.getNoteTextArea().setText(noteContent);
			} else {
				frame.getNoteTextArea().setText("");
			}
			// 非本月的按钮则刷新
			if (date.getMonth() != frame.getMonth()) {
				frame.setYear(date.getYear());
				frame.setMonth(date.getMonth());
				frame.refreshDayButons();
			}
			frame.setCurrentBtn();
		}
	}

	{
		super.addActionListener(new DayButtonsListener());
	}
}
