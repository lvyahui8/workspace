package com.meybosoft.microerp.business;
/**
 * ϵͳ���󣬸ô��������ڱ�ʾϵͳ���й�����һЩ���ɿ��򲻿�Ԥ֪����������ɵĳ����쳣��
 * �����쳣���߼�����ͬ�������ڴ��������ԭ����ɵģ������ص���Ϊ��־������
 * @author ëΰ
 * @company meybosoft.com
 */
public class SystemException extends RuntimeException {
public SystemException()
{
	super("����ϵͳ������");
}
public SystemException(String msg)
{	
	super(msg);
}
public SystemException(String msg,java.lang.Throwable trw)
{
	super(msg,trw);
}
}
