package jms.net;

import javax.jms.*;
import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import java.util.Hashtable;

/**
 * Created by lvyahui on 2016/4/23.
 */
public class MsgReader {
    public void read() throws NamingException, JMSException {

        Hashtable table = new Hashtable();
        table.put(Context.INITIAL_CONTEXT_FACTORY, MsgServer.INIT_FACTORY_CLASS);
        table.put(Context.PROVIDER_URL,MsgServer.URL);
        /*JNDI ，需要得到上下文*/
        Context context = new InitialContext(table);


        /*需要 administrator objs (受管对象)*/
        QueueConnectionFactory factory = null;

        factory = (QueueConnectionFactory) context.lookup(MsgServer.CONN_FACTORY_JNDI_NAME);

        Queue queue = (Queue) context.lookup(MsgServer.QUEUE_JNDI_NAME);


        QueueConnection conn = factory.createQueueConnection();

        QueueSession session = conn.createQueueSession(false/*发送消息是否确认*/, Session.AUTO_ACKNOWLEDGE);

        QueueReceiver receiver = session.createReceiver(queue);

        /* 跟发送消息不太一样，需要启动连接*/
        conn.start();

        /* 接收消息 */
        TextMessage textMessage = (TextMessage) receiver.receive();
        System.out.println(textMessage);
    }
}
