package com.meybosoft.microerp.business;
/**
 * 系统错误，该错误主用于表示系统运行过程中一些不可抗或不可预知的因素所造成的程序异常！
 * 这种异常跟逻辑错误不同，是由于代码以外的原因造成的，所以重点作为日志来处理。
 * @author 毛伟
 * @company meybosoft.com
 */
public class SystemException extends RuntimeException {
public SystemException()
{
	super("出现系统级错误！");
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
