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
			// ��ԭ����İ��o��ԭ
			// ��ťʱ��������
			frame.getNoteTitleLabel().setText(date.toString());
			// ���µ�ǰ�����date
			frame.setDate(date);
			// ���ռ�����д���ı���
			if (noteContent != null) {
				frame.getNoteTextArea().setText(noteContent);
			} else {
				frame.getNoteTextArea().setText("");
			}
			// �Ǳ��µİ�ť��ˢ��
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
