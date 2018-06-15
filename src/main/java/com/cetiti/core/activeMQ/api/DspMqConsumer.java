package com.cetiti.core.activeMQ.api;


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
        try {
            Destination destination = session.createTopic(topic);
            MessageConsumer messageConsumer = session.createConsumer(destination,"messageKey='"+messageKey+"'");
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
        }
    }

}
