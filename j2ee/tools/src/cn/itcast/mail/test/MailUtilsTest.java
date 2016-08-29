package cn.itcast.mail.test;

import java.io.IOException;

import javax.mail.MessagingException;
import javax.mail.Session;

import org.junit.Test;

import cn.itcast.mail.Mail;
import cn.itcast.mail.MailUtils;

/**
 * 测试MailUtils,作用是发邮件
 * jar:mail.jar,activation.jar
 * @author admin
 *
 */
public class MailUtilsTest {
	/**
	 * 发邮件
	 * @throws IOException 
	 * @throws MessagingException 
	 */
	@Test
	public void testSend() throws MessagingException, IOException{
		/*
		 * 1.登陆邮件服务器
		 * 		MailUtils.createSession(服务器地址，登陆名，密码);
		 * 2.创建邮件对象
		 * 		发件人
		 * 		收件人
		 * 		主题
		 * 		正文
		 * 3.发
		 * 		需要第一步得到的session，和第二步的邮件对象
		 */
		
		Session session = MailUtils.createSession("smtp.163.com", "lvyahui6", "<2dj:forever>");
		Mail mail = new Mail("lvyahui6@163.com","1257069082@qq.com","测试邮件","邮件正文");
		
		MailUtils.send(session, mail);
	}
}
