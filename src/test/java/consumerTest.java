import com.cetiti.core.activeMQ.api.Consumer;
import com.cetiti.core.activeMQ.api.DspMqFactory;
import com.cetiti.core.activeMQ.api.PropertyKeyConst;
import org.junit.Test;

import java.util.Properties;

public class consumerTest extends BaseTest {
    @Test
    public void testSubscribe(){
        Properties properties = new Properties();
        properties.put(PropertyKeyConst.ConsumerId,"consumer_1");
        properties.put(PropertyKeyConst.AppKey,"1e84cb6a13dd7552dc989342da902e14");
        properties.put(PropertyKeyConst.AppSecret,"ce498e11fd7cdecdabbb15b816ede4c4");
        Consumer consumer = DspMqFactory.createConsumer(properties);
        new Thread(new ConsumerMq("test","message_1",consumer)).start();
    }

    private class ConsumerMq implements Runnable{
        Consumer consumer = new Consumer();
        private String topic;
        private String messageKey;

        public ConsumerMq(String topic, String messageKey,Consumer consumer) {
            this.topic = topic;
            this.messageKey = messageKey;
            this.consumer = consumer;
        }

        @Override
        public void run() {
            consumer.subscribe(topic,messageKey);
        }
    }
}
