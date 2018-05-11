package com.cetiti.core.activeMQ.service;

import com.cetiti.dsp.entity.Topic;

import java.util.List;

/**
 * 描述：MQ主题管理
 * @author zhouliyu
 * */
public interface TopicManage {

    int insertTopicInfo(Topic topic);
    int updateTopicInfo(Topic topic);
    int deleteTopicInfo(Topic topic);
    List<Topic> getTopicInfos(String keyWord);

    /**
     * 安全机制（read,write,admin）
     * */

    /**
     * 主题统计（周期性消息接收总量）
     * */

    /**
     *
     * */

}
