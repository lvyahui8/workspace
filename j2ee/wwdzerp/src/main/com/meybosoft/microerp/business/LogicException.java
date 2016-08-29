package com.meybosoft.microerp.business;

/**
 * 用来给客户端返回所有逻辑异常信息，客户端通过这些逻辑错误信息，可以得到具体的程序逻辑错误.
 * 该异常是一个运行时异常，因此不需要在java代码中强制检查该异常，一般交由框架来处理异常！
 * @author 蔡世友
 * @company meybosoft.com
 */
public class LogicException extends RuntimeException {
	public LogicException() {
		super("系统出现逻辑错误！");
	}

	public LogicException(String msg) {
		super(msg);
	}

	public LogicException(String msg, java.lang.Throwable trw) {
		super(msg, trw);
	}
}
