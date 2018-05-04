package com.cetiti.core.activeMQ;

import com.cetiti.core.cache.ProtoStuffSerializerUtil;
import com.dyuproject.protostuff.ProtostuffIOUtil;
import org.apache.activemq.ActiveMQConnectionFactory;

import javax.jms.*;
import java.io.Serializable;

public class DspPublisher {
    private static final String USERNAME = "admin";
    private static final String PASSWORD = "admin";
    private static final String BROKEN_URL = "tcp://192.168.138.130:61616";

    //链接工厂
    ConnectionFactory connectionFactory;
    //链接对象
    Connection connection;
    //事务管理
    Session session;
    ThreadLocal<MessageProducer> threadLocal = new ThreadLocal<>();

    public void init(){
        try {
            //创建一个链接工厂
            connectionFactory = new ActiveMQConnectionFactory(USERNAME,PASSWORD,BROKEN_URL);
            //从工厂中创建一个链接
            connection  = connectionFactory.createConnection();
            //开启链接
            connection.start();
            //创建一个事务（这里通过参数可以设置事务的级别）
            session = connection.createSession(true,Session.AUTO_ACKNOWLEDGE);
        } catch (JMSException e) {
            e.printStackTrace();
        }
    }

    public void sendMessage(String topic, Long consumerId, Object obj){
        try {
            MessageProducer messageProducer = null;
            if(threadLocal.get()!=null){
                messageProducer = threadLocal.get();
            }else{
                //创建Topic
                Destination destination = session.createTopic(topic);
                //创建消息生产者
                messageProducer = session.createProducer(destination);
                threadLocal.set(messageProducer);
            }

            //创建消息
            ObjectMessage objectMessage = session.createObjectMessage();
            //对象序列化
            objectMessage.setObject(ProtoStuffSerializerUtil.serialize(obj));
            objectMessage.setStringProperty("consumerId",Long.toString(consumerId));
            //发送消息
            messageProducer.send(objectMessage);
            //提交事务
            session.commit();
            System.out.println("发送消息： "+consumerId+"=》"+objectMessage.getObject().toString());
        } catch (JMSException e) {
            e.printStackTrace();
        }
    }
}
