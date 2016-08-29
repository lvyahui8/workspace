package activeMQStu;

import activeMQStu.queue.UserProducer;
import org.apache.activemq.ActiveMQConnection;

import javax.jms.JMSException;

/**
 * Created by lvyahui on 2016/4/23.
 */
public class ProduceApp {
    public static void main(String[] args) throws JMSException {
        ActiveMQServer activeMQServer = new ActiveMQServer(
                ActiveMQConnection.DEFAULT_USER,
                ActiveMQConnection.DEFAULT_PASSWORD,
                "tcp://localhost:61616"
        );
        UserProducer producer = new UserProducer(activeMQServer,"queue.devlyh");
        for(int i =0 ;i < 100;i++){
            User user = new User();
            user.setUsername("lvyahui".concat(String.valueOf(i)));
            user.setPassword("admin888" + i);
            user.setSalt("salt"+i);
            producer.produce(user);
        }
        activeMQServer.close();
    }
}
