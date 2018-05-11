package com.cetiti.dsp.dao;

import com.cetiti.dsp.entity.Topic;

import java.util.List;

public interface TopicDao {

    int insertTopicInfo(Topic topic);
    int updateTopicInfo(Topic topic);
    int deleteTopicInfo(Topic topic);
    List<Topic> getTopicInfos(String keyWord);

}
