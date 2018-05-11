import com.cetiti.core.activeMQ.service.ProducerManage;
import com.cetiti.core.activeMQ.service.TopicManage;
import com.cetiti.dsp.entity.Goods;
import com.cetiti.dsp.entity.Producer;
import com.cetiti.dsp.entity.Topic;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.ArrayList;
import java.util.List;

public class producerManageTest extends BaseTest {
    @Autowired
    TopicManage topicManage;
    @Autowired
    ProducerManage producerManage;


    @Test
    public void testSendMessage(){
        Topic topic = new Topic();
        Producer producer = new Producer();
        Goods goods = new Goods();
        topic.setTopicName("test");
        producer.setTopicName("test");
        goods.setGoodsId(1000l);
        goods.setTitle("ipad");
        goods.setPrice(1999);
        List<Goods> list = new ArrayList<>();
        list.add(goods);
        //topicManage.insertTopicInfo(topic);
        producerManage.sendCommonMessage(producer,"message_1",list);
    }
}
