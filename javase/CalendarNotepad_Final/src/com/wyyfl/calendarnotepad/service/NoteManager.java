package com.wyyfl.calendarnotepad.service;

import java.sql.SQLException;

import com.wyyfl.calendarnotepad.vo.Date;

public class NoteManager extends AbstractNoteManager {

	@Override
	public void loadNote(Date[][] dates) {//根据日历列表从数据层加载日记到缓冲容器
		// TODO Auto-generated method stub
		notes.clear();
		dao.connect();
		for (int i = 0; i < dates.length; i++) {
			for (int j = 0; j < dates[i].length; j++) {
				String  noteContent = null;
				try {
					noteContent = dao.find(dates[i][j]);
					if(noteContent!=null){//只有有日记内容时才添加到集合中
						notes.put(dates[i][j],noteContent);
					}
				} catch (SQLException e) {
					// TODO 自动生成的 catch 块
					e.printStackTrace();
				}
				
			}
		}
		dao.close();
	}

	@Override
	public void saveNote(Date date, String noteContent) {//保存文件
		// TODO Auto-generated method stub
		// 若为空，则为删除了
		if (noteContent == null) {
			return;
		}
		try {
			noteContent = noteContent.trim();// 去掉两端的空格
			dao.connect();
			String oldNoteContent = dao.find(date);// 获得缓存容器的日记内容
			if ("".equals(noteContent))// 判断是否为空字符串
			{
				if (oldNoteContent != null) {// 如果原来有日记内容，才删除
					deleteNote(date);
				}
			} else// 如果noteContent有内容
			{
				// 还要判断是更新还是新建
				if (null == oldNoteContent) {// 原来这一天是没有日记的，则新建
					dao.create(date, noteContent);
				} else if (!oldNoteContent.equals(noteContent)) {// 如果这一天原本有日记，但内容发生了改变，则更新，否则不做任何操作
					dao.update(date, noteContent);
				}
				// 同时更新到缓存容器里
				notes.put(date, noteContent);

			}
		} catch (SQLException e) {
			// TODO 自动生成的 catch 块
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
			// TODO 自动生成的 catch 块
			e.printStackTrace();
		}

	}

}
