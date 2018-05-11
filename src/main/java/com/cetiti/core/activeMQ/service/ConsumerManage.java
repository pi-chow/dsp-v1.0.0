package com.cetiti.core.activeMQ.service;

import com.cetiti.dsp.entity.Consumer;

import java.util.List;

/**
 * /**
 * 描述：MQ消息消费者管理
 * @author zhouliyu
 * */

public interface ConsumerManage {
    int insertConsumerInfo(Consumer consumer);
    int updateConsumerInfo(Consumer consumer);
    int deleteConsumerInfo(Consumer consumer);
    List<Consumer> getConsumerInfos(String keyWord);

    /**
     * 消费消息
     * 功能：广播消费
     * */
    <T> List<T> onCommonMessage(Consumer consumer, String messageKey,final Class<T> targetClass);
}
