package com.cetiti.dsp.service.impl;

import com.cetiti.core.activeMQ.service.ProducerManage;
import com.cetiti.core.cache.ProtoStuffSerializerUtil;
import com.cetiti.dsp.entity.Producer;
import org.apache.activemq.command.ActiveMQTopic;
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



    private static String messageId = null;

    @Override
    public int insertProducerInfo(Producer Producer) {
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

        ActiveMQTopic activeMQTopic = new ActiveMQTopic();
        activeMQTopic.setPhysicalName(producer.getTopicName());

        jmsTopicTemplate.send(activeMQTopic, new MessageCreator() {
            @Override
            public Message createMessage(Session session) throws JMSException {
                //创建消息
                ObjectMessage objectMessage = session.createObjectMessage();
                //对象序列化
                objectMessage.setObject(ProtoStuffSerializerUtil.serializeList(objList));
                objectMessage.setStringProperty("messageKey",messageKey);
                messageId = objectMessage.getJMSMessageID();
                return objectMessage;
            }
        });

        return messageId;
    }
}
