import com.cetiti.core.activeMQ.api.DspMqConsumer;
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
        DspMqConsumer dspMqConsumer = DspMqFactory.createConsumer(properties);
        new Thread(new DspMqConsumerMq("test","message_1", dspMqConsumer)).start();
    }

    private class DspMqConsumerMq implements Runnable{
        DspMqConsumer dspMqConsumer = new DspMqConsumer();
        private String topic;
        private String messageKey;

        public DspMqConsumerMq(String topic, String messageKey, DspMqConsumer dspMqConsumer) {
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
