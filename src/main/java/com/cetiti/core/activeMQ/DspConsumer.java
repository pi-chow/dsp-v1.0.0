package com.cetiti.core.activeMQ;

import com.cetiti.core.cache.ProtoStuffSerializerUtil;
import com.cetiti.dsp.entity.Goods;
import org.apache.activemq.ActiveMQConnectionFactory;

import javax.jms.*;

public class DspConsumer {
    private static final String USERNAME = "admin";
    private static final String PASSWORD = "admin";
    private static final String BROKEN_URL = "tcp://192.168.138.130:61616";

    //链接工厂
    ConnectionFactory connectionFactory;
    //链接对象
    Connection connection;
    //事务管理
    Session session;
    ThreadLocal<MessageConsumer> threadLocal = new ThreadLocal<>();

    public void init(){
        try {
            //创建一个链接工厂
            connectionFactory = new ActiveMQConnectionFactory(USERNAME,PASSWORD,BROKEN_URL);
            //从工厂中创建一个链接
            connection  = connectionFactory.createConnection();
            //开启链接
            connection.start();
            //创建一个事务（这里通过参数可以设置事务的级别）
            session = connection.createSession(false,Session.AUTO_ACKNOWLEDGE);
        } catch (JMSException e) {
            e.printStackTrace();
        }
    }

    public void getMessage(String topic, final Long[] consumerIds, final String user){
        try {
            MessageConsumer messageConsumer = null;
            Destination destination = session.createTopic(topic);
            if(threadLocal.get()!=null){
                messageConsumer = threadLocal.get();
            }else{

                messageConsumer = session.createConsumer(destination);
                threadLocal.set(messageConsumer);
            }

            //创建消息消费者(selector=>key='value')
            for(final long consumerId : consumerIds){
                messageConsumer = session.createConsumer(destination,"consumerId='"+consumerId+"'");
                messageConsumer.setMessageListener(new MessageListener() {
                    @Override
                    public void onMessage(Message message) {
                        try {
                            System.out.println("消费者"+user+"获取消息： "+consumerId+"=》"+ ProtoStuffSerializerUtil.deserialize((byte[]) ((ObjectMessage)message).getObject(), Goods.class));
                        } catch (JMSException e) {
                            e.printStackTrace();
                        }
                    }
                });
            }

        } catch (JMSException e) {
            e.printStackTrace();
        }

    }
}
