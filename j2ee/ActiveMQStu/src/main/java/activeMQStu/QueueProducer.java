package activeMQStu;

import org.apache.activemq.ActiveMQConnection;
import org.apache.activemq.ActiveMQConnectionFactory;
import org.apache.activemq.command.ActiveMQObjectMessage;

import javax.jms.*;

/**
 * Created by lvyahui on 2016/4/23.
 */
public class QueueProducer {
    public static final String USER = ActiveMQConnection.DEFAULT_USER;
    public static final String PASS = ActiveMQConnection.DEFAULT_PASSWORD;

    public static final String URL = "tcp://localhost:61616";

    public static void main(String[] args) throws JMSException {
        ConnectionFactory connectionFactory = new ActiveMQConnectionFactory(USER, PASS, URL);
        Connection connection = connectionFactory.createConnection();

        connection.start();

        System.out.println("Connection is start ...");

        Session session = connection.createSession(true, Session.AUTO_ACKNOWLEDGE);

        Queue distQueue = session.createQueue("queue.devlyh");


        MessageProducer producer = session.createProducer(distQueue);

        /*持久化,对消息存储，保证至少发送成功和使用成功一次*/
        producer.setDeliveryMode(DeliveryMode.PERSISTENT);

        for (int i = 0; i < 100; i++){
            ObjectMessage objectMessage = new ActiveMQObjectMessage();
            User user = new User();
            user.setUsername("lvyahui".concat(String.valueOf(i)));
            user.setPassword("admin888" + i);
            user.setSalt("salt"+i);
            objectMessage.setObject(user);
            producer.send(objectMessage);
        }
        producer.close();
        session.commit();
        session.close();
        connection.close();
    }
}
