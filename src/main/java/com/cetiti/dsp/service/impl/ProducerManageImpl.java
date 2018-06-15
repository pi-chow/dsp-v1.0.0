package com.cetiti.dsp.service.impl;

import com.alibaba.fastjson.JSON;
import com.cetiti.core.activeMQ.service.ProducerManage;
import com.cetiti.dsp.entity.Producer;
import org.apache.activemq.ActiveMQConnection;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jms.core.JmsTemplate;
import org.springframework.jms.core.MessageCreator;
import org.springframework.jms.core.SessionCallback;
import org.springframework.stereotype.Service;

import javax.jms.*;
import java.util.List;

@Service("ProducerManage")
public class ProducerManageImpl implements ProducerManage {

    @Autowired
    private JmsTemplate jmsTopicTemplate;

    private static String messageId = null;

    @Override
    public int insertProducerInfo(final Producer producer) {
        //produce与topic一对一
        //插入mysql=>成功，创建主题;失败，不创建主题。
        //create producer to MQ

        Boolean result = jmsTopicTemplate.execute(new SessionCallback<Boolean>() {
            @Override
            public Boolean doInJms(Session session) throws JMSException {
                Destination destination = session.createTopic(producer.getTopicName());
                //真正创建主题
                session.createProducer(destination);
                return true;
            }
        });
        System.out.println(result);
        return 0;
    }

    @Override
    public int updateProducerInfo(Producer Producer) {
        return 0;
    }

    @Override
    public int deleteProducerInfo(Producer producer) {
        try {
            Connection connection = jmsTopicTemplate.getConnectionFactory().createConnection();
        } catch (JMSException e) {
            e.printStackTrace();
        }
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
/*        String message = JSON.toJSONString(objList);
        jmsTopicTemplate.convertAndSend(producer.getTopicName(), message,
                new MessagePostProcessor() {
                    @Override
                    public Message postProcessMessage(Message message) throws JMSException {
                        message.setStringProperty("messageKey",messageKey);
                        message.setJMSMessageID(messageKey);
                        messageId = message.getJMSMessageID();
                        return message;
                    }
                });*/

        return messageId;
    }
}
