package com.wyyfl.calendarnotepad.service;

import java.sql.SQLException;

import com.wyyfl.calendarnotepad.vo.Date;

public class NoteManager extends AbstractNoteManager {

	@Override
	public void loadNote(Date[][] dates) {//���������б�����ݲ�����ռǵ���������
		// TODO Auto-generated method stub
		notes.clear();
		dao.connect();
		for (int i = 0; i < dates.length; i++) {
			for (int j = 0; j < dates[i].length; j++) {
				String  noteContent = null;
				try {
					noteContent = dao.find(dates[i][j]);
					if(noteContent!=null){//ֻ�����ռ�����ʱ����ӵ�������
						notes.put(dates[i][j],noteContent);
					}
				} catch (SQLException e) {
					// TODO �Զ����ɵ� catch ��
					e.printStackTrace();
				}
				
			}
		}
		dao.close();
	}

	@Override
	public void saveNote(Date date, String noteContent) {//�����ļ�
		// TODO Auto-generated method stub
		// ��Ϊ�գ���Ϊɾ����
		if (noteContent == null) {
			return;
		}
		try {
			noteContent = noteContent.trim();// ȥ�����˵Ŀո�
			dao.connect();
			String oldNoteContent = dao.find(date);// ��û����������ռ�����
			if ("".equals(noteContent))// �ж��Ƿ�Ϊ���ַ���
			{
				if (oldNoteContent != null) {// ���ԭ�����ռ����ݣ���ɾ��
					deleteNote(date);
				}
			} else// ���noteContent������
			{
				// ��Ҫ�ж��Ǹ��»����½�
				if (null == oldNoteContent) {// ԭ����һ����û���ռǵģ����½�
					dao.create(date, noteContent);
				} else if (!oldNoteContent.equals(noteContent)) {// �����һ��ԭ�����ռǣ������ݷ����˸ı䣬����£��������κβ���
					dao.update(date, noteContent);
				}
				// ͬʱ���µ�����������
				notes.put(date, noteContent);

			}
		} catch (SQLException e) {
			// TODO �Զ����ɵ� catch ��
			e.printStackTrace();
		} finally {
			dao.close();
		}
	}

	@Override
	public void deleteNote(Date date)  {
		// TODO Auto-generated method stub
		try {
			dao.connect();
			dao.delete(date);
			dao.close();
		} catch (SQLException e) {
			// TODO �Զ����ɵ� catch ��
			e.printStackTrace();
		}

	}

}
