package activeMQStu.queue;

import activeMQStu.ActiveMQServer;
import activeMQStu.User;

import javax.jms.JMSException;
import javax.jms.MessageConsumer;
import javax.jms.ObjectMessage;

/**
 * Created by lvyahui on 2016/4/23.
 */
public class UserConsumer {
    private MessageConsumer consumer;

    public UserConsumer(ActiveMQServer activeMQServer,String queueName) throws JMSException {
        this.consumer = activeMQServer.getSession()
                .createConsumer(activeMQServer.createQueue(queueName));
    }

    public User consume() throws JMSException {
        ObjectMessage objectMessage  = (ObjectMessage) consumer.receive();
        User user = (User) objectMessage.getObject();
        return user;
    }
}
