package jms.net;

/**
 * Created by lvyahui on 2016/4/23.
 */
public class MsgServer {
    public static final String INIT_FACTORY_CLASS = "weblogic.jndi.WLInitialContextFactory";
    public static final String URL = "t3://localhost:7001";
    public static final String  CONN_FACTORY_JNDI_NAME = "jmsConnectionFactoryJndiName";
    public static final String QUEUE_JNDI_NAME = "queueJndiName";
}
