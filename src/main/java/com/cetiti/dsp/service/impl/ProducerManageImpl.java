package com.cetiti.dsp.service.impl;

import com.alibaba.fastjson.JSON;
import com.cetiti.core.activeMQ.service.ProducerManage;
import com.cetiti.core.cache.ProtoStuffSerializerUtil;
import com.cetiti.dsp.entity.Producer;
import org.apache.activemq.ActiveMQMessageProducer;
import org.apache.activemq.ActiveMQSession;
import org.apache.activemq.command.ActiveMQTopic;
import org.apache.activemq.command.ProducerId;
import org.apache.activemq.command.ProducerInfo;
import org.springframework.beans.factory.FactoryBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jms.core.JmsTemplate;
import org.springframework.jms.core.MessageCreator;
import org.springframework.stereotype.Service;

import javax.jms.*;
import java.util.List;

@Service("ProducerManage")
public class ProducerManageImpl implements ProducerManage {

    @Autowired
    private JmsTemplate jmsTopicTemplate;
    


    public static Session setSession(JmsTemplate jmsTopicTemplate,boolean var1, int var2 ) {
        Session session = null;
        try {
            session = jmsTopicTemplate.getConnectionFactory()
                    .createConnection().createSession(var1,var2);
        } catch (JMSException e) {
            e.printStackTrace();
        }
        return session;
    }

    private static String messageId = null;


    @Override
    public int insertProducerInfo(Producer producer) {
        //create producer to MQ
        Session session = ProducerManageImpl.setSession(jmsTopicTemplate,false,Session.AUTO_ACKNOWLEDGE);
        try {
            Destination destination = session.createTopic(producer.getTopicName());
            MessageProducer messageProducer = session.createProducer(destination);

        } catch (JMSException e) {
            e.printStackTrace();
        }finally {
            if(session !=null){
                try {
                    session.close();
                } catch (JMSException e) {
                    e.printStackTrace();
                }
            }
        }
        //create producer to mysql

        return 0;
    }

    @Override
    public int updateProducerInfo(Producer Producer) {
        return 0;
    }

    @Override
    public int deleteProducerInfo(Producer Producer) {

        return 0;
    }

    @Override
    public List<Producer> getProducerInfos(String keyWord) {
        return null;
    }

    @Override
    public <T> String sendCommonMessage(Producer producer, final String messageKey, final List<T> objList) {

        jmsTopicTemplate.send(producer.getTopicName(), new MessageCreator() {
            @Override
            public Message createMessage(Session session) throws JMSException {
                //创建消息(类型：json)
                StreamMessage streamMessage = session.createStreamMessage();
                streamMessage.writeString(JSON.toJSONString(objList));
                streamMessage.setStringProperty("messageKey",messageKey);
                streamMessage.setJMSMessageID(messageKey);
                messageId = streamMessage.getJMSMessageID();
                return streamMessage;
            }
        });

        return messageId;
    }
}
