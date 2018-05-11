import com.cetiti.core.activeMQ.service.ProducerManage;
import com.cetiti.core.activeMQ.service.TopicManage;
import com.cetiti.dsp.dao.PersonGpsDao;
import com.cetiti.dsp.entity.PersonGps;
import com.cetiti.dsp.entity.Producer;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

public class producerManageTest extends BaseTest {
    @Autowired
    TopicManage topicManage;
    @Autowired
    PersonGpsDao personGpsDao;
    @Autowired
    ProducerManage producerManage;


    @Test
    public void testSendMessage(){
        Producer producer = new Producer();
        List<PersonGps> list = personGpsDao.queryAll();
        producer.setTopicName("test");
        producerManage.sendCommonMessage(producer,"message_1",list);
    }
}
