package com.wyyfl.calendarnotepad.service;

import java.util.HashMap;
import java.util.Map;

import com.wyyfl.calendarnotepad.dao.INoteDAOProxy;
import com.wyyfl.calendarnotepad.dao.NoteDAOProxy;
import com.wyyfl.calendarnotepad.vo.Date;

/**
 * 日记管理者
 * @author Agrin
 * @version 1.0
 */
public abstract class AbstractNoteManager {
	/**
	 * 用来缓存日记的容器
	 */
	protected Map<Date,String> notes = new HashMap<Date, String>();
	/**
	 * 数据层的数据访问代理类
	 */
	protected INoteDAOProxy dao = new NoteDAOProxy();
	
	/**
	 * 根据日历列表从数据层加载日记到缓冲容器
	 * @param dates 日历列表中的日期，使用二维数组是因为每次查询会有3个月的日期，要求是3行的二维数组
	 */
	public abstract void loadNote(Date [][] dates);
	
	/**
	 * 从缓冲区中获取给定日期的日记正文内容
	 * @param date 给定日期
	 * @return 日记正文，如果不存在会返回 null
	 */
	public String getNoteContent(Date date) {
		return notes.get(date);
	}

	/**
	 * 保存日记，业务层应该在这个方法里面判断保存类型，是更新，还是新建，还是删除（但第二个参数为“”时）。
	 * 同时更新缓冲容器
	 * @param date 日期
	 * @param noteContent 日记正文
	 */
	public abstract void saveNote(Date date, String noteContent) ;

	/**
	 * 在调用数据层方法删除给定日期指定的日记，同时更新缓冲容器
	 * @param date 给定日期
	 */
	public abstract void deleteNote(Date date) ;
}
