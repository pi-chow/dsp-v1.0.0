package com.cetiti.core.activeMQ.api;

import org.apache.activemq.ActiveMQConnectionFactory;

import javax.jms.*;
import java.util.Properties;

/**
 * 描述：第三方系统接入API连接池
 * */
public class DspMqFactory {

    private static final String USERNAME = "admin";
    private static final String PASSWORD = "admin";
    private static final String BROKEN_URL = "tcp://192.168.138.130:61616";

    public static DspMqConsumer createConsumer(Properties properties){

        //授权验证appKey+appSecret
        /**
         * 描述：通过appKey+appSecret授权验证的consumerId返回用户名/密码/连接信息
         * */
        DspMqConsumer dspMqConsumer = new DspMqConsumer();
        if(properties.getProperty(PropertyKeyConst.ConsumerId) == "consumer_1"){
            if(properties.getProperty(PropertyKeyConst.AppKey) == "1e84cb6a13dd7552dc989342da902e14"){
                if(properties.getProperty(PropertyKeyConst.AppSecret) == "ce498e11fd7cdecdabbb15b816ede4c4"){
                    try {
                        ConnectionFactory connectionFactory = new ActiveMQConnectionFactory(USERNAME,PASSWORD,BROKEN_URL);
                        Connection connection  = connectionFactory.createConnection();
                        connection.start();
                        dspMqConsumer.setSession(connection.createSession(false,Session.AUTO_ACKNOWLEDGE));
                    } catch (JMSException e) {
                        e.printStackTrace();
                    }
                    return dspMqConsumer;
                }
            }
        }
        return dspMqConsumer;

    }
}
