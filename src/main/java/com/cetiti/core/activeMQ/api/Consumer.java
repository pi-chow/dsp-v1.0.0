package com.cetiti.core.activeMQ.api;


import com.cetiti.core.cache.ProtoStuffSerializerUtil;
import com.cetiti.dsp.entity.Goods;
import org.apache.activemq.command.ActiveMQTopic;

import javax.jms.*;

public class Consumer {
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
                        System.out.println("获取消息： " + messageKey + "=》" + ProtoStuffSerializerUtil.deserializeList((byte[]) ((ObjectMessage) message).getObject(), Goods.class));
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
