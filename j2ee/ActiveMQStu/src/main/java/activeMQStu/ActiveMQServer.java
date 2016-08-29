package activeMQStu;

import org.apache.activemq.ActiveMQConnectionFactory;

import javax.jms.*;
import java.util.Arrays;

/**
 * Created by lvyahui on 2016/4/23.
 */
public class ActiveMQServer {


    private String user;
    private String pass;
    private String url;

    private Session session;
    private Connection connection;
    private ActiveMQConnectionFactory connectionFactory;

    public ActiveMQConnectionFactory getConnectionFactory() {
        return connectionFactory;
    }

    public ActiveMQServer(String user, String pass, String url) throws JMSException {
        this.user = user;
        this.pass = pass;
        this.url = url;

        this.connectionFactory = new ActiveMQConnectionFactory(this.user, this.pass, this.url);
        /*
        * 必须指明哪些包的类是可以序列化的
        * 否则会报错：ActiveMQ Serializable class not available to broker. Reason: ClassNotFoundException
        * 参考：http://activemq.apache.org/objectmessage.html
        * */
        connectionFactory.setTrustedPackages(Arrays.asList("activeMQStu"));
        this.connection = connectionFactory.createConnection();
        connection.start();
    }

    public Session getSession() throws JMSException {
        if (session == null) {
            session = connection.createSession(true, Session.AUTO_ACKNOWLEDGE);
        }
        return session;
    }

    public Queue createQueue(String name) throws JMSException {
        return getSession().createQueue(name);
    }

    public void close() throws JMSException {
        if (session != null) {
            session.commit();
            session.close();
        }
        if (connection != null) {
            connection.close();
        }
    }

}
