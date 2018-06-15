package com.cetiti.dsp.service.impl;

import com.cetiti.dsp.dao.TopicDao;
import com.cetiti.dsp.entity.Topic;
import com.cetiti.core.activeMQ.service.TopicManage;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jms.core.JmsTemplate;
import org.springframework.jms.core.SessionCallback;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import javax.jms.Destination;
import javax.jms.JMSException;
import javax.jms.Session;
import java.util.List;

@Service("TopicManage")
public class TopicManageImpl implements TopicManage {

    @Autowired
    private JmsTemplate jmsTopicTemplate;

    @Resource
    private TopicDao topicDao;
    /**
     * 1.添加主题到数据库中
     * 2.MQ中创建主题
     * */
    @Override
    public int insertTopicInfo(final Topic topic) {


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
