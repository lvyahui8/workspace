package com.meybosoft.microerp.business;

/**
 * �������ͻ��˷��������߼��쳣��Ϣ���ͻ���ͨ����Щ�߼�������Ϣ�����Եõ�����ĳ����߼�����.
 * ���쳣��һ������ʱ�쳣����˲���Ҫ��java������ǿ�Ƽ����쳣��һ�㽻�ɿ���������쳣��
 * @author ������
 * @company meybosoft.com
 */
public class LogicException extends RuntimeException {
	public LogicException() {
		super("ϵͳ�����߼�����");
	}

	public LogicException(String msg) {
		super(msg);
	}

	public LogicException(String msg, java.lang.Throwable trw) {
		super(msg, trw);
	}
}
