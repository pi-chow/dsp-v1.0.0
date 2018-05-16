package com.cetiti.core.activeMQ.api;


import org.apache.activemq.command.ActiveMQTopic;

import javax.jms.*;

public class DspMqConsumer {
    private Session session;

    protected Session getSession() {
        return session;
    }

    protected void setSession(Session session) {
        this.session = session;
    }

    public void subscribe(String topic, final String messageKey) {

        ActiveMQTopic activeMQTopic = new ActiveMQTopic();
        activeMQTopic.setPhysicalName(topic);

        try {
            MessageConsumer messageConsumer = session.createConsumer(activeMQTopic,"messageKey='"+messageKey+"'");
            messageConsumer.setMessageListener(new MessageListener() {
                @Override
                public void onMessage(Message message) {
                    try {
                        System.out.println("获取消息： " + messageKey + "=》" +
                                ((StreamMessage)message).readString());
                    } catch (JMSException e) {
                        e.printStackTrace();
                    }
                }
            });
        } catch (JMSException e) {
            e.printStackTrace();
        } finally {
            if(session != null){
                try {
                    session.close();
                } catch (JMSException e) {
                    e.printStackTrace();
                }
            }
        }
    }

}
