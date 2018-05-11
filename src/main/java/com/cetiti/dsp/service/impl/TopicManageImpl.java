package com.cetiti.dsp.service.impl;

import com.cetiti.dsp.dao.TopicDao;
import com.cetiti.dsp.entity.Topic;
import com.cetiti.core.activeMQ.service.TopicManage;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jms.core.JmsTemplate;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import javax.jms.JMSException;
import javax.jms.Session;
import java.util.List;

@Service("TopicManage")
public class TopicManageImpl implements TopicManage {

    @Autowired
    private JmsTemplate jmsTopicTemplate;
    private javax.jms.Topic jmsTopic;

    @Resource
    private TopicDao topicDao;
    /**
     * 1.添加主题到数据库中
     * 2.MQ中创建主题
     * */
    @Override
    public int insertTopicInfo(Topic topic) {
        //1.添加主题到数据库中
        //int result = topicDao.insertTopicInfo(topic);
        //2.MQ中创建主题
        try {
            jmsTopic = jmsTopicTemplate.getConnectionFactory()
                                .createConnection()
                                .createSession(false, Session.AUTO_ACKNOWLEDGE)
                                .createTopic(topic.getTopicName());
        } catch (JMSException e) {
            e.printStackTrace();
        }

        return 0;
    }

    @Override
    public int updateTopicInfo(Topic topic) {
        return 0;
    }

    @Override
    public int deleteTopicInfo(Topic topic) {
        return 0;
    }

    @Override
    public List<Topic> getTopicInfos(String keyWord) {
        return null;
    }
}
