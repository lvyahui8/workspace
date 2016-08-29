package activeMQStu;

import activeMQStu.queue.UserConsumer;
import org.apache.activemq.ActiveMQConnection;
import org.apache.activemq.ActiveMQConnectionFactory;

import javax.jms.JMSException;
import java.util.Arrays;

/**
 * Created by lvyahui on 2016/4/23.
 */
public class ConsumeApp {
    public static void main(String[] args) throws JMSException {
        ActiveMQServer activeMQServer = new ActiveMQServer(
                ActiveMQConnection.DEFAULT_USER,
                ActiveMQConnection.DEFAULT_PASSWORD,
                "tcp://localhost:61616"
        );

//        ActiveMQConnectionFactory factory = (ActiveMQConnectionFactory) activeMQServer.getConnectionFactory();

        UserConsumer consumer = new UserConsumer(activeMQServer,"queue.devlyh");
        while(true){
            User user = consumer.consume();
            System.out.println(user);
        }
    }
}
