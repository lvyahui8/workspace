package activeMQStu;

import org.apache.activemq.ActiveMQConnection;
import org.apache.activemq.ActiveMQConnectionFactory;

import javax.jms.*;

/**
 * Created by lvyahui on 2016/4/23.
 */
public class QueueConsumer {
    public static void main(String[] args) throws JMSException {
        ConnectionFactory connectionFactory = new ActiveMQConnectionFactory(
                ActiveMQConnection.DEFAULT_USER,
                ActiveMQConnection.DEFAULT_PASSWORD,
                "tcp://localhost:61616"
        );

        Connection connection = connectionFactory.createConnection();

        connection.start();

        final Session  session = connection.createSession(true,Session.AUTO_ACKNOWLEDGE);

        Queue distQueue = session.createQueue("queue.devlyh");

        MessageConsumer consumer = session.createConsumer(distQueue);

        while(true){
            ObjectMessage objectMessage = (ObjectMessage) consumer.receive();
            System.out.println(objectMessage.getObject());
        }
    }
}
