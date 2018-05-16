package com.cetiti.core.activeMQ;

import org.springframework.jms.core.JmsTemplate;

import javax.jms.JMSException;
import javax.jms.Session;

public class MqFactory {
    private Session session;

    public Session getSession() {
        return session;
    }

    public void setSession(JmsTemplate jmsTopicTemplate,boolean var1, int var2 ) {
        try {
            this.session = jmsTopicTemplate.getConnectionFactory()
                    .createConnection().createSession(var1,var2);
        } catch (JMSException e) {
            e.printStackTrace();
        }
    }
}
