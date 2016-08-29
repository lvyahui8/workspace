package jms.net;

import javax.jms.*;
import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import java.util.Hashtable;

/**
 * Created by lvyahui on 2016/4/23.
 */
public class MsgSender {

    public static void main(String[] args) {

    }

    public void sendMsg() throws NamingException, JMSException {

        Hashtable table = new Hashtable();
        table.put(Context.INITIAL_CONTEXT_FACTORY, MsgServer.INIT_FACTORY_CLASS);
        table.put(Context.PROVIDER_URL, MsgServer.URL);
        /*JNDI ，需要得到上下文*/
        Context context = new InitialContext(table);


        /*需要 administrator objs (受管对象)*/
        QueueConnectionFactory factory = null;

        factory = (QueueConnectionFactory) context.lookup(MsgServer.CONN_FACTORY_JNDI_NAME);

        Queue queue = (Queue) context.lookup(MsgServer.QUEUE_JNDI_NAME);

        /* 建立jms对象 */
        QueueConnection conn = factory.createQueueConnection();

        QueueSession session = conn.createQueueSession(false/*发送消息是否确认*/,Session.AUTO_ACKNOWLEDGE);

        QueueSender sender = session.createSender(queue);

        /* 创建消息 */
        String msgContent = "I am Lv Yahui";

        TextMessage textMsg = session.createTextMessage(msgContent);

        /* 发送消息 */
        sender.send(textMsg);

    }
}
