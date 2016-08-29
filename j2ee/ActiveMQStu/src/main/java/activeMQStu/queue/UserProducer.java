package activeMQStu.queue;

import activeMQStu.ActiveMQServer;
import activeMQStu.User;
import org.apache.activemq.command.ActiveMQObjectMessage;

import javax.jms.JMSException;
import javax.jms.MessageProducer;
import javax.jms.ObjectMessage;
import javax.jms.Queue;

/**
 * Created by lvyahui on 2016/4/23.
 */
public class UserProducer {

    private MessageProducer producer;

    public UserProducer(ActiveMQServer activeMQServer, String queueName) throws JMSException {
        Queue queue = activeMQServer.createQueue(queueName);
        producer = activeMQServer.getSession().createProducer(queue);
    }

    public void produce(User user) throws JMSException {
        ObjectMessage objectMessage = new ActiveMQObjectMessage();
        objectMessage.setObject(user);
        producer.send(objectMessage);
    }
}
