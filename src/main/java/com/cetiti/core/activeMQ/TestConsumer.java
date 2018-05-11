package com.cetiti.core.activeMQ;

import com.cetiti.core.activeMQ.api.DspMqConsumer;
import com.cetiti.core.activeMQ.api.DspMqFactory;
import com.cetiti.core.activeMQ.api.PropertyKeyConst;

import java.util.Properties;

public class TestConsumer {
    public static void main(String[] args){
        Properties properties = new Properties();
        properties.put(PropertyKeyConst.ConsumerId,"consumer_1");
        properties.put(PropertyKeyConst.AppKey,"1e84cb6a13dd7552dc989342da902e14");
        properties.put(PropertyKeyConst.AppSecret,"ce498e11fd7cdecdabbb15b816ede4c4");
        DspMqConsumer dspMqConsumer = DspMqFactory.createConsumer(properties);
        new Thread(new ConsumerMq("test","message_1", dspMqConsumer)).start();
    }


    private static class ConsumerMq implements Runnable{
        DspMqConsumer dspMqConsumer = new DspMqConsumer();
        private String topic;
        private String messageKey;

        private ConsumerMq(String topic, String messageKey,DspMqConsumer dspMqConsumer) {
            this.topic = topic;
            this.messageKey = messageKey;
            this.dspMqConsumer = dspMqConsumer;
        }

        @Override
        public void run() {
            dspMqConsumer.subscribe(topic,messageKey);
        }
    }
}
